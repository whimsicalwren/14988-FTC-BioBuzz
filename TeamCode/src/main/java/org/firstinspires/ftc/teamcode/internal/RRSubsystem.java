package org.firstinspires.ftc.teamcode.internal;

import com.pedropathing.ivy.Scheduler;

import org.firstinspires.ftc.teamcode.internal.util.TelemetryHelper;

/**
 * take a wild fucking guess. that's right. it's a subsystem. good job you get a gold star
 */
@SuppressWarnings({"JavadocReference", "unused"}) // for referencing private methods in the javadocs
public interface RRSubsystem {

    // region init
    /**
     * Runs before {@link RROpMode#_init()}, if code needs to be run there.
     */
    default void preInit() {}

    /**
     * Normal initialization method called by {@link RROpMode#_init()} When this is run, it should be safe to grab values from {@link Manager}
     */
    default void onInit() {}

    /**
     * Runs after {@link RROpMode#_init()}, if code needs to be run there.
     */
    default void postInit() {}
    // endregion

    // region waitForStart
    /**
     * Runs before {@link RROpMode#_waitForStart()}, if code needs to be run there.
     */
    default void preWaitForStart() {}

    /**
     * Called by {@link RROpMode#_waitForStart()}
     */
    default void onWaitForStart() {}

    /**
     * Runs after {@link RROpMode#_waitForStart()}, if code needs to be run there.
     */
    default void postWaitForStart() {}
    // endregion

    // region startButtonPressed
    /**
     * Runs before {@link RROpMode#_startButtonPressed()}, if code needs to be run there.
     */
    default void preStartButtonPressed() {}

    /**
     * Called by {@link RROpMode#_startButtonPressed()}
     */
    default void onStartButtonPressed() {}

    /**
     * Runs before {@link RROpMode#_startButtonPressed()}, if code needs to be run there.
     */
    default void postStartButtonPressed() {}
    // endregion

    // region update
    /**
     * Runs before {@link RROpMode#_update()}. Commands should be added to the {@link Scheduler} HERE,
     * as we call {@link Scheduler#execute()} before {@link RRSubsystem#onUpdate()}
     */
    default void preUpdate() {}

    /**
     * Basic updating method, called by {@link RROpMode#_update()}
     */
    default void onUpdate() {}

    /**
     * Runs after {@link RROpMode#_update()}, if code needs to be run then
     */
    default void postUpdate() {}
    // endregion

    // region stop
    /**
     * Runs before {@link RROpMode#_stop()}, if code needs to be run there.
     */
    default void preStop() {}

    /**
     * Called by {@link RROpMode#_stop()}
     */
    default void onStop() {}

    /**
     * Runs after {@link RROpMode#_stop()}, if code needs to be run there.
     */
    default void postStop() {}
    // endregion

    /**
     * This method is called after all three update methods, to preserve deltatime accuracy
     */
    default void addTelemetry(TelemetryHelper telemetry) {}
}
