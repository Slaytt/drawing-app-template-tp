package fr.univ_amu.l3mi.drawing_app.view;

import fr.univ_amu.l3mi.drawing_app.view.configuration.DrawingAppConfiguration;

import fr.univ_amu.l3mi.drawing_app.view.javafx.app.JavaFXDrawingApp;
import javafx.application.Application;


/**
 * Singleton class responsible for launching a board game application using JavaFX.
 * It implements the {@link DrawingAppLauncher} interface and manages the configuration, controller,
 * and view initializer for the game.
 */
public class JavaFXDrawingAppLauncher implements DrawingAppLauncher {

    /** The singleton instance of the launcher. */
    private static JavaFXDrawingAppLauncher instance = null;

    /** The configuration of the board game. */
    private DrawingAppConfiguration configuration;

    /** The controller that manages game interactions. */
    private DrawingAppController controller;

    /** Private constructor to prevent direct instantiation. */
    private JavaFXDrawingAppLauncher() {}

    /**
     * Retrieves the singleton instance of the {@code JavaFXBoardGameApplicationLauncher}.
     * If the instance does not already exist, it is created in a thread-safe manner.
     *
     * @return the singleton instance of the launcher.
     */
    public static JavaFXDrawingAppLauncher getInstance() {
        JavaFXDrawingAppLauncher result = instance;
        if (result != null) {
            return result;
        }
        synchronized(JavaFXDrawingAppLauncher.class) {
            if (instance == null) {
                instance = new JavaFXDrawingAppLauncher();
            }
            return instance;
        }
    }

    /**
     * Retrieves the current board game configuration.
     *
     * @return the {@link DrawingAppConfiguration} for the game.
     */
    public DrawingAppConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Retrieves the current controller managing the game.
     *
     * @return the {@link DrawingAppController} for the game.
     */
    public DrawingAppController getController() {
        return controller;
    }

    /**
     * Launches the JavaFX board game application with the specified configuration and controller.
     * This method sets the internal fields and starts the JavaFX application.
     *
     * @param configuration the configuration of the board game, represented by {@link DrawingAppConfiguration}.
     * @param controller    the controller that manages game interactions, implemented by {@link DrawingAppController}.
     */
    @Override
    public void launchApplication(DrawingAppConfiguration configuration,
                                  DrawingAppController controller) {
        this.configuration = configuration;
        this.controller = controller;
        Application.launch(JavaFXDrawingApp.class);
    }
}

