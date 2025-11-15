package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.model.*;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawVisitor implements ShapeVisitor<Void> {
    protected final CanvasView view;

    public void drawShapes(List<Shape> shapes) {
        shapes.forEach(this::visit);
    }

    public DrawVisitor(CanvasView view) {
        this.view = view;
    }

    @Override
    public Void visit(Rectangle rectangle) {
        Point2D topLeftCorner = rectangle.getTopLeftCorner();
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();
        Color fillColor = rectangle.getFillColor();
        Color strokeColor = rectangle.getStrokeColor();
        view.drawRectangle(topLeftCorner, width, height, fillColor, strokeColor, rectangle.getStrokeWidth());
        return null;
    }

    private void visit(Shape shape) {
        shape.accept(this);
    }

    @Override
    public Void visit(Circle c) {
        view.drawCircle(c.getCenter(), c.getRadius(),c.getFillColor(), c.getStrokeColor(), c.getStrokeWidth());
        return null;
    }

    @Override
    public Void visit(Polygon p) {
        view.drawPolygon(p.getPoints(), p.getFillColor(), p.getStrokeColor(), p.getStrokeWidth());
        return null;
    }
}
