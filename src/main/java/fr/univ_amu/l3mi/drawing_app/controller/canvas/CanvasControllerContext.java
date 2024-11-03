package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.controller.DrawVisitor;
import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class CanvasControllerContext {
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
            Shape rectangle = new Rectangle(mouseClickedPoint, mousePoint, shapeCanvasController.getFillColor(),
                    shapeCanvasController.getStrokeColor(), shapeCanvasController.getStrokeWidth());
            shapeCanvasController.addShape(rectangle);
            switchToRectangleEdition();
            shapeCanvasController.repaint();
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
        rectangleEditionClicked = true;
        mouseClickedPoint = new Point2D(x, y);
        mousePoint = new Point2D(x, y);
    }

    public void paint(CanvasView view){
        if(rectangleEdition || rectangleEditionClicked) {
            strokeCross(mousePoint, view);
        }
        if(rectangleEditionClicked){
            strokeRectangleBetweenClickedPointAndCursorPoint(view);
        }
    }

    private void strokeCross(Point2D mousePoint, CanvasView view) {
        Point2D p1 = mousePoint.add(new Point2D(10,0));
        Point2D p2 = mousePoint.add(new Point2D(-10,0));
        view.drawLine(p1, p2, Color.BLACK, CROSS_STROKE_WIDTH);
        Point2D p3 = mousePoint.add(new Point2D(0,10));
        Point2D p4 = mousePoint.add(new Point2D(0,-10));
        view.drawLine(p3, p4, Color.BLACK, CROSS_STROKE_WIDTH);
    }

    private void strokeRectangleBetweenClickedPointAndCursorPoint(CanvasView view) {
        new DrawVisitor(view).visit(new Rectangle(mouseClickedPoint, mousePoint, Color.TRANSPARENT,
                shapeCanvasController.getStrokeColor(), shapeCanvasController.getStrokeWidth()));
    }

    public void actionOnRightMousePressed(double x, double y) {
    }

    public void actionOnRightMouseReleased(double x, double y) {

    }

    public void redo() {
        // TODO : add redo
    }

    public void undo() {
        // TODO : add undo
    }
}



