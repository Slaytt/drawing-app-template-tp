package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.DrawingAppConfiguration;

import fr.univ_amu.l3mi.drawing_app.view.javafx.app.JavaFXDrawingApp;
import javafx.application.Application;

import java.util.Locale;


public class JavaFXAppLauncher implements DrawingAppLauncher<DrawingAppView> {

    private static JavaFXAppLauncher instance = null;

    private DrawingAppConfiguration configuration;

    private Controller<DrawingAppView> controller;

    private JavaFXAppLauncher() {}

    public static JavaFXAppLauncher getInstance() {
        Locale.setDefault(Locale.ENGLISH);
        JavaFXAppLauncher result = instance;
        if (result != null) {
            return result;
        }
        synchronized(JavaFXAppLauncher.class) {
            if (instance == null) {
                instance = new JavaFXAppLauncher();
            }
            return instance;
        }
    }

    public DrawingAppConfiguration getConfiguration() {
        return configuration;
    }

    public Controller<DrawingAppView> getController() {
        return controller;
    }

    @Override
    public void launchApplication(DrawingAppConfiguration configuration,
                                  Controller<DrawingAppView> controller) {
        this.configuration = configuration;
        this.controller = controller;
        Application.launch(JavaFXDrawingApp.class);
    }
}

