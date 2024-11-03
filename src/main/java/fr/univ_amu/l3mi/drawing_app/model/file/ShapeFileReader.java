package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;

import java.io.BufferedReader;
import java.io.IOException;

public interface ShapeFileReader {
    void readShapes(ShapeContainer shapeContainer, BufferedReader reader) throws IOException;
}
