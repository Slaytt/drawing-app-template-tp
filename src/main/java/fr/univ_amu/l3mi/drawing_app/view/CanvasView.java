package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.CanvasDimensions;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public interface CanvasView {
    void clearCanvas();

    void drawRectangle(Point2D leftTopCorner, double width, double height, Color fillColor, Color strokeColor, double strokeWidth);

    void drawCircle(Point2D center, double radius, Color fillColor, Color strokeColor, double strokeWidth);
    
    void drawPolygon(Point2D[] points, Color fillColor, Color strokeColor, double strokeWidth);

    void drawLine(Point2D startPoint, Point2D endPoint, Color color, double strokeWidth);

    CanvasDimensions getCanvasDimensions();

    void setCanvasDimensions(CanvasDimensions canvasDimensions);
}
