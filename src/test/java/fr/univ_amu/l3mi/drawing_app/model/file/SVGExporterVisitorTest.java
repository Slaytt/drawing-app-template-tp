package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.*;

class SVGExporterVisitorTest {

    private SVGExporterVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new SVGExporterVisitor();
    }

    @Test
    void convertColorToString_shouldReturnRgbaFormat() {
        // Given
        Color color = new Color(0.5, 0.25, 0.75, 1.0); // RGB = (128, 64, 191), alpha = 1.0

        // When
        String result = visitor.convertColorToString(color);

        // Then
        assertThat(result)
                .isEqualTo("rgba(127.5,63.75,191.25,1.0)")
                .contains("rgba(")
                .contains(",")
                .contains(")");
    }

    @Test
    void visitRectangle_shouldReturnValidSvgRectElement() {
        // Given
        Rectangle rect = new Rectangle(
                new Point2D(10, 20),
                new Point2D(110, 70),
                Color.RED,
                Color.BLUE,
                2.0
        );

        // When
        String result = visitor.visit(rect);

        // Then
        assertThat(result)
                .startsWith("<rect")
                .contains("x=\"10.0\"")
                .contains("y=\"20.0\"")
                .contains("width=\"100.0\"")
                .contains("height=\"50.0\"")
                .contains("fill=\"rgba(")
                .contains("stroke=\"rgba(")
                .contains("stroke-width=\"2.0\"")
                .endsWith("\" />");
    }

    @Test
    void writeShapes_shouldWriteValidSvgDocument() throws IOException {
        // Given
        ShapeContainer container = new ShapeContainer();
        container.setWidth(500);
        container.setHeight(400);

        Rectangle rect = new Rectangle(
                new Point2D(0, 0),
                new Point2D(100, 50),
                Color.GREEN,
                Color.BLACK,
                1.5
        );
        container.addShape(rect);

        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);

        // When
        visitor.writeShapes(container, writer);
        writer.flush();

        String result = stringWriter.toString();

        // Then
        assertThat(result)
                .startsWith("<svg width=\"500.0\" height=\"400.0\" xmlns=\"http://www.w3.org/2000/svg\">")
                .contains("<rect")
                .contains("</svg>")
                .contains("fill=\"rgba(")
                .contains("stroke=\"rgba(");
    }
}

