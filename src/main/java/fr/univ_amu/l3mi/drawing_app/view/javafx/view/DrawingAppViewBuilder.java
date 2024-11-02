package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import java.util.List;

public interface DrawingAppViewBuilder {
    DrawingAppViewBuilder resetView();
    DrawingAppViewBuilder setCanvasDimensions(int width, int height);
    DrawingAppViewBuilder setTitle(String title);
    DrawingAppViewBuilder addLabel(String id, String initialText);
    DrawingAppViewBuilder addButton(String id, String label);
    DrawingAppViewBuilder addColorPicker(String id, String Label);
    DrawingAppViewBuilder addComboBox(String id, List<String> choices, String initialChoice);
    DrawingAppControllableView getView();
}
