## DigitsClassifier

An app which classifies digit from 0-9 using a Tensorflow Lite model. The input bitmaps are taken from the user by drawing or camera.
Features :-
1. Retrained mobilenet_0.50_224 TF model for  MNIST dataset.
2. Implemented [Drawing View](https://github.com/Raed-Mughaus/DrawingView) library to take inputs.
3. Can take inputs from camera to be classified as a digit.
4. Shows what digit the input image is most likely to be and confidences of all digit classes.


Currently, the accuracy is considerably less for some digits and following could be the reasons :-
* The difference between the MNIST dataset images and the input images.
* The TF model's incompetency to classify digits (unlikely).
<br>
Hence in the next approach to classify digits with better accuracy I'll retrain the TF model with dataset created through this app.
Therefore, I added a utility in the app to save images from the drawing activity which will later be used to retrain the model.
