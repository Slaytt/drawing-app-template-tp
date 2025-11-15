package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.model.Circle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;


public class CircleEditionClicked implements ContextState {

    private final Point2D pointClicked;

    private static final int GHOST_CROSS_STROKE_WIDTH = 2;
    private static final int GHOST_CROSS_LENGTH = 10;
    private static final Color GHOST_COLOR = new Color(0.5, 0.5, 0.5, 0.5);

    public CircleEditionClicked(Point2D pointClicked) {
        this.pointClicked = pointClicked;
    }

    private void drawGhostCross(CanvasView view) {
        Point2D p1 = pointClicked.add(new Point2D(GHOST_CROSS_LENGTH, 0));
        Point2D p2 = pointClicked.add(new Point2D(-GHOST_CROSS_LENGTH, 0));
        view.drawLine(p1, p2, GHOST_COLOR, GHOST_CROSS_STROKE_WIDTH);

        Point2D p3 = pointClicked.add(new Point2D(0, GHOST_CROSS_LENGTH));
        Point2D p4 = pointClicked.add(new Point2D(0, -GHOST_CROSS_LENGTH));
        view.drawLine(p3, p4, GHOST_COLOR, GHOST_CROSS_STROKE_WIDTH);
    }

    @Override
    public void paint(CanvasControllerContext context, CanvasView view) {
        drawGhostCross(view);

        Point2D mouse = context.getMousePoint();
        if (mouse == null) {
            return;
        }
        double radius = pointClicked.distance(mouse);

        view.drawCircle(pointClicked, radius,
                context.getFillColor(),
                context.getStrokeColor(),
                context.getStrokeWidth());
    }

    @Override
    public void actionOnLeftMouseReleased(CanvasControllerContext context, double x, double y) {
        Point2D pointReleased = new Point2D(x, y);

        Shape newCircle = new Circle(pointClicked, pointReleased,
                context.getFillColor(),
                context.getStrokeColor(),
                context.getStrokeWidth());

        context.addShape(newCircle);
        context.changeState(new CircleEdition());

        context.changeState(new CircleEdition(this.pointClicked));

        context.repaint();
    }

    @Override
    public void actionOnLeftMousePressed(CanvasControllerContext context, double x, double y) {
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