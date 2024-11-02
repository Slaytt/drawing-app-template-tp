package fr.univ_amu.l3mi.drawing_app.controller;

import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class FillVisitor extends DrawVisitor{
    public FillVisitor(DrawingAppView view) {
        super(view);
    }

    @Override
    protected void drawRectangle(Point2D leftTopCorner, double width, double height, Color color) {
        view.fillRectangle(leftTopCorner, width, height, color);
    }
}
