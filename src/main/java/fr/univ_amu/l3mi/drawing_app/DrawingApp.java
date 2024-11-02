package fr.univ_amu.l3mi.drawing_app;

import fr.univ_amu.l3mi.drawing_app.controller.DrawingAppController;
import fr.univ_amu.l3mi.drawing_app.view.*;


import fr.univ_amu.l3mi.drawing_app.view.configuration.*;

import java.util.List;

public class DrawingApp {

    public static void main(String[] args) {
        DrawingAppConfiguration drawingAppConfiguration = new DrawingAppConfiguration("Drawing App",
                new CanvasDimensions(800, 800),
                List.of(new ColorPickerConfiguration("Color", "ColorPicker")),
                List.of(new ComboBoxConfiguration("Mode", "ModeComboBox", List.of("Viewer", "Rectangle"), "Viewer")),
                List.of(new LabeledElementConfiguration("Clear", "ClearButton", LabeledElementKind.BUTTON)
                ));
        Controller<DrawingAppView> controller = new DrawingAppController();
        DrawingAppLauncher launcher = JavaFXAppLauncher.getInstance();
        launcher.launchApplication(drawingAppConfiguration, controller);
    }
}