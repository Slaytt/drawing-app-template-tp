package fr.univ_amu.l3mi.drawing_app;

import fr.univ_amu.l3mi.drawing_app.view.*;



import fr.univ_amu.l3mi.drawing_app.view.configuration.DrawingAppConfiguration;
import fr.univ_amu.l3mi.drawing_app.view.configuration.LabeledElementConfiguration;
import fr.univ_amu.l3mi.drawing_app.view.configuration.LabeledElementKind;
import fr.univ_amu.l3mi.drawing_app.view.configuration.CanvasDimensions;
import javafx.geometry.Point2D;

import java.util.List;

public class HelloApplication {

    private static class HelloController implements DrawingAppController {
        private DrawingAppView view;

        @Override
        public void initializeViewOnStart(DrawingAppView view) {
            this.view = view;
            view.fillPolygon(new Point2D[]{ new Point2D(300, 300),
                    new Point2D(100, 300), new Point2D(300, 100)}, Color.LIGHT_RED);
            view.strokePolygon(new Point2D[]{ new Point2D(500, 500),
                    new Point2D(300, 500), new Point2D(500, 300)}, Color.LIGHT_RED);
        }


        @Override
        public void actionOnLeftMousePressed(double x, double y) {
            view.fillCircle(new Point2D(x,y), 10, Color.DARKRED);
        }

        @Override
        public void actionOnLeftMouseReleased(double x, double y) {
            view.fillCircle(new Point2D(x,y), 20, Color.DARKBLUE);
        }

        @Override
        public void actionOnRightMousePressed(double x, double y) {
            view.fillCircle(new Point2D(x,y), 10, Color.DARKGREEN);
        }

        @Override
        public void actionOnRightMouseReleased(double x, double y) {
            view.fillCircle(new Point2D(x,y), 20, Color.GREEN);
        }

        @Override
        public void actionOnMouseMoved(double x, double y) {
            view.fillCircle(new Point2D(x,y), 20, Color.GREEN);
        }

        @Override
        public void actionOnKeyPressed(String text) {
            switch (text) {
                case "t" -> view.fillPolygon(new Point2D[]{ new Point2D(300, 300),
                        new Point2D(100, 300), new Point2D(300, 100)}, Color.LIGHT_RED);
                case "c" -> view.fillCircle(new Point2D(700,700), 50, Color.DARKBLUE);
                default -> System.err.println("Unknown key : " + text);
            }
        }

        @Override
        public void buttonActionOnClick(String buttonId) {
            switch (buttonId) {
                case "ButtonChangeLabel" -> {
                    view.updateLabeledElement("SampleLabel", "Updated Text");
                    view.updateLabeledElement("ButtonChangeLabel", "Updated Text");
                }
                case "StrokeLine" -> {
                    view.strokeLine(new Point2D(200,200), new Point2D(600, 600), Color.BLACK);
                }
                case "Clear" -> {
                    view.clearCanvas();
                }
                default -> throw new IllegalStateException("Unexpected event, button id : " + buttonId);
            }
        }
    }

    public static void main(String[] args) {
        DrawingAppConfiguration drawingAppConfiguration = new DrawingAppConfiguration("Hello World",
                new CanvasDimensions(800, 800),
                List.of(new LabeledElementConfiguration("Change button & label", "ButtonChangeLabel", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Stroke Line", "StrokeLine", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Clear", "Clear", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Initial Text", "SampleLabel", LabeledElementKind.TEXT)
                ));
        DrawingAppController controller = new HelloController();
        DrawingAppLauncher launcher = JavaFXDrawingAppLauncher.getInstance();
        launcher.launchApplication(drawingAppConfiguration, controller);
    }
}