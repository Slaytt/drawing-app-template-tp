package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.List;

public class Polygon extends AbstractShape {

    public Polygon(List<Point2D> points, Color fillColor, Color strokeColor, double strokeWidth) {
        super(fillColor, strokeColor, strokeWidth);
        addPoints(points);
    }

    @Override
    public <R> R accept(ShapeVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public Point2D[] getPoints() {
        int count = getPointsCount();
        Point2D[] pointsArray = new Point2D[count];
        for (int i = 0; i < count; i++) {
            pointsArray[i] = getPoint(i);
        }
        return pointsArray;
    }

    @Override
    public boolean contains(Point2D point) {
        javafx.scene.shape.Polygon fxPolygon = new javafx.scene.shape.Polygon();

        for (Point2D p : getPoints()) {
            fxPolygon.getPoints().addAll(p.getX(), p.getY());
        }
        return fxPolygon.contains(point);
    }
}