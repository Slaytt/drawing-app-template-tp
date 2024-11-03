package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractShape implements Shape {
    private final List<Point2D> points = new ArrayList<>();
    private final Color fillColor;
    private final Color strokeColor;
    private final double strokeWidth;

    public AbstractShape(Color fillColor, Color strokeColor, double strokeWidth) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
    }

    @Override
    public int getPointsCount() {
        return points.size();
    }

    @Override
    public Color getFillColor(){
        return fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public double getStrokeWidth() {
        return strokeWidth;
    }


    protected void addPoints(Point2D... points){
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public Point2D getPoint(int index) {
        return points.get(index);
    }

    @Override
    public void translate(double dx, double dy) {
        for (int index = 0; index < getPointsCount(); index++) {
            points.set(index, getPoint(index).add(dx, dy));
        }
    }
}
