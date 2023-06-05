import cv2
import numpy as np
import os
import tensorflow as tf
from tensorflow.keras.models import load_model

DIR_KNOWNS = 'knowns'
DIR_UNKNOWNS = 'unknowns'
DIR_RESULTS = 'results'

face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

facenet = load_model('facenet_keras.h5')

def load_image(dir, name):
    return cv2.cvtColor(cv2.imread(os.path.join(dir, name)), cv2.COLOR_BGR2RGB)

def draw_box(image, box, color, line_width=6):
    if box == []:
        return image
    else:
        cv2.rectangle(image, (box[0], box[2]), (box[1], box[3]), color, line_width)
    return image

def extract_faces(image, bboxes, new_size=(160, 160)):
    cropped_faces = []
    for box in bboxes:
        left, right, top, bottom = box
        face = image[top:bottom, left:right]
        cropped_faces.append(cv2.resize(face, dsize=new_size))
    return cropped_faces

def compute_embedding(model, face):
    face = face.astype('float32')
    
    mean, std = face.mean(), face.std()
    face = (face - mean) / std
    
    face = np.expand_dims(face, axis=0)
    
    embedding = model.predict(face)
    return embedding

def compare_faces(embs_ref, emb_desc, umbral=11):
    distancias = []
    for emb_ref in embs_ref:
        distancias.append(np.linalg.norm(emb_ref - emb_desc))
    distancias = np.array(distancias)
    return distancias, list(distancias <= umbral)

known_embeddings = []
print('Procesando rostros conocidos...')
for name in os.listdir(DIR_KNOWNS):
    if name.endswith('.jpg'):
        print(f'   {name}')
        image = load_image(DIR_KNOWNS, name)
        gray = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)
        faces = face_cascade.detectMultiScale(gray, 1.1, 4)
        if len(faces) > 0:
            face = extract_faces(image, faces)[0]
            known_embeddings.append(compute_embedding(facenet, face))

print('Procesando imágenes desconocidas...')
for name in os.listdir(DIR_UNKNOWNS):
    if name.endswith('.jpg'):
        print(f'   {name}')
        image = load_image(DIR_UNKNOWNS, name)
        gray = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)
        faces = face_cascade.detectMultiScale(gray, 1.1, 4)
        img_with_boxes = image.copy()
        for face, box in zip(extract_faces(image, faces), faces):
            emb = compute_embedding(facenet, face)
            _, reconocimiento = compare_faces(known_embeddings, emb)
            if any(reconocimiento):
                img_with_boxes = draw_box(img_with_boxes, box, (0, 255, 0))
            else:
                img_with_boxes = draw_box(img_with_boxes, box, (255, 0, 0))
        cv2.imwrite(os.path.join(DIR_RESULTS, name), cv2.cvtColor(img_with_boxes, cv2.COLOR_RGB2BGR))

