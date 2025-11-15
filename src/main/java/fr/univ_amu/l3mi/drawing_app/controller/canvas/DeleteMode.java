package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.List;

public class DeleteMode implements ContextState {
    private static final int CROSS_STROKE_WIDTH = 2;
    private static final int CROSS_LENGTH = 10;

    public DeleteMode() {
    }

    private void strokeDeleteCross(CanvasControllerContext context, CanvasView view) {
        Point2D mouse = context.getMousePoint();
        if (mouse == null) { return; }

        Point2D p1 = mouse.add(new Point2D(CROSS_LENGTH, 0));
        Point2D p2 = mouse.add(new Point2D(-CROSS_LENGTH, 0));
        view.drawLine(p1, p2, Color.RED, CROSS_STROKE_WIDTH);

        Point2D p3 = mouse.add(new Point2D(0, CROSS_LENGTH));
        Point2D p4 = mouse.add(new Point2D(0, -CROSS_LENGTH));
        view.drawLine(p3, p4, Color.RED, CROSS_STROKE_WIDTH);
    }

    @Override
    public void paint(CanvasControllerContext context, CanvasView view) {
        strokeDeleteCross(context, view);
    }

    @Override
    public void actionOnLeftMousePressed(CanvasControllerContext context, double x, double y) {
        List<Shape> shapesToDelete = context.shapesContaining(new Point2D(x, y));

        for (Shape shape : shapesToDelete) {
            context.remove(shape);
        }

        if (!shapesToDelete.isEmpty()) {
            context.repaint();
        }
    }

    @Override
    public void actionOnMouseMoved(CanvasControllerContext context, double x, double y) {
        context.repaint();
    }

    @Override
    public void actionOnLeftMouseReleased(CanvasControllerContext context, double x, double y) {}
    @Override
    public void actionOnRightMousePressed(CanvasControllerContext context, double x, double y) {}
    @Override
    public void actionOnRightMouseReleased(CanvasControllerContext context, double x, double y) {}
}