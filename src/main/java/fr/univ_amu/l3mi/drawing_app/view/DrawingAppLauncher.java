package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.DrawingAppConfiguration;

public interface DrawingAppLauncher {

    void launchApplication(DrawingAppConfiguration configuration,
                           DrawingAppController controller);
}
