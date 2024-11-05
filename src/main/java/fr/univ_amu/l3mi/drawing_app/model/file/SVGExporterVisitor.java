package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import fr.univ_amu.l3mi.drawing_app.model.ShapeVisitor;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

import java.io.BufferedWriter;
import java.io.IOException;

public class SVGExporterVisitor implements ShapeVisitor<String>, ShapeFileWriter {
    public static final int COLOR_RANGE = 255;

    String convertColorToString(Color color) {
        return "rgba(" + color.getRed() * COLOR_RANGE +
                ',' +
                color.getGreen() * COLOR_RANGE +
                ',' +
                color.getBlue() * COLOR_RANGE +
                ',' +
                color.getOpacity() +
                ')';
    }


    @Override
    public String visit(Rectangle rectangle) {
        Point2D topLeftCorner = rectangle.getTopLeftCorner();
        double width = rectangle.getWidth();
        double height = rectangle.getHeight();
        return "<rect x=\"" + topLeftCorner.getX() +
                "\" y=\"" +
                topLeftCorner.getY() +
                "\" width=\"" +
                width +
                "\" height=\"" +
                height +
                "\" fill=\"" +
                convertColorToString(rectangle.getFillColor()) +
                "\" stroke=\"" +
                convertColorToString(rectangle.getStrokeColor()) +
                "\" stroke-width=\"" +
                rectangle.getStrokeWidth() +
                "\" />";
    }

    @Override
    public void writeShapes(ShapeContainer shapeContainer, BufferedWriter writer) throws IOException {
        writer.write("<svg width=\"" + shapeContainer.getWidth());
        writer.write("\" height=\"" + shapeContainer.getHeight());
        writer.write("\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (Shape shape : shapeContainer.getShapes()) {
            writer.write(shape.accept(this) + "\n");
        }
        writer.write("</svg>\n");
    }
}
