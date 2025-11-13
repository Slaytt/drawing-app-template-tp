package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.view.CanvasView;

public class ViewerMode implements ContextState {

    public ViewerMode() {
    }

    @Override
    public void paint(CanvasControllerContext context, CanvasView view) {
    }

    @Override
    public void actionOnLeftMousePressed(CanvasControllerContext context, double x, double y) {
    }

    @Override
    public void actionOnLeftMouseReleased(CanvasControllerContext context, double x, double y) {
    }

    @Override
    public void actionOnRightMousePressed(CanvasControllerContext context, double x, double y) {
    }

    @Override
    public void actionOnRightMouseReleased(CanvasControllerContext context, double x, double y) {
    }

    @Override
    public void actionOnMouseMoved(CanvasControllerContext context, double x, double y) {
    }
}