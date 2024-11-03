package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;

import java.io.BufferedWriter;
import java.io.IOException;

public interface ShapeFileWriter {
    void writeShapes(ShapeContainer shapeContainer, BufferedWriter writer) throws IOException;
}
