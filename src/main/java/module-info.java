module fr.univ_amu.l3mi.drawing_app {
    requires javafx.controls;
    requires java.desktop;
    requires javafx.graphics;

    exports fr.univ_amu.l3mi.drawing_app.view;
    exports fr.univ_amu.l3mi.drawing_app.app;
    exports fr.univ_amu.l3mi.drawing_app.view.javafx.app;
    exports fr.univ_amu.l3mi.drawing_app.view.configuration;
    exports fr.univ_amu.l3mi.drawing_app.view.javafx.view;
    exports fr.univ_amu.l3mi.drawing_app.view.javafx.bar;
    exports fr.univ_amu.l3mi.drawing_app.view.javafx.canvas;
    exports fr.univ_amu.l3mi.drawing_app.controller;
    exports fr.univ_amu.l3mi.drawing_app.model;
    exports fr.univ_amu.l3mi.drawing_app.controller.canvas;
    exports fr.univ_amu.l3mi.drawing_app.model.file;
}