package org.firstinspires.ftc.teamcode.internal;

import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerNotifier;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.internal.util.DeltaTimer;
import org.firstinspires.ftc.teamcode.internal.util.TelemetryHelper;

import java.util.function.Function;

/**
 * Utility class to grab values like gamepads, config, and telemetry where needed.
 */
public final class Manager implements OpModeManagerNotifier.Notifications {

    private Manager() {}

    private static <T> T opMode(Function<RROpMode, T> opModeFunc) {
        if (runningOpMode == null) {
            throw new IllegalStateException("No RROpMode set!");
        }

        return opModeFunc.apply(runningOpMode);
    }

    public static RROpMode runningOpMode = null;
    public static RobotConfig config = opMode(rrOpMode -> rrOpMode.config);
    public static TelemetryHelper telemetry = opMode(rrOpMode -> rrOpMode.helper);
    public static RRGamepad p1 = opMode(rrOpMode -> rrOpMode.p1);
    public static RRGamepad p2 = opMode(rrOpMode -> rrOpMode.p2);
    public static HardwareMap hardwareMap = opMode(rrOpMode -> rrOpMode.hardwareMap);
    public static DeltaTimer deltaTimer = opMode(rrOpMode -> rrOpMode.deltaTimer);

    @Override
    public void onOpModePreInit(OpMode opMode) {
        try {
            runningOpMode = (RROpMode) opMode;
        } catch (ClassCastException ignored) {
        }
    }

    @Override
    public void onOpModePreStart(OpMode opMode) {

    }

    @Override
    public void onOpModePostStop(OpMode opMode) {

    }
}
