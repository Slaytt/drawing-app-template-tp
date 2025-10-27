package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import static javafx.scene.paint.Color.*;
import static org.assertj.core.api.Assertions.*;



public class ShapeFileWriterVisitorTest {

    private ShapeFileWriterVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new ShapeFileWriterVisitor();
    }

    @Test
    void visitRectangle_shouldReturnFormattedString() {
        // Given
        Rectangle rect = new Rectangle(new Point2D(1, 2), new Point2D(3, 4), RED, BLACK, 1.0);

        // When
        String result = visitor.visit(rect);

        // Then
        assertThat(result)
                .isEqualTo("Rectangle 1.0 2.0 3.0 4.0 0xff0000ff 0x000000ff 1.0");
    }

    @Test
    void writeShapes_shouldWriteContainerInfoAndShapes() throws IOException {
        // Given
        ShapeContainer container = new ShapeContainer();
        container.setWidth(100);
        container.setHeight(200);

        Rectangle rect = new Rectangle(new Point2D(1, 2), new Point2D(3, 4), BLUE, GREEN, 1.0);

        container.addShape(rect);

        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);

        // When
        visitor.writeShapes(container, writer);
        writer.flush();

        // Then
        String output = stringWriter.toString();

        assertThat(output)
                .contains("Width 100.0")
                .contains("Height 200.0")
                .contains("Rectangle 1.0 2.0 3.0 4.0 0x0000ffff 0x008000ff 1.0");
    }
}
