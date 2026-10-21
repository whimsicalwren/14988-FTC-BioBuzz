package org.firstinspires.ftc.teamcode.internal.subsystems;

import com.bylazar.configurables.annotations.Configurable;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

/**
 * the one the only robot config.
 * goddamn this file changes every year
 *
 * that's right. it's a subsystem now.
 */
@Configurable
public class RobotConfig implements RRSubsystem { // yes very subsystem

    public static RobotConfig INSTANCE;

    public static RobotConfig getOrNew() {
        if (INSTANCE == null) INSTANCE = new RobotConfig();
        return INSTANCE;
    }

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
    public void postStop() {
        INSTANCE = null;
    }
}
