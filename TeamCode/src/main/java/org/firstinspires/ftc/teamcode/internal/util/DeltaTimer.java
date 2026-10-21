package org.firstinspires.ftc.teamcode.internal.util;

/**
 * utility class for tracking loop times.
 * if delta time is above 30 you should probably fix that instead of looking at the docs i've written for the fucking timer
 */
public class DeltaTimer {

    public long last;

    public DeltaTimer() {
        last = System.nanoTime();
    }

    public void reset() {
        last = System.nanoTime();
    }

    public Long get() {
        return System.nanoTime() - last;
    }
}
