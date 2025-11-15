package fr.univ_amu.l3mi.drawing_app.model;

public interface ShapeVisitor<R> {
    R visit(Rectangle r);
    R visit(Circle c);
    R visit(Polygon p);

}
