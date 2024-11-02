package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.ColorPickerConfiguration;
import fr.univ_amu.l3mi.drawing_app.view.configuration.ComboBoxConfiguration;
import fr.univ_amu.l3mi.drawing_app.view.configuration.DrawingAppConfiguration;
import fr.univ_amu.l3mi.drawing_app.view.configuration.LabeledElementConfiguration;

public class DrawingAppConfigurator {
    public void configure(DrawingAppViewBuilder drawingAppViewBuilder,
                          DrawingAppConfiguration drawingAppConfiguration) {
        drawingAppViewBuilder = drawingAppViewBuilder
                .resetView()
                .setTitle(drawingAppConfiguration.title())
                .setCanvasDimensions(drawingAppConfiguration.dimensions().width(),
                        drawingAppConfiguration.dimensions().height());
        for(ColorPickerConfiguration colorPickerConfiguration : drawingAppConfiguration.colorPickerConfigurations())
            drawingAppViewBuilder = drawingAppViewBuilder.addColorPicker(colorPickerConfiguration.id(),
                    colorPickerConfiguration.label());
        for (ComboBoxConfiguration comboBoxConfiguration : drawingAppConfiguration.comboBoxConfigurations())
            drawingAppViewBuilder = drawingAppViewBuilder.addComboBox(comboBoxConfiguration.id(),
                    comboBoxConfiguration.choices(),
                    comboBoxConfiguration.initialChoice());
        for (LabeledElementConfiguration elementConfiguration : drawingAppConfiguration.labeledElementConfigurations()) {
            switch (elementConfiguration.kind()) {
                case BUTTON -> drawingAppViewBuilder = drawingAppViewBuilder.addButton(elementConfiguration.id(), elementConfiguration.label());
                case TEXT -> drawingAppViewBuilder = drawingAppViewBuilder.addLabel(elementConfiguration.id(), elementConfiguration.label());
            }
        }
    }
}
