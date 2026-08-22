package org.firstinspires.ftc.teamcode.internal;

import com.qualcomm.robotcore.hardware.Gamepad;

import dev.nextftc.bindings.Button;
import dev.nextftc.bindings.Range;
import dev.nextftc.bindings.Variable;

import static dev.nextftc.bindings.Bindings.*;

import java.util.function.Supplier;

public class RRGamepad {

    private Supplier<Gamepad> gamepad;

    public RRGamepad(Supplier<Gamepad> gamepad) {
        this.gamepad = gamepad;
    }

    // my fingers hurt
    public final Button a = button(() -> gamepad.get().a);
    public final Button b = button(() -> gamepad.get().b);
    public final Button x = button(() -> gamepad.get().x);
    public final Button y = button(() -> gamepad.get().y);
    public final Button circle = button(() -> gamepad.get().circle);
    public final Button cross = button(() -> gamepad.get().cross);
    public final Button triangle = button(() -> gamepad.get().triangle);
    public final Button square = button(() -> gamepad.get().square);
    public final Button dpadUp = button(() -> gamepad.get().dpad_up);
    public final Button dpadDown = button(() -> gamepad.get().dpad_down);
    public final Button dpadLeft = button(() -> gamepad.get().dpad_left);
    public final Button dpadRight = button(() -> gamepad.get().dpad_right);
    public final Button leftBumper = button(() -> gamepad.get().left_bumper);
    public final Button rightBumper = button(() -> gamepad.get().right_bumper);
    public final Button share = button(() -> gamepad.get().share);
    public final Button options = button(() -> gamepad.get().options);
    public final Button guide = button(() -> gamepad.get().guide);
    public final Button start = button(() -> gamepad.get().start);
    public final Button back = button(() -> gamepad.get().back);
    public final Button leftStickButton = button(() -> gamepad.get().left_stick_button);
    public final Button rightStickButton = button(() -> gamepad.get().right_stick_button);
    public final Button touchpad = button(() -> gamepad.get().touchpad);
    public final Button touchpadFinger1Pressed = button(() -> gamepad.get().touchpad_finger_1);
    public final Button touchpadFinger2Pressed = button(() -> gamepad.get().touchpad_finger_2);

    public final Range leftTrigger = range(() -> gamepad.get().left_trigger);
    public final Range rightTrigger = range(() -> gamepad.get().right_trigger);
    public final Range leftStickX = range(() -> gamepad.get().left_stick_x);
    public final Range leftStickY = range(() -> gamepad.get().left_stick_y);
    public final Range rightStickX = range(() -> gamepad.get().right_stick_x);
    public final Range rightStickY = range(() -> gamepad.get().right_stick_y);
    public final Range touchpadFinger1X = range(() -> gamepad.get().touchpad_finger_1_x);
    public final Range touchpadFinger1Y = range(() -> gamepad.get().touchpad_finger_1_y);
    public final Range touchpadFinger2X = range(() -> gamepad.get().touchpad_finger_2_x);
    public final Range touchpadFinger2Y = range(() -> gamepad.get().touchpad_finger_2_y);

    public final Variable<Joystick> leftStick = variable(() -> new Joystick(
            gamepad.get().left_stick_x,
            gamepad.get().left_stick_y,
            gamepad.get().left_stick_button
    ));

    public final Variable<Joystick> rightStick = variable(() -> new Joystick(
            gamepad.get().right_stick_x,
            gamepad.get().right_stick_y,
            gamepad.get().right_stick_button
    ));

    public final Variable<Touchpad> touchpadFinger1 = variable(() -> new Touchpad(
            gamepad.get().touchpad_finger_1_x,
            gamepad.get().touchpad_finger_1_y,
            gamepad.get().touchpad_finger_1
    ));

    public final Variable<Touchpad> touchpadFinger2 = variable(() -> new Touchpad(
            gamepad.get().touchpad_finger_2_x,
            gamepad.get().touchpad_finger_2_y,
            gamepad.get().touchpad_finger_2
    ));

    /**
     * Represents a joystick. and also a touchpad. yeah.
     */
    public static class Joystick {
        Joystick(double x, double y, boolean pressed) {
            this.x = x;
            this.y = y;
            this.pressed = pressed;
        }
        double x;
        double y;
        boolean pressed;
    }

    /**
     * literally only so that {@code touchpadFinger1} isn't {@code Variable<Joystick>} lmaoooo
     */
    public static class Touchpad extends Joystick {
        Touchpad(double x, double y, boolean pressed) {
            super(x, y, pressed);
        }
    }
}
