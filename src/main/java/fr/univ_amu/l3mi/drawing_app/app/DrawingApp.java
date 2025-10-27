package fr.univ_amu.l3mi.drawing_app.app;

import fr.univ_amu.l3mi.drawing_app.controller.DrawingAppController;
import fr.univ_amu.l3mi.drawing_app.controller.canvas.Mode;
import fr.univ_amu.l3mi.drawing_app.view.*;


import fr.univ_amu.l3mi.drawing_app.view.configuration.*;

import java.util.List;

public class DrawingApp {

    static void main() {
        DrawingAppConfiguration drawingAppConfiguration = new DrawingAppConfiguration("Drawing App",
                new CanvasDimensions(1000, 800),
                List.of(new ColorPickerConfiguration("Color", "ColorPicker")),
                List.of(new ComboBoxConfiguration("Opacity", "OpacityComboBox", List.of("0", "0.25" , "0.5", "0.75", "1.0")),
                        new ComboBoxConfiguration("Stroke width", "StrokeWidthComboBox", List.of("1" , "2", "4", "8", "16")),
                        new ComboBoxConfiguration("Mode", "ModeComboBox", Mode.getNames())
                        ),
                List.of(new LabeledElementConfiguration("Undo", "UndoButton", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Redo", "RedoButton", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Clear", "ClearButton", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Save", "SaveButton", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Load", "LoadButton", LabeledElementKind.BUTTON),
                        new LabeledElementConfiguration("Export to SVG", "SVGButton", LabeledElementKind.BUTTON)
                ));
        Controller<DrawingAppView> controller = new DrawingAppController();
        DrawingAppLauncher<DrawingAppView> launcher = JavaFXAppLauncher.getInstance();
        launcher.launchApplication(drawingAppConfiguration, controller);
    }
}