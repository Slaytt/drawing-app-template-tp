package fr.univ_amu.l3mi.drawing_app.model;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RectangleTest {
    int x1, y1, x2, y2;
    Point2D corner1;
    Point2D oppositeCorner1;
    Point2D corner2;
    Point2D oppositeCorner2;
    Color fillColor;
    Color stokeColor;
    int strokeWidth;
    Rectangle rectangle1;
    Rectangle rectangle2;
    Rectangle rectangle3;
    Rectangle rectangle4;

    @BeforeEach
    void setUp() {
        x1 = 10;
        x2 = 20;
        y1 = 30;
        y2 = 50;
        corner1 = new Point2D(x1, y1);
        oppositeCorner1 = new Point2D(x2, y2);
        corner2 = new Point2D(x2, y1);
        oppositeCorner2 = new Point2D(x1, y2);
        fillColor = Color.ALICEBLUE;
        stokeColor = Color.AZURE;
        strokeWidth = 10;
        rectangle1 = new Rectangle(corner1, oppositeCorner1, fillColor,
                stokeColor, strokeWidth);
        rectangle2 = new Rectangle(corner2, oppositeCorner2, fillColor,
                stokeColor, strokeWidth);
        rectangle3 = new Rectangle(oppositeCorner2, corner2, fillColor,
                stokeColor, strokeWidth);
        rectangle4 = new Rectangle(oppositeCorner1, corner1, fillColor,
                stokeColor, strokeWidth);
    }

    @Test
    void testGetPoint(){
        assertThat(rectangle1.getPoint(0)).isEqualTo(corner1);
        assertThat(rectangle2.getPoint(0)).isEqualTo(corner1);
        assertThat(rectangle3.getPoint(0)).isEqualTo(corner1);
        assertThat(rectangle4.getPoint(0)).isEqualTo(corner1);
        assertThat(rectangle1.getPoint(1)).isEqualTo(oppositeCorner1);
        assertThat(rectangle2.getPoint(1)).isEqualTo(oppositeCorner1);
        assertThat(rectangle3.getPoint(1)).isEqualTo(oppositeCorner1);
        assertThat(rectangle4.getPoint(1)).isEqualTo(oppositeCorner1);
    }

    @Test
    void testGetTopLeftCorner(){
        assertThat(rectangle1.getTopLeftCorner()).isEqualTo(corner1);
        assertThat(rectangle2.getTopLeftCorner()).isEqualTo(corner1);
        assertThat(rectangle3.getTopLeftCorner()).isEqualTo(corner1);
        assertThat(rectangle4.getTopLeftCorner()).isEqualTo(corner1);
    }

    @Test
    void testGetWidth(){
        assertThat(rectangle1.getWidth()).isEqualTo(x2-x1);
        assertThat(rectangle2.getWidth()).isEqualTo(x2-x1);
        assertThat(rectangle3.getWidth()).isEqualTo(x2-x1);
        assertThat(rectangle4.getWidth()).isEqualTo(x2-x1);
    }

    @Test
    void testGetHeight(){
        assertThat(rectangle1.getHeight()).isEqualTo(y2-y1);
        assertThat(rectangle2.getHeight()).isEqualTo(y2-y1);
        assertThat(rectangle3.getHeight()).isEqualTo(y2-y1);
        assertThat(rectangle4.getHeight()).isEqualTo(y2-y1);
    }
}