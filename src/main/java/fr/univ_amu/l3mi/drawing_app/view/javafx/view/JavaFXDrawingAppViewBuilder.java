package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import javafx.stage.Stage;

import java.util.List;

public class JavaFXDrawingAppViewBuilder implements DrawingAppViewBuilder {
    JavaFXDrawingAppView drawingAppView;

    public JavaFXDrawingAppViewBuilder(Stage primaryStage) {
        drawingAppView = new JavaFXDrawingAppView(primaryStage);
    }

    public DrawingAppViewBuilder resetView(){
        drawingAppView.reset();
        return this;
    }


    @Override
    public DrawingAppViewBuilder addColorPicker(String id, String label) {
        drawingAppView.getBar().addColorPicker(id, label);
        drawingAppView.getBar().setColorPickerAction(id, _->drawingAppView.actionOnColorPicked(id));
        return this;
    }

    @Override
    public DrawingAppViewBuilder addComboBox(String id, List<String> choices, String initialChoice) {
        return this;
    }

    @Override
    public DrawingAppViewBuilder setCanvasDimensions(int width, int height) {
        drawingAppView.getDrawingCanvasView().setDimensions(width, height);
        return this;
    }

    @Override
    public DrawingAppViewBuilder setTitle(String title) {
        drawingAppView.getStage().setTitle(title);
        return this;
    }

    @Override
    public DrawingAppViewBuilder addLabel(String id, String initialText) {
        drawingAppView.getBar().addLabel(id, initialText);
        return this;
    }

    @Override
    public DrawingAppViewBuilder addButton(String id, String label) {
        drawingAppView.getBar().addButton(id, label);
        drawingAppView.getBar().setButtonAction(id, ()-> drawingAppView.buttonActionOnclick(id));
        return this;
    }

    @Override
    public DrawingAppControllableView getView() {
        return drawingAppView;
    }

}
