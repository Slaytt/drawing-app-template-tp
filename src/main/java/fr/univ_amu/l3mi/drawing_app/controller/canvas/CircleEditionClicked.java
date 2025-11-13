package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.model.Circle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;


public class CircleEditionClicked implements ContextState {

    private final Point2D pointClicked; // (Le centre)

    public CircleEditionClicked(Point2D pointClicked) {
        this.pointClicked = pointClicked;
    }

    @Override
    public void paint(CanvasControllerContext context, CanvasView view) {
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