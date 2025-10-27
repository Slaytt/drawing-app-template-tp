package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.controller.DrawVisitor;
import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class CanvasControllerContext implements PencilValues {
    public static final int CROSS_STROKE_WIDTH = 2;
    private boolean rectangleEdition;
    private boolean rectangleEditionClicked;
    private Point2D mouseClickedPoint;
    private Point2D mousePoint;
    private final ShapeCanvasController shapeCanvasController;

    public CanvasControllerContext(ShapeCanvasController shapeCanvasController) {
        this.shapeCanvasController = shapeCanvasController;
    }

    public void actionOnLeftMousePressed(double x, double y) {
        if (rectangleEdition) {
            switchToRectangleEditionClicked(x, y);
        }
    }

    public void actionOnLeftMouseReleased(double x, double y) {
        if(rectangleEditionClicked) {
            mousePoint = new Point2D(x, y);
            Shape rectangle = new Rectangle(mouseClickedPoint, mousePoint, getFillColor(),
                    getStrokeColor(), shapeCanvasController.getStrokeWidth());
            addShape(rectangle);
            switchToRectangleEdition();
            repaint();
        }
    }

    public void actionOnMouseMoved(double x, double y) {
        mousePoint = new Point2D(x, y);
        shapeCanvasController.repaint();
    }

    public void switchToRectangleEdition(){
        rectangleEdition = true;
        rectangleEditionClicked = false;
    }

    public void switchToViewerMode(){
        rectangleEdition = false;
        rectangleEditionClicked = false;
    }

    private void switchToRectangleEditionClicked(double x, double y){
        rectangleEdition = false;
        rectangleEditionClicked = true;
        mouseClickedPoint = new Point2D(x, y);
        setMousePoint(new Point2D(x, y));
    }

    public void paint(CanvasView view){
        if(rectangleEdition) {
            strokeCross(view);
        }
        if(rectangleEditionClicked){
            strokeRectangleBetweenClickedPointAndMousePoint(view);
        }
    }

    public Point2D getMousePoint() {
        return mousePoint;
    }

    public void setMousePoint(Point2D mousePoint) {
        this.mousePoint = mousePoint;
    }

    private void strokeCross(CanvasView view) {
        Point2D p1 = getMousePoint().add(new Point2D(10,0));
        Point2D p2 = getMousePoint().add(new Point2D(-10,0));
        view.drawLine(p1, p2, Color.BLACK, CROSS_STROKE_WIDTH);
        Point2D p3 = getMousePoint().add(new Point2D(0,10));
        Point2D p4 = getMousePoint().add(new Point2D(0,-10));
        view.drawLine(p3, p4, Color.BLACK, CROSS_STROKE_WIDTH);
    }

    private void strokeRectangleBetweenClickedPointAndMousePoint(CanvasView view) {
        new DrawVisitor(view).visit(new Rectangle(mouseClickedPoint, getMousePoint(), Color.TRANSPARENT,
                getStrokeColor(), getStrokeWidth()));
    }

    public void actionOnRightMousePressed(double x, double y) {
        // TODO : add action for right mouse click
    }

    public void actionOnRightMouseReleased(double x, double y) {
        // TODO : add action for right mouse click
    }

    public void switchToMoveMode() {
        // TODO : add move mode
    }

    public void switchToCircleEdition() {
        // TODO : add circle edition
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



