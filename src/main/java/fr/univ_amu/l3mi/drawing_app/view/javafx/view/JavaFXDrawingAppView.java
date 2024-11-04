package fr.univ_amu.l3mi.drawing_app.view.javafx.view;


import fr.univ_amu.l3mi.drawing_app.view.Controller;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import fr.univ_amu.l3mi.drawing_app.view.configuration.CanvasDimensions;
import fr.univ_amu.l3mi.drawing_app.view.javafx.bar.Bar;
import fr.univ_amu.l3mi.drawing_app.view.javafx.canvas.DrawingCanvasView;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JavaFXDrawingAppView implements DrawingAppControllableView {
    private final Stage stage;
    private DrawingCanvasView drawingCanvasView;
    private Bar bar;
    private Controller<DrawingAppView> controller;
    private VBox vBox;

    public void setController(Controller<DrawingAppView> controller) {
        this.controller = controller;
        drawingCanvasView.setController(controller);
        vBox.setOnKeyPressed(event -> controller.actionOnKeyPressed(event.getText()));
    }

    public JavaFXDrawingAppView(Stage stage) {
        this.stage = stage;
        stage.setOnCloseRequest(_ -> Platform.exit());
        stage.setResizable(false);
        stage.sizeToScene();
    }

    public synchronized void reset() {
        vBox = new VBox();
        bar = new Bar();
        drawingCanvasView = new DrawingCanvasView();
        vBox.getChildren().add(bar);
        vBox.getChildren().add(drawingCanvasView);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
    }

    @Override
    public synchronized void updateLabeledElementText(String id, String newText) {
        bar.updateLabel(id, newText);
    }

    @Override
    public void clearCanvas() {
        drawingCanvasView.clear();
    }

    @Override
    public void drawRectangle(Point2D topLeftCorner, double width, double height, Color fillColor, Color strokeColor, double strokeWidth) {
        drawingCanvasView.fillRectangle(topLeftCorner, width, height, fillColor);
        drawingCanvasView.strokeRectangle(topLeftCorner, width, height, strokeColor, strokeWidth);
    }


    @Override
    public void drawCircle(Point2D center, double radius, Color fillColor, Color strokeColor, double strokeWidth) {
        drawingCanvasView.fillCircle(center, radius, fillColor);
        drawingCanvasView.strokeCircle(center, radius, strokeColor, strokeWidth);
    }

    @Override
    public CanvasDimensions getCanvasDimensions() {
        return new CanvasDimensions(drawingCanvasView.getWidth(), drawingCanvasView.getHeight());
    }

    @Override
    public void setCanvasDimensions(CanvasDimensions canvasDimensions) {
        drawingCanvasView.setDimensions(canvasDimensions.width(), canvasDimensions.height());
    }

    @Override
    public void drawPolygon(Point2D[] points, Color fillColor, Color strokeColor, double strokeWidth) {
        drawingCanvasView.fillPolygon(points, fillColor);
        drawingCanvasView.strokePolygon(points, strokeColor, strokeWidth);
    }

    @Override
    public void drawLine(Point2D endPoint1, Point2D endPoint2, Color color, double strokeWidth) {
        drawingCanvasView.strokeLine(endPoint1,endPoint2, color, strokeWidth);
    }

    public DrawingCanvasView getDrawingCanvasView() {
        return drawingCanvasView;
    }

    public Stage getStage() {
        return stage;
    }

    public Bar getBar() {
        return bar;
    }

    public void buttonActionOnclick(String id){
        controller.buttonActionOnClick(id);
    }

    public void actionOnColorPicked(String id){
        controller.colorPicked(id, bar.getPickedColor(id));
    }

    public void actionOnChoicePicked(String id){
        controller.choicePicked(id, bar.getPickedChoice(id));
    }

    public void setComboBoxChoice(String id, String choice) {
        bar.updateComboBox(id, choice);
    }

    @Override
    public void setColorPicked(String id, Color color) {
        bar.updateColorPicker(id, color);
    }


    public void saveFile(FileWriter fileWriter, FileExtension fileExtension) {
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(fileExtension.fileFormatName,
                fileExtension.extension));

        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try {
                BufferedWriter stream = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_16);
                fileWriter.write(stream);
                stream.close();
            }
            catch(IOException exception){
                exception.printStackTrace();
            }
        }
    }


    @Override
    public void readFile(FileReader fileReader, FileExtension fileExtension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(fileExtension.fileFormatName,
                fileExtension.extension));
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_16);
                fileReader.read(bufferedReader);
                bufferedReader.close();
            }
            catch(IOException exception){
                exception.printStackTrace();
            }
        }
    }
}
