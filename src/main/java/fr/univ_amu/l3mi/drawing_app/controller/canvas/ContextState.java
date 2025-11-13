package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.view.CanvasView;

public interface ContextState {

    void paint(CanvasControllerContext context, CanvasView view);

    void actionOnLeftMousePressed(CanvasControllerContext context, double x, double y);

    void actionOnLeftMouseReleased(CanvasControllerContext context, double x, double y);

    void actionOnRightMousePressed(CanvasControllerContext context, double x, double y);

    void actionOnRightMouseReleased(CanvasControllerContext context, double x, double y);

    void actionOnMouseMoved(CanvasControllerContext context, double x, double y);
}
