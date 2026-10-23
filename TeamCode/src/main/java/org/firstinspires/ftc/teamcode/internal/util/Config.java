package org.firstinspires.ftc.teamcode.internal.util;

import static dev.nextftc.hardware.actuators.NextMotor.Direction;

import com.bylazar.configurables.annotations.Configurable;

import java.util.function.Supplier;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.lynx.NextLynxModule;

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

    public static int flPort = 2;
    public static int frPort = 1;
    public static int blPort = 3;
    public static int brPort = 0;
    public static Hub flHub = Hub.CONTROL;
    public static Hub frHub = Hub.CONTROL;
    public static Hub blHub = Hub.CONTROL;
    public static Hub brHub = Hub.CONTROL;

    public static Supplier<Double> driveYModifier = () -> driveY * Values.slowmodeValue;
    public static Supplier<Double> driveXModifier = () -> driveX * Values.slowmodeValue;
    public static Supplier<Double> driveRModifier = () -> driveR * Values.slowmodeValue;

    public static void setSlowmodeModifier(double set) {
        Values.slowmodeValue = set;
    }

    private static class Values {
        public static double slowmodeValue = 1;
    }

    public enum Hub {
        CONTROL(RobotController::controlHub),
        EXPANSION(RobotController::expansionHub);

        private final Supplier<NextLynxModule> hubSupplier;

        public NextLynxModule get() {
            return hubSupplier.get();
        }

        Hub(Supplier<NextLynxModule> hubSupplier) {
            this.hubSupplier = hubSupplier;
        }
    }

}
