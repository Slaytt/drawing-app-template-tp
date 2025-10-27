package fr.univ_amu.l3mi.drawing_app.controller.canvas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public enum Mode {

    VIEWER_MODE("Viewer", "v", CanvasControllerContext::switchToViewerMode),
    RECTANGLE_EDITION("Rectangle", "r", CanvasControllerContext::switchToRectangleEdition),
    CIRCLE_EDITION("Circle", "c", CanvasControllerContext::switchToCircleEdition),
    POLYGON_EDITION("Polygon", "p", CanvasControllerContext::switchToPolygonEdition),
    MOVE_EDITION("Move", "m", CanvasControllerContext::switchToMoveMode),
    DELETE_MODE("Delete", "d", CanvasControllerContext::switchToDeleteMode);


    private final String name;
    private final String key;
    private final Consumer<CanvasControllerContext> switchMode;

    Mode(String name, String key, Consumer<CanvasControllerContext> switchMode) {
        this.name = name;
        this.key = key;
        this.switchMode = switchMode;
    }


    public void switchMode(CanvasControllerContext canvasControllerContext){
        switchMode.accept(canvasControllerContext);
    }

    public String getName() {
        return name;
    }

    public static List<String> getNames() {
        return Arrays.stream(values()).map(Mode::getName).toList();
    }

    public static Optional<Mode> getModeByKey(String key) {
        for (Mode mode : Mode.values()) {
            if (mode.key.equals(key)) return Optional.of(mode);
        }
        return Optional.empty();
    }
    public static Mode getModeByName(String name) {
        for (Mode mode : Mode.values()) {
            if (mode.name.equals(name)) return mode;
        }
        throw new IllegalArgumentException("Unknown name: " + name);
    }
}
