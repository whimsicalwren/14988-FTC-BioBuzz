package org.firstinspires.ftc.teamcode.internal.util;

import static dev.nextftc.hardware.actuators.NextMotor.Direction;

import com.bylazar.configurables.annotations.Configurable;

import java.util.function.Supplier;

/**
 * i guess we doin subsystems now
 */
@Configurable
public class Config {

    public static Direction flDirection = Direction.FORWARD;
    public static Direction frDirection = Direction.REVERSE;
    public static Direction blDirection = Direction.FORWARD;
    public static Direction brDirection = Direction.REVERSE;

    public static double driveY = 1;
    public static double driveX = 1;
    public static double driveR = 1;
    public static double slowmode = 0.4;

    public static int flPort = 0;
    public static int frPort = 0;
    public static int blPort = 2;
    public static int brPort = 2;

    public static Supplier<Double> driveYModifier = () -> driveY * Values.slowmodeValue;
    public static Supplier<Double> driveXModifier = () -> driveX * Values.slowmodeValue;
    public static Supplier<Double> driveRModifier = () -> driveR * Values.slowmodeValue;

    public static void setSlowmodeModifier(double set) {
        Values.slowmodeValue = set;
    }

    private static class Values {
        public static double slowmodeValue = 1;
    }

}
