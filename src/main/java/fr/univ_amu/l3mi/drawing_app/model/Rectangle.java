package fr.univ_amu.l3mi.drawing_app.model;

import fr.univ_amu.l3mi.drawing_app.view.Color;
import javafx.geometry.Point2D;

public class Rectangle extends AbstractShape {

    public Rectangle(Point2D corner, Point2D oppositeCorner, Color color) {
        super(color);
        double x = Math.min(corner.getX(), oppositeCorner.getX());
        double y = Math.min(corner.getY(), oppositeCorner.getY());
        double width = Math.abs(corner.getX() - oppositeCorner.getX());
        double height = Math.abs(corner.getY() - oppositeCorner.getY());
        addPoints(new Point2D(x,y), new Point2D(x + width, y + height));
    }

    @Override
    public boolean contains(Point2D point) {
        return false;
    }

    @Override
    public <R> R accept(ShapeVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
