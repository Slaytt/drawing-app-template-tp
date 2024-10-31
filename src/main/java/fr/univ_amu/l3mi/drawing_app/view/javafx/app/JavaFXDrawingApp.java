package fr.univ_amu.l3mi.drawing_app.view.javafx.app;

import fr.univ_amu.l3mi.drawing_app.view.JavaFXDrawingAppLauncher;
import fr.univ_amu.l3mi.drawing_app.view.javafx.view.DrawingAppConfigurator;
import fr.univ_amu.l3mi.drawing_app.view.javafx.view.DrawingAppControllableView;
import fr.univ_amu.l3mi.drawing_app.view.javafx.view.JavaFXDrawingAppViewBuilder;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXDrawingApp extends Application {


    @Override
    public void start(Stage stage) {
        var launcher = JavaFXDrawingAppLauncher.getInstance();
        var configuration = launcher.getConfiguration();
        var controller = launcher.getController();
        final JavaFXDrawingAppViewBuilder viewBuilder = new JavaFXDrawingAppViewBuilder(stage);
        new DrawingAppConfigurator().configure(viewBuilder, configuration);
        DrawingAppControllableView view = viewBuilder.getView();
        view.setController(controller);
        controller.initializeViewOnStart(view);
        stage.show();
    }
}
