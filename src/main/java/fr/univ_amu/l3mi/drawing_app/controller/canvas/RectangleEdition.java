package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class RectangleEdition implements ContextState {

    private static final int CROSS_LENGTH = 10;
    private static final int CROSS_LINE_WIDTH = 2;
    public RectangleEdition() {
    }


    private void strokeCross(CanvasControllerContext context, CanvasView view) {
        Point2D mouse = context.getMousePoint();
        if (mouse == null) {
            return;
        }
        Point2D p1 = mouse.add(new Point2D(CROSS_LENGTH, 0));
        Point2D p2 = mouse.add(new Point2D(-CROSS_LENGTH, 0));
        view.drawLine(p1, p2, Color.BLACK, CROSS_LINE_WIDTH);

        Point2D p3 = mouse.add(new Point2D(0, CROSS_LENGTH));
        Point2D p4 = mouse.add(new Point2D(0, -CROSS_LENGTH));
        view.drawLine(p3, p4, Color.BLACK, CROSS_LINE_WIDTH);
    }

    @Override
    public void paint(CanvasControllerContext context, CanvasView view) {
        strokeCross(context, view);
    }

    @Override
    public void actionOnLeftMousePressed(CanvasControllerContext context, double x, double y) {
        context.changeState(new RectangleEditionClicked(new Point2D(x, y)));
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
        context.repaint();
    }
}