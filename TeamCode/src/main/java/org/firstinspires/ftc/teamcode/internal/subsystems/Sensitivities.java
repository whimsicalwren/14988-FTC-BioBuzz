package org.firstinspires.ftc.teamcode.internal.subsystems;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

import static dev.nextftc.hardware.actuators.NextMotor.Direction;
import static org.firstinspires.ftc.teamcode.internal.subsystems.RobotConfig.INSTANCE;

import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.configurables.annotations.IgnoreConfigurable;

/**
 * i guess we doin subsystems now
 */
@Configurable
public class Sensitivities implements RRSubsystem {

    public static Direction flDirection = Direction.FORWARD;
    public static Direction frDirection = Direction.REVERSE;
    public static Direction blDirection = Direction.FORWARD;
    public static Direction brDirection = Direction.REVERSE;

    public static double driveY = 1;
    public static double driveX = 1;
    public static double driveYaw = 1;
    public static double slowmode = 0.4;

    @IgnoreConfigurable
    public static double slowmodeValue = 1;
    @Override
    public void postInit() {
        INSTANCE.flDrive.setDirection(flDirection);
        INSTANCE.frDrive.setDirection(frDirection);
        INSTANCE.blDrive.setDirection(blDirection);
        INSTANCE.brDrive.setDirection(brDirection);
    }
}
