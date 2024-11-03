package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Rectangle extends AbstractShape {

    public Rectangle(Point2D corner, Point2D oppositeCorner, Color fillColor, Color stokeColor, double strokeWidth) {
        super(fillColor, stokeColor, strokeWidth);
        double x = Math.min(corner.getX(), oppositeCorner.getX());
        double y = Math.min(corner.getY(), oppositeCorner.getY());
        double width = Math.abs(corner.getX() - oppositeCorner.getX());
        double height = Math.abs(corner.getY() - oppositeCorner.getY());
        Point2D upperLeftCorner = new Point2D(x, y);
        Point2D lowerRightCorner = new Point2D(x + width, y + height);
        addPoints(upperLeftCorner, lowerRightCorner);
    }

    @Override
    public <R> R accept(ShapeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
