package fr.univ_amu.l3mi.drawing_app.view.javafx.view;

public enum FileExtension {
    SVG("*.svg", "Scalable Vector Graphics"),
    DAFF("*.daff", "Drawing App File Format");

    public final String extension;
    public final String fileFormatName;

    FileExtension(String extension, String FileFormatName) {
        this.extension = extension;
        this.fileFormatName = FileFormatName;
    }

}
