package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class SVGExporterVisitor implements ShapeVisitor<String> {
    public static final int COLOR_RANGE = 255;

    String convertColorToString(Color color) {
        return "rgba(" + color.getRed() * COLOR_RANGE +
                ',' +
                color.getGreen() * COLOR_RANGE +
                ',' +
                color.getBlue() * COLOR_RANGE +
                ',' +
                color.getOpacity() +
                ')';
    }


    public String exportToSVG(ShapeContainer shapeContainer) {
        StringBuilder sb = new StringBuilder("<svg width=\"");
        sb.append(shapeContainer.getWidth())
                .append("\" height=\"")
                .append(shapeContainer.getHeight())
                .append("\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (Shape shape : shapeContainer.getShapes()) {
            sb.append(shape.accept(this));
        }
        sb.append("</svg>\n");
        return sb.toString();
    }

    @Override
    public String visit(Rectangle rectangle) {
        Point2D upperLeftCorner = rectangle.getPoint(0);
        Point2D lowerRightCorner = rectangle.getPoint(1);
        double width = lowerRightCorner.getX() - upperLeftCorner.getX();
        double height = lowerRightCorner.getY() - upperLeftCorner.getY();
        return "<rect x=\"" + upperLeftCorner.getX() +
                "\" y=\"" +
                upperLeftCorner.getY() +
                "\" width=\"" +
                width +
                "\" height=\"" +
                height +
                "\" fill=\"" +
                convertColorToString(rectangle.getFillColor()) +
                "\" stroke=\"" +
                convertColorToString(rectangle.getStrokeColor()) +
                "\" stroke-width=\"" +
                rectangle.getStrokeWidth() +
                "\" />\n";
    }
}
