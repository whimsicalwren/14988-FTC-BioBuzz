package org.firstinspires.ftc.teamcode.internal;

import org.firstinspires.ftc.teamcode.internal.util.Config;

import dev.nextftc.hardware.actuators.NextMotor;

/**
 * the one the only robot config.
 * goddamn this file changes every year
 * that's right. it's a subsystem now.
 */
public class RRobot implements RRSubsystem { // yes very subsystem

    public NextMotor flDrive, frDrive, blDrive, brDrive;

    @Override
    public void preInit() {
        flDrive = new NextMotor(Config.flHub.get(), Config.flPort);
        frDrive = new NextMotor(Config.frHub.get(), Config.frPort);
        blDrive = new NextMotor(Config.blHub.get(), Config.blPort);
        brDrive = new NextMotor(Config.brHub.get(), Config.brPort);
    }

    @Override
    public void postInit() {
        flDrive.setDirection(Config.flDirection);
        frDrive.setDirection(Config.frDirection);
        blDrive.setDirection(Config.blDirection);
        brDrive.setDirection(Config.brDirection);
    }

    @Override
    public void postStop() {
        INSTANCE = null;
    }

    public static RRobot INSTANCE;
    RRobot() { INSTANCE = this; }
}
