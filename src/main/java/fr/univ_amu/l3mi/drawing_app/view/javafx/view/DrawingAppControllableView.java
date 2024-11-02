package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import fr.univ_amu.l3mi.drawing_app.view.Controller;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;


public interface DrawingAppControllableView extends DrawingAppView {
    void setController(Controller<DrawingAppView> controller);
}
