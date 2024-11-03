package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.controller.DrawVisitor;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import fr.univ_amu.l3mi.drawing_app.view.CanvasController;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.scene.paint.Color;

public class ShapeCanvasController implements CanvasController, PencilValues {
    private final CanvasControllerContext context;
    private CanvasView view;
    private final ShapeContainer shapeContainer = new ShapeContainer();
    private final PencilValues pencilValues;

    public ShapeContainer getShapeContainer() {
        return shapeContainer;
    }

    public void setView(CanvasView view) {
        this.view = view;
        shapeContainer.setHeight(view.getCanvasDimensions().height());
        shapeContainer.setWidth(view.getCanvasDimensions().width());
    }

    @Override
    public Color getFillColor() {
        return pencilValues.getFillColor();
    }

    @Override
    public double getStrokeWidth() {
        return pencilValues.getStrokeWidth();
    }

    public void repaint(){
        view.clearCanvas();
        drawShapes();
        context.paint(view);
    }

    private void drawShapes() {
        new DrawVisitor(view).drawShapes(shapeContainer.getShapes());
    }

    public ShapeCanvasController(PencilValues pencilValues) {
        this.context = new CanvasControllerContext(this);
        this.pencilValues = pencilValues;
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

    public void clear(){
        shapeContainer.clear();
        repaint();
    }

    public void switchToRectangleEdition() {
        context.switchToRectangleEdition();
    }

    public void switchToViewerMode() {
        context.switchToViewerMode();
    }

    public void switchToMoveEdition() {
        // TODO : add move edition
    }

    public void switchToCircleEdition() {
        // TODO : add circle edition
    }

    public void switchToPolygonEdition() {
        // TODO : add polygon edition
    }

    public void switchToDeleteEdition() {
        // TODO : add delete mode
    }

    public void undo(){
        context.undo();

    }

    public void redo(){
        context.redo();
    }

    public void addShape(Shape shape) {
        shapeContainer.addShape(shape);
    }

    @Override
    public Color getStrokeColor() {
        return pencilValues.getStrokeColor();
    }
}
