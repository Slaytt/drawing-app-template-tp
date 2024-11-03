package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.javafx.view.FileExtension;
import javafx.scene.paint.Color;



public interface DrawingAppView extends CanvasView {

    void updateLabeledElementText(String id, String newText);

    void setComboBoxChoice(String id, String choice);

    void setColorPicked(String id, Color color);

    void saveFile(String content, FileExtension fileExtension);

}
