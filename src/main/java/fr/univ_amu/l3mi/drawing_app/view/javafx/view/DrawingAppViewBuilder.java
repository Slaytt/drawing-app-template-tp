package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import java.util.List;

public interface DrawingAppViewBuilder {
    DrawingAppViewBuilder resetView();
    DrawingAppViewBuilder setCanvasDimensions(double width, double height);
    DrawingAppViewBuilder setTitle(String title);
    DrawingAppViewBuilder addLabel(String id, String initialText);
    DrawingAppViewBuilder addButton(String id, String label);
    DrawingAppViewBuilder addColorPicker(String id, String label);
    DrawingAppViewBuilder addComboBox(String id, String label, List<String> choice);
    DrawingAppControllableView getView();
}
