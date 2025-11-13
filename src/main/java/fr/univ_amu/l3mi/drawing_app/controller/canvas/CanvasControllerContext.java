package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.controller.DrawVisitor;
import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class CanvasControllerContext implements PencilValues {

    private Point2D mousePoint;
    private final ShapeCanvasController shapeCanvasController;
    private ContextState state;

    public CanvasControllerContext(ShapeCanvasController s) {
        this.shapeCanvasController = s;
        this.mousePoint = new Point2D(0, 0);
        this.state = new ViewerMode();
    }

    public void changeState(ContextState newState) {
        this.state = newState;
    }

    public void actionOnLeftMousePressed(double x, double y) {
        state.actionOnLeftMousePressed(this, x, y);
    }

    public void actionOnLeftMouseReleased(double x, double y) {
        state.actionOnLeftMouseReleased(this, x, y);
    }

    public void actionOnRightMousePressed(double x, double y) {
        state.actionOnRightMousePressed(this, x, y);
    }

    public void actionOnRightMouseReleased(double x, double y) {
        state.actionOnRightMouseReleased(this, x, y);
    }

    public void actionOnMouseMoved(double x, double y) {
        mousePoint = new Point2D(x, y);
        state.actionOnMouseMoved(this, x, y);
    }

    public void paint(CanvasView view) {
        state.paint(this, view);
    }

    public void switchToRectangleEdition() {
        changeState(new RectangleEdition());
    }

    public void switchToViewerMode() {
        changeState(new ViewerMode());
    }



    public Point2D getMousePoint() {
        return mousePoint;
    }

    public void setMousePoint(Point2D mousePoint) {
        this.mousePoint = mousePoint;
    }



    public void switchToMoveMode() {
        // TODO : add move mode
    }

    public void switchToCircleEdition() {
        changeState(new CircleEdition());
    }

    public void switchToPolygonEdition() {
        // TODO : add polygon edition
    }

    public void switchToDeleteMode() {
        // TODO : add delete mode
    }

    public void redo() {
        // TODO : add redo
    }

    public void undo() {
        // TODO : add undo
    }

    public void switchToMode(Mode mode) {
        mode.switchMode(this);
        repaint();
    }

    @Override
    public Color getStrokeColor() {
        return shapeCanvasController.getStrokeColor();
    }

    @Override
    public Color getFillColor() {
        return shapeCanvasController.getFillColor();
    }

    @Override
    public double getStrokeWidth() {
        return shapeCanvasController.getStrokeWidth();
    }

    public void addShape(Shape shape) {
        shapeCanvasController.addShape(shape);
    }
    public void repaint(){
        shapeCanvasController.repaint();
    }
}



