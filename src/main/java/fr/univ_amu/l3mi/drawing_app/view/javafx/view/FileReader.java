package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import java.io.BufferedReader;
import java.io.IOException;

public interface FileReader {
    void read(BufferedReader writer) throws IOException;
}
