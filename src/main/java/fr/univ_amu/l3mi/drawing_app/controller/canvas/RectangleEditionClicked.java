package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;

public class RectangleEditionClicked implements ContextState {


    private final Point2D pointClicked;

    public RectangleEditionClicked(Point2D pointClicked) {
        this.pointClicked = pointClicked;
    }

    public void paint(CanvasControllerContext context, CanvasView view) {
        Point2D mouse = context.getMousePoint();
        if (mouse == null) {
            return;
        }

        double topLeftX = Math.min(pointClicked.getX(), mouse.getX());
        double topLeftY = Math.min(pointClicked.getY(), mouse.getY());
        double width = Math.abs(pointClicked.getX() - mouse.getX());
        double height = Math.abs(pointClicked.getY() - mouse.getY());

        Point2D topLeftCorner = new Point2D(topLeftX, topLeftY);

        view.drawRectangle(topLeftCorner, width, height,
                context.getFillColor(),
                context.getStrokeColor(),
                context.getStrokeWidth());
    }

    @Override
    public void actionOnLeftMouseReleased(CanvasControllerContext context, double x, double y) {
        Point2D pointReleased = new Point2D(x, y);

        Shape newRectangle = new Rectangle(pointClicked, pointReleased,
                context.getFillColor(),
                context.getStrokeColor(),
                context.getStrokeWidth());

        context.addShape(newRectangle);
        context.changeState(new RectangleEdition());

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