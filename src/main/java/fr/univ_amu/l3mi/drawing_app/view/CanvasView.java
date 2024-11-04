package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.CanvasDimensions;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * The CanvasView interface defines methods for drawing shapes and managing
 * a canvas for graphical representations. Implementations of this interface
 * should provide functionalities for clearing the canvas, drawing basic shapes,
 * and configuring the canvas dimensions.
 */
public interface CanvasView {

    /**
     * Clears the entire canvas, removing any drawn shapes or content.
     */
    void clearCanvas();

    /**
     * Draws a rectangle on the canvas.
     *
     * @param topLeftCorner the top-left corner of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     * @param fillColor the color used to fill the rectangle.
     * @param strokeColor the color of the rectangle's border.
     * @param strokeWidth the thickness of the rectangle's border.
     */
    void drawRectangle(Point2D topLeftCorner, double width, double height, Color fillColor, Color strokeColor, double strokeWidth);

    /**
     * Draws a circle on the canvas.
     *
     * @param center the center point of the circle.
     * @param radius the radius of the circle.
     * @param fillColor the color used to fill the circle.
     * @param strokeColor the color of the circle's border.
     * @param strokeWidth the thickness of the circle's border.
     */
    void drawCircle(Point2D center, double radius, Color fillColor, Color strokeColor, double strokeWidth);

    /**
     * Draws a polygon on the canvas.
     *
     * @param points an array of points representing the vertices of the polygon.
     * @param fillColor the color used to fill the polygon.
     * @param strokeColor the color of the polygon's border.
     * @param strokeWidth the thickness of the polygon's border.
     */
    void drawPolygon(Point2D[] points, Color fillColor, Color strokeColor, double strokeWidth);

    /**
     * Draws a line on the canvas.
     *
     * @param startPoint the starting point of the line.
     * @param endPoint the ending point of the line.
     * @param color the color of the line.
     * @param strokeWidth the thickness of the line.
     */
    void drawLine(Point2D startPoint, Point2D endPoint, Color color, double strokeWidth);

    /**
     * Retrieves the current dimensions of the canvas.
     *
     * @return a CanvasDimensions object representing the canvas's width and height.
     */
    CanvasDimensions getCanvasDimensions();

    /**
     * Sets the dimensions of the canvas.
     *
     * @param canvasDimensions a CanvasDimensions object specifying the new width and height of the canvas.
     */
    void setCanvasDimensions(CanvasDimensions canvasDimensions);
}

