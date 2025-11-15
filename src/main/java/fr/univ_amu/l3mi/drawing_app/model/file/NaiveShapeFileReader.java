package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.Circle;
import fr.univ_amu.l3mi.drawing_app.model.Polygon;
import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NaiveShapeFileReader implements ShapeFileReader {

    public static final int DEFAULT_WIDTH = 1000;
    public static final int DEFAULT_HEIGHT = 1000;


    @Override
    public void readShapes(ShapeContainer shapeContainer, BufferedReader reader) throws IOException {
        shapeContainer.clear();
        double width = DEFAULT_WIDTH;
        double height = DEFAULT_HEIGHT;
        int lineNumber = 0;

        for (String line = reader.readLine(); line != null; line = reader.readLine()){
            String[] tokens = line.split(" ");
            switch (tokens[0]){
                case "Width" -> width = Double.parseDouble(tokens[1]);
                case "Height" -> height = Double.parseDouble(tokens[1]);
                case "Rectangle" -> readRectangle(tokens, shapeContainer);
                case "Circle" -> readCircle(tokens, shapeContainer);
                case "Polygon" -> readPolygon(tokens, shapeContainer);
                default -> throw new IOException("Parse error line " + lineNumber);
            }
            lineNumber++;
        }
        shapeContainer.setWidth(width);
        shapeContainer.setHeight(height);
    }

    private void readRectangle(String[] tokens, ShapeContainer shapeContainer) {
        double x1 = Double.parseDouble(tokens[1]);
        double y1 = Double.parseDouble(tokens[2]);
        double x2 = Double.parseDouble(tokens[3]);
        double y2 = Double.parseDouble(tokens[4]);
        Point2D corner1 = new Point2D(x1, y1);
        Point2D corner2 = new Point2D(x2, y2);
        Color fillColor = Color.web(tokens[5]);
        Color strokeColor = Color.web(tokens[6]);
        double strokeWidth = Double.parseDouble(tokens[7]);
        shapeContainer.addShape(new Rectangle(corner1, corner2, fillColor, strokeColor, strokeWidth));
    }

    private void readCircle(String[] tokens, ShapeContainer shapeContainer) {
        double x_centre = Double.parseDouble(tokens[1]);
        double y_centre = Double.parseDouble(tokens[2]);
        double radius = Double.parseDouble(tokens[3]);
        Color fillColor = Color.web(tokens[4]);
        Color strokeColor = Color.web(tokens[5]);
        double strokeWidth = Double.parseDouble(tokens[6]);
        Point2D center = new Point2D(x_centre, y_centre);
        Point2D onCircle = new Point2D(x_centre + radius, y_centre);
        shapeContainer.addShape(new Circle(center, onCircle, fillColor, strokeColor, strokeWidth));
    }

    private void readPolygon(String[] tokens, ShapeContainer shapeContainer) {
        List<Point2D> points = new ArrayList<>();
        for (int i = 1; i < tokens.length - 3; i += 2) {
            double x = Double.parseDouble(tokens[i]);
            double y = Double.parseDouble(tokens[i + 1]);
            points.add(new Point2D(x, y));
        }

        Color fillColor = Color.web(tokens[tokens.length - 3]);
        Color strokeColor = Color.web(tokens[tokens.length - 2]);
        double strokeWidth = Double.parseDouble(tokens[tokens.length - 1]);

        shapeContainer.addShape(new Polygon(points, fillColor, strokeColor, strokeWidth));
    }

}
