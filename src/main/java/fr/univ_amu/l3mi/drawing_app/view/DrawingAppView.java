package fr.univ_amu.l3mi.drawing_app.view;


import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public interface DrawingAppView {

    void updateLabeledElementText(String id, String newText);

    void setComboBoxChoice(String id, String choice);

    void setColorPicked(String id, Color color);

    void clearCanvas();

    void fillRectangle(Point2D leftTopCorner, double width, double height, Color color);

    void strokeRectangle(Point2D leftTopCorner, double width, double height, Color color);

    void fillCircle(Point2D center, double radius, Color color);

    void strokeCircle(Point2D center, double radius, Color color);

    void fillPolygon(Point2D[] points, Color color);

    void strokePolygon(Point2D[] points, Color color);

    void strokeLine(Point2D endPoint1, Point2D endPoint2, Color color);

    void strokePolyline(Point2D[] points, Color color);
}
