package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.javafx.view.FileExtension;
import fr.univ_amu.l3mi.drawing_app.view.javafx.view.FileReader;
import fr.univ_amu.l3mi.drawing_app.view.javafx.view.FileWriter;
import javafx.scene.paint.Color;



public interface DrawingAppView extends CanvasView {

    void setComboBoxChoice(String id, String choice);

    void setColorPicked(String id, Color color);

    void saveFile(FileWriter fileWriter, FileExtension fileExtension);

    void readFile(FileReader fileReader, FileExtension fileExtension);

}
