package fr.univ_amu.l3mi.drawing_app.view.javafx.canvas;

import fr.univ_amu.l3mi.drawing_app.view.Controller;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.util.Arrays;


public class DrawingCanvasView extends Canvas {
    private final GraphicsContext gc;

    public DrawingCanvasView() {
        gc = getGraphicsContext2D();
    }

    public void setDimensions(int width, int height) {
        super.setWidth(width);
        super.setHeight(height);
    }

    public void clear() {
        this.getGraphicsContext2D().clearRect(0,0,this.getWidth(),this.getHeight());
    }

    public void setController(Controller<DrawingAppView> controller) {
        setOnMousePressed(event->{
            if(event.getButton() == MouseButton.PRIMARY)
                controller.actionOnLeftMousePressed(event.getX(), event.getY());
            else
                if(event.getButton() == MouseButton.SECONDARY)
                    controller.actionOnRightMousePressed(event.getX(), event.getY());
        });
        setOnMouseReleased(event->{
            if(event.getButton() == MouseButton.PRIMARY)
                controller.actionOnLeftMouseReleased(event.getX(), event.getY());
            else
                if(event.getButton() == MouseButton.SECONDARY)
                    controller.actionOnRightMouseReleased(event.getX(), event.getY());
        });
        setOnMouseMoved(event->controller.actionOnMouseMoved(event.getX(), event.getY()));
        setOnMouseDragged(event->controller.actionOnMouseMoved(event.getX(), event.getY()));
    }

    public void strokeLine(Point2D endPoint1, Point2D endPoint2, Color color) {
        setStroke(color);
        gc.strokeLine(endPoint1.getX(), endPoint1.getY(), endPoint2.getX(), endPoint2.getY());
    }

    public void stokePolyline(Point2D[] points, Color color) {
        setStroke(color);
        Points pointsCoordinates = getPoints(points);
        gc.strokePolyline(pointsCoordinates.xPoints(), pointsCoordinates.yPoints(), pointsCoordinates.nbPoints());
    }

    private static Points getPoints(Point2D[] points) {
        double[] xPoints = Arrays.stream(points).mapToDouble(Point2D::getX).toArray();
        double[] yPoints = Arrays.stream(points).mapToDouble(Point2D::getY).toArray();
        int nbPoints = points.length;
        return new Points(xPoints, yPoints, nbPoints);
    }

    private record Points(double[] xPoints, double[] yPoints, int nbPoints) {
    }


    public void fillPolygon(Point2D[] points, Color color) {
        strokePolygon(points, color);
        setFill(color);
        Points pointsCoordinates = getPoints(points);
        gc.fillPolygon(pointsCoordinates.xPoints(), pointsCoordinates.yPoints(), pointsCoordinates.nbPoints());
    }


    public void strokePolygon(Point2D[] points, Color color) {
        setStroke(color);
        Points pointsCoordinates = getPoints(points);
        gc.strokePolygon(pointsCoordinates.xPoints(), pointsCoordinates.yPoints(), pointsCoordinates.nbPoints());
    }

    private void setStroke(Color color) {
        gc.setStroke(color);
        gc.setLineWidth(2);
    }

    private void setFill(Color color) {

        javafx.scene.paint.Color nonOpaqueColor =
                new javafx.scene.paint.Color(color.getRed(), color.getGreen(), color.getBlue(), 0.5);
        gc.setFill(nonOpaqueColor);
    }


    public void strokeCircle(Point2D center, double radius, Color color) {
        setStroke(color);
        gc.strokeOval(center.getX()-radius, center.getY()-radius, 2*radius, 2*radius);

    }

    public void fillCircle(Point2D center, double radius, Color color) {
        strokeCircle(center, radius, color);
        setFill(color);
        gc.fillOval(center.getX()-radius, center.getY()-radius, 2*radius, 2*radius);
    }

    public void strokeRectangle(Point2D leftTopCorner, double width, double height, Color color) {
        setStroke(color);
        gc.strokeRect(leftTopCorner.getX(), leftTopCorner.getY(), width, height);
    }

    public void fillRectangle(Point2D leftTopCorner, double width, double height, Color color) {
        strokeRectangle(leftTopCorner, width, height, color);
        setFill(color);
        gc.fillRect(leftTopCorner.getX(), leftTopCorner.getY(), width, height);
    }
}

