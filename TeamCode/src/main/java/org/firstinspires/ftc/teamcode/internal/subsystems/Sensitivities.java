package org.firstinspires.ftc.teamcode.internal.subsystems;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

import static dev.nextftc.hardware.actuators.NextMotor.Direction;
import static org.firstinspires.ftc.teamcode.internal.subsystems.RobotConfig.INSTANCE;

public class Sensitivities implements RRSubsystem {

    public static Direction
        flDirection = Direction.FORWARD,
        frDirection = Direction.REVERSE,
        blDirection = Direction.FORWARD,
        brDirection = Direction.REVERSE;

    public static double
        driveY = 1,
        driveX = 1,
        driveYaw = 1,
        slowmode = 0.4;

    @Override
    public void postInit() {
        INSTANCE.flDrive.setDirection(flDirection);
        INSTANCE.frDrive.setDirection(frDirection);
        INSTANCE.blDrive.setDirection(blDirection);
        INSTANCE.brDrive.setDirection(brDirection);
    }
}
