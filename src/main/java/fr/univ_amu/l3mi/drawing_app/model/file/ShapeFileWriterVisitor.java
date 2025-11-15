package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.*;

import java.io.BufferedWriter;
import java.io.IOException;

public class ShapeFileWriterVisitor implements ShapeVisitor<String>, ShapeFileWriter {

    @Override
    public void writeShapes(ShapeContainer shapeContainer, BufferedWriter writer) throws IOException {
        writer.write("Width " + shapeContainer.getWidth() + "\n");
        writer.write("Height " + shapeContainer.getHeight() + "\n");
        for (Shape shape : shapeContainer.getShapes()) {
            writer.write(shape.accept(this)+"\n");
        }
    }

    @Override
    public String visit(Rectangle r) {
        return "Rectangle " + r.getPoint(0).getX() + " " + r.getPoint(0).getY()
                + " " + r.getPoint(1).getX() + " " + r.getPoint(1).getY()  + " "
                + r.getFillColor() + " " + r.getStrokeColor()
                + " " + r.getStrokeWidth();
    }

    @Override
    public String visit(Circle c) {
        return "Circle " + c.getCenter().getX() + " " + c.getCenter().getY()
                + " " + c.getRadius() + " "
                + c.getFillColor() + " " + c.getStrokeColor()
                + " " + c.getStrokeWidth();
    }

    @Override
    public String visit(Polygon p) {
        StringBuilder s = new StringBuilder("Polygon");

        for (int i = 0; i < p.getPointsCount(); i++) {
            s.append(" ").append(p.getPoint(i).getX());
            s.append(" ").append(p.getPoint(i).getY());
        }

        s.append(" ").append(p.getFillColor());
        s.append(" ").append(p.getStrokeColor());
        s.append(" ").append(p.getStrokeWidth());
        return s.toString();
    }
}
