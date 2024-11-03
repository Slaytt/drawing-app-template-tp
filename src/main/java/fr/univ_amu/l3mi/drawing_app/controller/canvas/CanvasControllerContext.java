package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import fr.univ_amu.l3mi.drawing_app.controller.DrawVisitor;
import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.CanvasView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class CanvasControllerContext {
    private boolean rectangleEdition;
    private boolean rectangleEditionClicked;
    private Point2D clickedPoint;
    private Point2D cursorPoint;
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
            cursorPoint = new Point2D(x, y);
            Shape rectangle = new Rectangle(clickedPoint, cursorPoint, shapeCanvasController.getFillColor(),
                    shapeCanvasController.getStrokeColor(), shapeCanvasController.getStrokeWidth());
            shapeCanvasController.addShape(rectangle);
            switchToRectangleEdition();
            shapeCanvasController.repaint();
        }
    }

    public void actionOnMouseMoved(double x, double y) {
        cursorPoint = new Point2D(x, y);
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
        clickedPoint = new Point2D(x, y);
        cursorPoint = new Point2D(x, y);
    }

    public void paint(CanvasView view){
        if(rectangleEditionClicked){
            strokeRectangleBetweenClickedPointAndCursorPoint(view);
        }
    }

    private void strokeRectangleBetweenClickedPointAndCursorPoint(CanvasView view) {
        new DrawVisitor(view).visit(new Rectangle(clickedPoint, cursorPoint, Color.TRANSPARENT,
                shapeCanvasController.getStrokeColor(), shapeCanvasController.getStrokeWidth()));
    }

    public void actionOnRightMousePressed(double x, double y) {
    }

    public void actionOnRightMouseReleased(double x, double y) {

    }
}



