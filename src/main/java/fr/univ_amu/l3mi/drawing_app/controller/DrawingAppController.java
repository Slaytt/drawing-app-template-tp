package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import fr.univ_amu.l3mi.drawing_app.view.Controller;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import javafx.scene.paint.Color;

public class DrawingAppController implements Controller<DrawingAppView> {
    private final ShapeContainer shapeContainer;
    private DrawingAppView view;
    private final DrawingAppControllerContext context;
    private Color colorPicked;

    public Color getColorPicked() {
        return colorPicked;
    }

    public DrawingAppController() {
        context = new DrawingAppControllerContext(this);
        shapeContainer = new ShapeContainer();
    }

    public void repaint(){
        view.clearCanvas();
        drawShapes();
        context.paint(view);
    }

    public void clear(){
        shapeContainer.clear();
        repaint();
    }

    private void drawShapes() {
        new FillVisitor(view).drawShapes(shapeContainer.getShapes());
    }

    public void addShape(Shape shape) {
        shapeContainer.addShape(shape);
    }

    @Override
    public void actionOnLeftMousePressed(double x, double y) {
        context.actionOnLeftMousePressed(x, y);
    }

    @Override
    public void actionOnLeftMouseReleased(double x, double y) {
        context.actionOnLeftMouseReleased(x, y);
    }

    @Override
    public void actionOnRightMousePressed(double x, double y) {
        context.actionOnRightMousePressed(x, y);
    }

    @Override
    public void actionOnRightMouseReleased(double x, double y) {
        context.actionOnRightMouseReleased(x, y);
    }

    @Override
    public void actionOnMouseMoved(double x, double y) {
        context.actionOnMouseMoved(x, y);
    }

    @Override
    public void actionOnKeyPressed(String key) {
        context.actionOnKeyPressed(key);
    }

    @Override
    public void buttonActionOnClick(String buttonId) {
        context.buttonActionOnClick(buttonId);
    }

    @Override
    public void initializeViewOnStart(DrawingAppView view) {
        this.view = view;
        colorPicked = Color.BLACK;
        view.setColorPicked("ColorPicker", colorPicked);
    }

    @Override
    public void colorPicked(String id, Color color) {
        if(id.equals("Color"))
            colorPicked = color;
    }

    @Override
    public void choicePicked(String id, String choice) {

    }
}
