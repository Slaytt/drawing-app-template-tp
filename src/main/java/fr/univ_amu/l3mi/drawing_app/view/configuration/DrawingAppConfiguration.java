package fr.univ_amu.l3mi.drawing_app.view.configuration;

import java.util.List;


public record DrawingAppConfiguration(String title,
                                      CanvasDimensions dimensions,
                                      List<LabeledElementConfiguration> labeledElementConfigurations) {
}
