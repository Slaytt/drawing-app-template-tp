package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.model.ShapeVisitor;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.List;

public abstract class DrawVisitor implements ShapeVisitor<Void> {
    protected final DrawingAppView view;

    public void drawShapes(List<Shape> shapes) {
        shapes.forEach(this::visit);
    }

    public DrawVisitor(DrawingAppView view) {
        this.view = view;
    }

    @Override
    public Void visit(Rectangle r) {
        Point2D upperLeftCorner = r.point(0);
        Point2D lowerRightCorner = r.point(1);
        double x = upperLeftCorner.getX();
        double y = upperLeftCorner.getY();
        double width = lowerRightCorner.getX() - x;
        double height = lowerRightCorner.getY() - y;
        Color color = r.getColor();
        drawRectangle(new Point2D(x,y), width, height, color);
        return null;
    }

    protected abstract void drawRectangle(Point2D leftTopCorner, double width, double height, Color color);

    private void visit(Shape shape) {
        shape.accept(this);
    }
}
