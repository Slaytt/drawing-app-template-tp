package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class ShapeContainer {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public List<Shape> shapesContaining(Point2D point){
        return shapes.stream().filter(shape -> shape.contains(point)).toList();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void removeShape(Shape shape){
        shapes.remove(shape);
    }

    public void clear(){
        shapes.clear();
    }

}
