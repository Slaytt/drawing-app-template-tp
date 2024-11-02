package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.DrawingAppConfiguration;

public interface DrawingAppLauncher<V> {

    void launchApplication(DrawingAppConfiguration configuration,
                           Controller<V> controller);
}
