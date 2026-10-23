package org.firstinspires.ftc.teamcode.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerNotifier;

import org.firstinspires.ftc.teamcode.internal.util.Config;
import org.firstinspires.ftc.teamcode.internal.util.DeltaTimer;
import org.firstinspires.ftc.teamcode.internal.util.TelemetryHelper;

import java.util.function.Function;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;

/**
 * the one the only robot config.
 * goddamn this file changes every year
 * that's right. it's a subsystem now.
 */
public class RRobot implements RRSubsystem, OpModeManagerNotifier.Notifications { // yes very subsystem

    public NextMotor flDrive, frDrive, blDrive, brDrive;

    @Override
    public void preInit() {
        flDrive = new NextMotor(RobotController.controlHub(), Config.flPort);
        frDrive = new NextMotor(RobotController.expansionHub(), Config.frPort);
        blDrive = new NextMotor(RobotController.controlHub(), Config.blPort);
        brDrive = new NextMotor(RobotController.expansionHub(), Config.brPort);
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

    public static RROpMode runningOpMode = null;
    public static TelemetryHelper telemetry = opMode(rrOpMode -> rrOpMode.helper);
    public static RRGamepad gamepad1 = opMode(rrOpMode -> rrOpMode.p1);
    public static RRGamepad gamepad2 = opMode(rrOpMode -> rrOpMode.p2);
    public static DeltaTimer deltaTimer = opMode(rrOpMode -> rrOpMode.deltaTimer);

    private static <T> T opMode(Function<RROpMode, T> opModeFunc) {
        if (runningOpMode == null) {
            throw new IllegalStateException("No RROpMode set!");
        }

        return opModeFunc.apply(runningOpMode);
    }

    @Override
    public void onOpModePreInit(OpMode opMode) {
        try {
            runningOpMode = (RROpMode) opMode;
        } catch (ClassCastException ignored) {}
    }

    @Override public void onOpModePreStart(OpMode opMode) {}
    @Override public void onOpModePostStop(OpMode opMode) {}
}
