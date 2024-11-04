package fr.univ_amu.l3mi.drawing_app.view;

/**
 * The CanvasController interface defines methods for handling mouse actions
 * on a canvas. Implementations of this interface should provide specific actions
 * for left and right mouse button presses, releases, and movement.
 */
public interface CanvasController {

    /**
     * Invoked when the left mouse button is pressed on the canvas.
     *
     * @param x the x-coordinate where the mouse was pressed.
     * @param y the y-coordinate where the mouse was pressed.
     */
    void actionOnLeftMousePressed(double x, double y);

    /**
     * Invoked when the left mouse button is released on the canvas.
     *
     * @param x the x-coordinate where the mouse was released.
     * @param y the y-coordinate where the mouse was released.
     */
    void actionOnLeftMouseReleased(double x, double y);

    /**
     * Invoked when the right mouse button is pressed on the canvas.
     *
     * @param x the x-coordinate where the mouse was pressed.
     * @param y the y-coordinate where the mouse was pressed.
     */
    void actionOnRightMousePressed(double x, double y);

    /**
     * Invoked when the right mouse button is released on the canvas.
     *
     * @param x the x-coordinate where the mouse was released.
     * @param y the y-coordinate where the mouse was released.
     */
    void actionOnRightMouseReleased(double x, double y);

    /**
     * Invoked when the mouse is moved on the canvas.
     *
     * @param x the current x-coordinate of the mouse.
     * @param y the current y-coordinate of the mouse.
     */
    void actionOnMouseMoved(double x, double y);
}

