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
        Point2D topLeftCorner = new Point2D(x, y);
        Point2D bottomRightCorner = new Point2D(x + width, y + height);
        addPoints(topLeftCorner, bottomRightCorner);
    }

    public Point2D getTopLeftCorner() {
        return getPoint(0);
    }

    public double getWidth(){
        return getPoint(1).getX() - getPoint(0).getX();
    }

    public double getHeight(){
        return getPoint(1).getY() - getPoint(0).getY();
    }

    @Override
    public <R> R accept(ShapeVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean contains(Point2D point) {
        return point.getX() >= getPoint(0).getX() && point.getX() <= getPoint(1).getX() &&
                point.getY() >= getPoint(0).getY() && point.getY() <= getPoint(1).getY();
    }
}
