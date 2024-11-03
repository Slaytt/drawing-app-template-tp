package fr.univ_amu.l3mi.drawing_app.view;


import javafx.scene.paint.Color;

public interface Controller<V> extends CanvasController{

    void actionOnKeyPressed(String key);

    void buttonActionOnClick(String buttonId);

    void initializeViewOnStart(V view);

    void colorPicked(String id, Color color);

    void choicePicked(String id, String choice);
}
