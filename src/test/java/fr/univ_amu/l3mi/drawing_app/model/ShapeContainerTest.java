package fr.univ_amu.l3mi.drawing_app.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

// Classe factice pour représenter une Shape
class DummyShape implements Shape {

    @Override
    public <R> R accept(ShapeVisitor<R> visitor) {
        return null;
    }

    @Override
    public int getPointsCount() {
        return 0;
    }

    @Override
    public Color getFillColor() {
        return null;
    }

    @Override
    public Color getStrokeColor() {
        return null;
    }

    @Override
    public double getStrokeWidth() {
        return 0;
    }

    @Override
    public Point2D getPoint(int index) {
        return null;
    }
}

public class ShapeContainerTest {

    private ShapeContainer container;

    @BeforeEach
    void setUp() {
        container = new ShapeContainer();
    }

    @Test
    void shouldSetAndGetWidthAndHeight() {
        // When
        container.setWidth(100.5);
        container.setHeight(50.2);

        // Then
        assertThat(container.getWidth()).isEqualTo(100.5);
        assertThat(container.getHeight()).isEqualTo(50.2);
    }

    @Test
    void shouldAddShapesToContainer() {
        // Given
        DummyShape shape1 = new DummyShape();
        DummyShape shape2 = new DummyShape();

        // When
        container.addShape(shape1);
        container.addShape(shape2);

        // Then
        assertThat(container.getShapes())
                .hasSize(2)
                .containsExactly(shape1, shape2);
    }

    @Test
    void shouldReturnEmptyListWhenNoShapesAdded() {
        assertThat(container.getShapes())
                .isNotNull()
                .isEmpty();
    }

    @Test
    void shouldClearAllShapes() {
        // Given
        DummyShape shape1 = new DummyShape();
        container.addShape(shape1);
        assertThat(container.getShapes()).isNotEmpty();

        // When
        container.clear();

        // Then
        assertThat(container.getShapes())
                .isEmpty();
    }

    @Test
    void shouldReturnListReferenceConsistent() {
        // Given
        List<Shape> shapesBefore = container.getShapes();

        // When
        container.addShape(new DummyShape());

        // Then
        assertThat(container.getShapes())
                .isSameAs(shapesBefore)
                .hasSize(1);
    }
}

