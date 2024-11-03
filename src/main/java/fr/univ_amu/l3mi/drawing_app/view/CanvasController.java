package fr.univ_amu.l3mi.drawing_app.view;

public interface CanvasController {
    void actionOnLeftMousePressed(double x, double y);

    void actionOnLeftMouseReleased(double x, double y);

    void actionOnRightMousePressed(double x, double y);

    void actionOnRightMouseReleased(double x, double y);

    void actionOnMouseMoved(double x, double y);
}
