package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.controller.canvas.PencilValues;
import fr.univ_amu.l3mi.drawing_app.controller.canvas.ShapeCanvasController;
import fr.univ_amu.l3mi.drawing_app.model.file.NaiveShapeFileReader;
import fr.univ_amu.l3mi.drawing_app.model.file.SVGExporterVisitor;
import fr.univ_amu.l3mi.drawing_app.model.file.ShapeFileWriterVisitor;
import fr.univ_amu.l3mi.drawing_app.view.Controller;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import fr.univ_amu.l3mi.drawing_app.view.javafx.view.FileExtension;
import javafx.scene.paint.Color;

public class DrawingAppController implements Controller<DrawingAppView>, PencilValues {
    private DrawingAppView view;
    private Color strokeColor;
    private double opacity = 0.25;
    private double strokeWidth = 1.0;
    private final ShapeCanvasController shapeCanvasController;

    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public Color getFillColor() {
        return new javafx.scene.paint.Color(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue(), opacity);
    }

    @Override
    public double getStrokeWidth() {
        return strokeWidth;
    }

    public DrawingAppController() {
        shapeCanvasController = new ShapeCanvasController(this);
    }


    @Override
    public void buttonActionOnClick(String buttonId) {
        switch (buttonId){
            case "ClearButton" -> shapeCanvasController.clear();
            case "SVGButton" -> view.saveFile((writer) ->
                            new SVGExporterVisitor().writeShapes(shapeCanvasController.getShapeContainer(), writer),
                        FileExtension.SVG);
            case "SaveButton" -> view.saveFile((writer) ->
                            new ShapeFileWriterVisitor().writeShapes(shapeCanvasController.getShapeContainer(), writer),
                    FileExtension.DAFF);
            case "LoadButton" -> {
                view.readFile((reader) -> new NaiveShapeFileReader().readShapes(shapeCanvasController.getShapeContainer(), reader),
                        FileExtension.DAFF);
                shapeCanvasController.repaint();
            }
            case "UndoButton" -> shapeCanvasController.undo();
            case "RedoButton" -> shapeCanvasController.redo();
        }
    }

    @Override
    public void initializeViewOnStart(DrawingAppView view) {
        this.view = view;
        shapeCanvasController.setView(view);
        strokeColor = Color.BLACK;
        view.setColorPicked("ColorPicker", strokeColor);
    }

    @Override
    public void colorPicked(String id, Color color) {
        if(id.equals("ColorPicker"))
            strokeColor = color;
    }

    @Override
    public void actionOnKeyPressed(String key) {
        String mode;
        switch (key) {
            case "r" ->{
                shapeCanvasController.switchToRectangleEdition();
                mode = "Rectangle";
            }
            case "m" ->{
                shapeCanvasController.switchToMoveEdition();
                mode = "Move";
            }
            case "d" ->{
                shapeCanvasController.switchToDeleteEdition();
                mode = "Delete";
            }
            case "c" -> {
                shapeCanvasController.switchToCircleEdition();
                mode = "Circle";
            }
            case "p" -> {
                shapeCanvasController.switchToPolygonEdition();
                mode = "Polygon";
            }
            case "v" -> {
                shapeCanvasController.switchToViewerMode();
                mode = "Viewer";
            }
            default -> mode = "Viewer";
        }
        view.setComboBoxChoice("ModeComboBox", mode);
    }

    @Override
    public void choicePicked(String id, String choice) {
        switch (id){
            case "ModeComboBox" -> {
                switch (choice) {
                    case "Polygon" -> shapeCanvasController.switchToPolygonEdition();
                    case "Move" -> shapeCanvasController.switchToMoveEdition();
                    case "Circle" -> shapeCanvasController.switchToCircleEdition();
                    case "Rectangle" -> shapeCanvasController.switchToRectangleEdition();
                    case "Viewer" -> shapeCanvasController.switchToViewerMode();
                    case "Delete" -> shapeCanvasController.switchToDeleteEdition();
                }
            }
            case "OpacityComboBox" -> opacity = Double.parseDouble(choice);
            case "StrokeWidthComboBox" -> strokeWidth = Double.parseDouble(choice);
        }

    }

    @Override
    public void actionOnLeftMousePressed(double x, double y) {
        shapeCanvasController.actionOnLeftMousePressed(x, y);
    }

    @Override
    public void actionOnLeftMouseReleased(double x, double y) {
        shapeCanvasController.actionOnLeftMouseReleased(x, y);
    }

    @Override
    public void actionOnRightMousePressed(double x, double y) {
        shapeCanvasController.actionOnRightMousePressed(x, y);
    }

    @Override
    public void actionOnRightMouseReleased(double x, double y) {
        shapeCanvasController.actionOnRightMouseReleased(x, y);
    }

    @Override
    public void actionOnMouseMoved(double x, double y) {
        shapeCanvasController.actionOnMouseMoved(x, y);
    }

}
