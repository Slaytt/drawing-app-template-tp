package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import java.util.Arrays;
import java.util.List;

public enum Mode {

    VIEWER_MODE("Viewer", "v"), RECTANGLE_EDITION("Rectangle", "r"),
    CIRCLE_EDITION("Circle", "c"), POLYGON_EDITION("Polygon", "p"),
    MOVE_EDITION("Move", "m"), DELETE_MODE("Delete", "d");

    private final String name;
    private final String key;

    Mode(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public static List<String> getNames() {
        return Arrays.stream(values()).map(Mode::getName).toList();
    }

    public static Mode getModeByKey(String key) {
        for (Mode mode : Mode.values()) {
            if (mode.key.equals(key)) return mode;
        }
        throw new IllegalArgumentException("Unknown key: " + key);
    }
    public static Mode getModeByName(String name) {
        for (Mode mode : Mode.values()) {
            if (mode.name.equals(name)) return mode;
        }
        throw new IllegalArgumentException("Unknown name: " + name);
    }
}
