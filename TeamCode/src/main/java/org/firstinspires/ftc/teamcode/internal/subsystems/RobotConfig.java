package org.firstinspires.ftc.teamcode.internal.subsystems;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

/**
 * the one the only robot config.
 * goddamn this file changes every year
 */
public class RobotConfig implements RRSubsystem { // yes very subsystem

    public static RobotConfig INSTANCE;

    public static RobotConfig getOrNew() {
        if (INSTANCE == null) INSTANCE = new RobotConfig();
        return INSTANCE;
    }

    public NextMotor flDrive, frDrive, blDrive, brDrive;

    @Override
    public void preInit() {
        flDrive = new NextMotor(RobotController.controlHub(), 0);
        frDrive = new NextMotor(RobotController.expansionHub(), 0);
        blDrive = new NextMotor(RobotController.controlHub(), 2);
        brDrive = new NextMotor(RobotController.expansionHub(), 2);
    }

    @Override
    public void postStop() {
        INSTANCE = null;
    }
}
