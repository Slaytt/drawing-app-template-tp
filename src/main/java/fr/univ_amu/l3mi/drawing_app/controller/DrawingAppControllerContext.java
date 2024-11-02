package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.Shape;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import javafx.geometry.Point2D;

public class DrawingAppControllerContext {
    private boolean rectangleEdition;
    private boolean rectangleEditionClicked;
    private Point2D clickedPoint;
    private Point2D cursorPoint;
    private final DrawingAppController drawingAppController;

    public DrawingAppControllerContext(DrawingAppController drawingAppController) {
        this.drawingAppController = drawingAppController;
    }

    public void actionOnLeftMousePressed(double x, double y) {
        if (rectangleEdition) {
            switchToRectangleEditionClicked(x, y);
        }
    }

    public void actionOnLeftMouseReleased(double x, double y) {
        if(rectangleEditionClicked) {
            cursorPoint = new Point2D(x, y);
            Shape rectangle = new Rectangle(clickedPoint, cursorPoint, drawingAppController.getColorPicked());
            drawingAppController.addShape(rectangle);
            switchToRectangleEdition();
            drawingAppController.repaint();
        }
    }


    public void actionOnRightMousePressed(double x, double y) {

    }


    public void actionOnRightMouseReleased(double x, double y) {

    }


    public void actionOnMouseMoved(double x, double y) {
        cursorPoint = new Point2D(x, y);
        drawingAppController.repaint();
    }


    public void actionOnKeyPressed(String key) {
        if (key.equals("r")) {
            switchToRectangleEdition();
        }
    }


    public void buttonActionOnClick(String buttonId) {
        if (buttonId.equals("ClearButton")) {
            drawingAppController.clear();
        }
    }

    private void switchToRectangleEdition(){
        rectangleEdition = true;
        rectangleEditionClicked = false;
    }

    private void switchToRectangleEditionClicked(double x, double y){
        rectangleEditionClicked = true;
        clickedPoint = new Point2D(x, y);
        cursorPoint = new Point2D(x, y);
    }

    public void paint(DrawingAppView view){
        if(rectangleEditionClicked){
            strokeRectangleBetweenClickedPointAndCursorPoint(view);
        }
    }

    private void strokeRectangleBetweenClickedPointAndCursorPoint(DrawingAppView view) {
        new StrokeVisitor(view).visit(new Rectangle(clickedPoint, cursorPoint, drawingAppController.getColorPicked()));
    }

}
