package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractShape implements Shape {
    private final List<Point2D> points = new ArrayList<>();
    private final Color color;

    public AbstractShape(Color color) {
        this.color = color;
    }

    @Override
    public int pointsCount() {
        return points.size();
    }

    @Override
    public Color getColor(){
        return color;
    }

    protected void addPoints(Point2D... points){
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public Point2D point(int index) {
        return points.get(index);
    }

    @Override
    public void translate(double dx, double dy) {
        for (int index = 0; index < pointsCount(); index++) {
            points.set(index, point(index).add(dx, dy));
        }
    }
}
