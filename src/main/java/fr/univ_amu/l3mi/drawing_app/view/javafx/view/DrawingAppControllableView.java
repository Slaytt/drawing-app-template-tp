package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

import fr.univ_amu.l3mi.drawing_app.view.DrawingAppController;
import fr.univ_amu.l3mi.drawing_app.view.DrawingAppView;


public interface DrawingAppControllableView extends DrawingAppView {
    void setController(DrawingAppController controller);
}
