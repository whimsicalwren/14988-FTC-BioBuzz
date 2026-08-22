package org.firstinspires.ftc.teamcode.internal;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.pedropathing.ivy.Scheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.internal.util.DeltaTimer;
import org.firstinspires.ftc.teamcode.internal.util.TelemetryHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import dev.nextftc.bindings.BindingManager;

/**
 * Base opmode for our evil and nefarious purposes
 */
public abstract class RROpMode extends LinearOpMode {

    private final Set<RRSubsystem> subsystems = new HashSet<>();

    protected final void addSubsystems(RRSubsystem... subsystems) {
        this.subsystems.addAll(Arrays.asList(subsystems));
    }

    RobotConfig config;
    final TelemetryManager telemetryManager = PanelsTelemetry.INSTANCE.getTelemetry();
    final RRGamepad p1 = new RRGamepad(() -> gamepad1);
    final RRGamepad p2 = new RRGamepad(() -> gamepad2);
    final DeltaTimer deltaTimer = new DeltaTimer();
    final TelemetryHelper helper = new TelemetryHelper();

    @Override
    public final void runOpMode() {
        try {
            subsystems.forEach(RRSubsystem::preInit);
            _init();
            subsystems.forEach(RRSubsystem::postInit);

            while (opModeInInit()) {
                subsystems.forEach(RRSubsystem::preWaitForStart);
                _waitForStart();
                subsystems.forEach(RRSubsystem::postWaitForStart);
            }

            if (!isStopRequested()) {
                subsystems.forEach(RRSubsystem::preStartButtonPressed);
                _startButtonPressed();
                subsystems.forEach(RRSubsystem::postStartButtonPressed);

                while (opModeIsActive()) {
                    deltaTimer.reset();

                    subsystems.forEach(RRSubsystem::preUpdate);
                    _update();
                    subsystems.forEach(RRSubsystem::postUpdate);

                    helper.formattedLine("delta: %s ms", TimeUnit.MILLISECONDS.convert(deltaTimer.get(), TimeUnit.NANOSECONDS));
                    subsystems.forEach(ss -> ss.addTelemetry(helper));
                    helper.output(telemetryManager, telemetry);
                }
            }

            subsystems.forEach(RRSubsystem::preStop);
            _stop();
            subsystems.forEach(RRSubsystem::postStop);
        } catch (Exception e) {
            RuntimeException re = new RuntimeException(e.getMessage());
            re.setStackTrace(e.getStackTrace());
            throw re;
        }
    }

    // region internal methods
    private void _init() {
        config = new RobotConfig(hardwareMap);
        subsystems.forEach(RRSubsystem::onInit);
        onInit();
    }

    private void _waitForStart() {
        subsystems.forEach(RRSubsystem::onWaitForStart);
        onWaitForStart();
    }

    private void _startButtonPressed() {
        subsystems.forEach(RRSubsystem::onStartButtonPressed);
        onStartButtonPressed();
    }

    private void _update() {
        BindingManager.update();
        subsystems.forEach(RRSubsystem::onUpdate);
        onUpdate();
    }

    private void _stop() {
        BindingManager.reset();
        Scheduler.reset();
        subsystems.forEach(RRSubsystem::onStop);
        onStop();
    }
    // endregion

    // these methods are for subclasses to override, so we keep internal stuff
    // region subclass methods
    protected void onInit() {}
    protected void onWaitForStart() {}
    protected void onStartButtonPressed() {}
    protected void onUpdate() {}
    protected void onStop() {}
    // endregion
}