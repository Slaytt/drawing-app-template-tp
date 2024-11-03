package fr.univ_amu.l3mi.drawing_app.model;

public class FileSaver implements ShapeVisitor<String> {
    public String exportToDAFF(ShapeContainer shapeContainer) {

    }

    @Override
    public String visit(Rectangle r) {
        return "Rectangle " + r.getPoint();
    }
}
