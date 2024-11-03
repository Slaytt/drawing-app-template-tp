package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.model.ShapeVisitor;
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
        Point2D upperLeftCorner = rectangle.getPoint(0);
        Point2D lowerRightCorner = rectangle.getPoint(1);
        double width = lowerRightCorner.getX() - upperLeftCorner.getX();
        double height = lowerRightCorner.getY() - upperLeftCorner.getY();
        Color fillColor = rectangle.getFillColor();
        Color strokeColor = rectangle.getStrokeColor();
        view.drawRectangle(upperLeftCorner, width, height, fillColor, strokeColor, rectangle.getStrokeWidth());
        return null;
    }

    private void visit(Shape shape) {
        shape.accept(this);
    }
}
