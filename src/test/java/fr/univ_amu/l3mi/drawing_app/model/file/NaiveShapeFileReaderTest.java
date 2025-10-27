package fr.univ_amu.l3mi.drawing_app.model.file;

import fr.univ_amu.l3mi.drawing_app.model.Rectangle;
import fr.univ_amu.l3mi.drawing_app.model.ShapeContainer;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.*;

class NaiveShapeFileReaderTest {

    private NaiveShapeFileReader reader;
    private ShapeContainer container;

    @BeforeEach
    void setUp() {
        reader = new NaiveShapeFileReader();
        container = new ShapeContainer();
    }

    @Test
    void shouldReadWidthHeightAndRectangle() throws IOException {
        // Given
        String data = """
                Width 800
                Height 600
                Rectangle 0 0 100 50 #ff0000 #000000 2.0
                """;

        BufferedReader bufferedReader = new BufferedReader(new StringReader(data));

        // When
        reader.readShapes(container, bufferedReader);

        // Then
        assertThat(container.getWidth()).isEqualTo(800.0);
        assertThat(container.getHeight()).isEqualTo(600.0);

        assertThat(container.getShapes())
                .hasSize(1)
                .first()
                .isInstanceOf(Rectangle.class);

        Rectangle rect = (Rectangle) container.getShapes().getFirst();
        assertThat(rect.getTopLeftCorner()).isEqualTo(new Point2D(0, 0));
        assertThat(rect.getWidth()).isEqualTo(100);
        assertThat(rect.getHeight()).isEqualTo(50);
        assertThat(rect.getFillColor()).isEqualTo(Color.web("#ff0000"));
        assertThat(rect.getStrokeColor()).isEqualTo(Color.web("#000000"));
        assertThat(rect.getStrokeWidth()).isEqualTo(2.0);
    }

    @Test
    void shouldUseDefaultWidthAndHeightWhenNotProvided() throws IOException {
        // Given
        String data = """
                Rectangle 10 20 30 40 #00ff00 #0000ff 1.5
                """;

        BufferedReader bufferedReader = new BufferedReader(new StringReader(data));

        // When
        reader.readShapes(container, bufferedReader);

        // Then
        assertThat(container.getWidth()).isEqualTo(NaiveShapeFileReader.DEFAULT_WIDTH);
        assertThat(container.getHeight()).isEqualTo(NaiveShapeFileReader.DEFAULT_HEIGHT);
        assertThat(container.getWidth()).isEqualTo(NaiveShapeFileReader.DEFAULT_WIDTH);
        assertThat(container.getShapes()).hasSize(1);
    }

    @Test
    void shouldThrowIOExceptionWhenInvalidLine() {
        // Given
        String data = """
                Width 500
                InvalidLine
                """;

        BufferedReader bufferedReader = new BufferedReader(new StringReader(data));

        // When / Then
        assertThatThrownBy(() -> reader.readShapes(container, bufferedReader))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("Parse error");
    }

    @Test
    void shouldClearContainerBeforeReading() throws IOException {
        // Given : un container déjà rempli
        container.addShape(new Rectangle(
                new Point2D(1, 1),
                new Point2D(2, 2),
                Color.RED,
                Color.BLACK,
                1.0
        ));

        String data = """
                Width 400
                Height 300
                """;

        BufferedReader bufferedReader = new BufferedReader(new StringReader(data));

        // When
        reader.readShapes(container, bufferedReader);

        // Then
        assertThat(container.getShapes()).isEmpty();
        assertThat(container.getWidth()).isEqualTo(400.0);
        assertThat(container.getHeight()).isEqualTo(300.0);
    }
}
