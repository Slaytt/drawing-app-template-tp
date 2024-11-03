package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import fr.univ_amu.l3mi.drawing_app.model.ShapeVisitor;

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
}
