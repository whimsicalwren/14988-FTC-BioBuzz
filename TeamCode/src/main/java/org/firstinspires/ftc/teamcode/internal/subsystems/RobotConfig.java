package org.firstinspires.ftc.teamcode.internal.subsystems;

import com.bylazar.configurables.annotations.Configurable;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

import static dev.nextftc.hardware.actuators.NextMotor.Direction;

/**
 * the one the only robot config.
 * goddamn this file changes every year
 *
 * that's right. it's a subsystem now.
 */
@Configurable
public class RobotConfig implements RRSubsystem { // yes very subsystem
    public static Direction flDirection = Direction.FORWARD;
    public static Direction frDirection = Direction.REVERSE;
    public static Direction blDirection = Direction.FORWARD;
    public static Direction brDirection = Direction.REVERSE;


    public static double driveY = 1;
    public static double driveX = 1;
    public static double driveYaw = 1;
    public static double slowmode = 0.4;


    public static int
            flPort = 0,
            frPort = 0,
            blPort = 2,
            brPort = 2;

    public NextMotor flDrive, frDrive, blDrive, brDrive;

    @Override
    public void preInit() {
        flDrive = new NextMotor(RobotController.controlHub(), flPort);
        frDrive = new NextMotor(RobotController.expansionHub(), frPort);
        blDrive = new NextMotor(RobotController.controlHub(), blPort);
        brDrive = new NextMotor(RobotController.expansionHub(), brPort);
    }

    @Override
    public void postInit() {
        flDrive.setDirection(flDirection);
        frDrive.setDirection(frDirection);
        blDrive.setDirection(blDirection);
        brDrive.setDirection(brDirection);
    }

    @Override
    public void postStop() {
        INSTANCE = null;
    }

    public static RobotConfig INSTANCE;
    public RobotConfig() { INSTANCE = this; }
}
