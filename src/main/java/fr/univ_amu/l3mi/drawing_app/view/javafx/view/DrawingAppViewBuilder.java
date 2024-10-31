package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

public interface DrawingAppViewBuilder {
    DrawingAppViewBuilder resetView();
    DrawingAppViewBuilder setCanvasDimensions(int width, int height);
    DrawingAppViewBuilder setTitle(String title);
    DrawingAppViewBuilder addLabel(String id, String initialText);
    DrawingAppViewBuilder addButton(String id, String label);
    DrawingAppControllableView getView();
}
