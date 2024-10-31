package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import fr.univ_amu.l3mi.drawing_app.view.Color;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppController;
import fr.univ_amu.l3mi.drawing_app.view.javafx.bar.Bar;
import fr.univ_amu.l3mi.drawing_app.view.javafx.canvas.DrawingCanvasView;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXDrawingAppView implements DrawingAppControllableView {
    private final Stage stage;
    private DrawingCanvasView drawingCanvasView;
    private Bar bar;
    private DrawingAppController controller;
    private VBox vBox;

    public void setController(DrawingAppController controller) {
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
    public synchronized void updateLabeledElement(String id, String newText) {
        bar.updateLabel(id, newText);
    }

    @Override
    public void clearCanvas() {
        drawingCanvasView.clear();
    }

    @Override
    public void fillRectangle(Point2D leftTopCorner, double width, double height, Color color) {
        drawingCanvasView.fillRectangle(leftTopCorner, width, height, color);
    }

    @Override
    public void strokeRectangle(Point2D leftTopCorner, double width, double height, Color color) {
        drawingCanvasView.strokeRectangle(leftTopCorner, width, height, color);
    }

    @Override
    public void fillCircle(Point2D center, double radius, Color color) {
        drawingCanvasView.fillCircle(center, radius, color);
    }

    @Override
    public void strokeCircle(Point2D center, double radius, Color color) {
        drawingCanvasView.strokeCircle(center, radius, color);
    }

    @Override
    public void fillPolygon(Point2D[] points, Color color) {
        drawingCanvasView.fillPolygon(points, color);
    }

    @Override
    public void strokePolygon(Point2D[] points, Color color) {
        drawingCanvasView.strokePolygon(points, color);
    }

    @Override
    public void strokeLine(Point2D endPoint1, Point2D endPoint2, Color color) {
        drawingCanvasView.strokeLine(endPoint1,endPoint2, color);
    }

    @Override
    public void strokePolyline(Point2D[] points, Color color) {
        drawingCanvasView.stokePolyline(points, color);
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

}
