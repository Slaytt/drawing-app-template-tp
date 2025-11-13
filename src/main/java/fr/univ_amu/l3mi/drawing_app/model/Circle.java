package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Circle extends AbstractShape {

    public Circle(Point2D center, Point2D onCircle, Color fillColor, Color strokeColor, double strokeWidth) {
        super(fillColor, strokeColor, strokeWidth);
        addPoints(center, onCircle);
    }

    @Override
    public <R> R accept(ShapeVisitor<R> visitor) {
        return null;
    }

    public Point2D getCenter() {
        return getPoint(0);
    }

    public double getRadius() {
        return getPoint(0).distance(getPoint(1));
    }
}