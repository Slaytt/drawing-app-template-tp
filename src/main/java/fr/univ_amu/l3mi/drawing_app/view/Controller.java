package fr.univ_amu.l3mi.drawing_app.view;


import javafx.scene.paint.Color;

public interface Controller<V> {
    void actionOnLeftMousePressed(double x, double y);

    void actionOnLeftMouseReleased(double x, double y);

    void actionOnRightMousePressed(double x, double y);

    void actionOnRightMouseReleased(double x, double y);

    void actionOnMouseMoved(double x, double y);

    void actionOnKeyPressed(String key);

    void buttonActionOnClick(String buttonId);

    void initializeViewOnStart(V view);

    void colorPicked(String id, Color color);

    void choicePicked(String id, String choice);
}
