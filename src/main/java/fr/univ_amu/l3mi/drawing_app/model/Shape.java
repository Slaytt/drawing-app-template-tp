package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public interface Shape {

    <R> R accept(ShapeVisitor<R> visitor);

    int getPointsCount();

    Color getFillColor();

    Color getStrokeColor();

    double getStrokeWidth();

    Point2D getPoint(int index);

    boolean contains(Point2D point);
}
