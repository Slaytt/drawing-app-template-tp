package fr.univ_amu.l3mi.drawing_app.model;

import fr.univ_amu.l3mi.drawing_app.view.Color;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public interface Shape {
    boolean contains(Point2D point);

    <R> R accept(ShapeVisitor<R> visitor);

    int pointsCount();

    Color getColor();

    Point2D point(int index);

    void translate(double dx, double dy);
}
