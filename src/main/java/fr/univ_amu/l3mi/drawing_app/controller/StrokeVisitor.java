package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.view.Color;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import javafx.geometry.Point2D;

public class StrokeVisitor extends DrawVisitor{
    public StrokeVisitor(DrawingAppView view) {
        super(view);
    }

    @Override
    protected void drawRectangle(Point2D leftTopCorner, double width, double height, Color color) {
        view.strokeRectangle(leftTopCorner, width, height, color);
    }
}
