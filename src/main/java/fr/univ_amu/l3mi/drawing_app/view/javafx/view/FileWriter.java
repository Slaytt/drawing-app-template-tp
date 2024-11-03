package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import java.io.BufferedWriter;
import java.io.IOException;

public interface FileWriter {
    void write(BufferedWriter writer) throws IOException;
}
