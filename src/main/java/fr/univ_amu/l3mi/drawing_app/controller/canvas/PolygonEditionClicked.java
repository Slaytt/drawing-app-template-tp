package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.model.Polygon;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class PolygonEditionClicked implements ContextState {

    private final List<Point2D> pointsClicked;

    public PolygonEditionClicked(Point2D firstPoint) {
        this.pointsClicked = new ArrayList<>();
        this.pointsClicked.add(firstPoint);
    }

    @Override
    public void paint(CanvasControllerContext context, CanvasView view) {
        Point2D mouse = context.getMousePoint();
        if (mouse == null) { return; }

        Point2D[] previewPoints = new Point2D[pointsClicked.size() + 1];
        for (int i = 0; i < pointsClicked.size(); i++) {
            previewPoints[i] = pointsClicked.get(i);
        }
        previewPoints[pointsClicked.size()] = mouse;

        view.drawPolygon(previewPoints,
                context.getFillColor(),
                context.getStrokeColor(),
                context.getStrokeWidth());
    }

    @Override
    public void actionOnLeftMousePressed(CanvasControllerContext context, double x, double y) {
        this.pointsClicked.add(new Point2D(x, y));
        context.repaint();
    }

    @Override
    public void actionOnRightMousePressed(CanvasControllerContext context, double x, double y) {
        this.pointsClicked.add(new Point2D(x, y));

        Shape newPolygon = new Polygon(this.pointsClicked,
                context.getFillColor(),
                context.getStrokeColor(),
                context.getStrokeWidth());

        context.addShape(newPolygon);
        context.changeState(new PolygonEdition());
        context.repaint();
    }

    @Override
    public void actionOnMouseMoved(CanvasControllerContext context, double x, double y) {
        context.repaint();
    }

    @Override
    public void actionOnLeftMouseReleased(CanvasControllerContext context, double x, double y) {}
    @Override
    public void actionOnRightMouseReleased(CanvasControllerContext context, double x, double y) {}
}