package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer {
    private final List<Shape> shapes = new ArrayList<>();
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void clear(){
        shapes.clear();
    }

    public List<Shape> shapesContaining(Point2D point) {
        List<Shape> found = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.contains(point)) {
                found.add(shape);
            }
        }
        return found;
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

}
