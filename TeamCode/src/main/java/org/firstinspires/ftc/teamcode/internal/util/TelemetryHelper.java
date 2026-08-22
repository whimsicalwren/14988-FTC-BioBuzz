package org.firstinspires.ftc.teamcode.internal.util;

import com.bylazar.telemetry.TelemetryManager;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Utility class for telemetry.
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
public class TelemetryHelper {

    private final LinkedList<String> lines;

    public TelemetryHelper() {
        lines = new LinkedList<>();
    }

    public TelemetryHelper line(@NotNull String line) {
        lines.add(line);
        return this;
    }

    public TelemetryHelper formattedLine(@NotNull String line, Object... args) {
        lines.add(String.format(line, Arrays.stream(args).map(value -> value == null ? "NULL" : value)));
        return this;
    }

    public TelemetryHelper data(@NotNull String line, Object data) {
        lines.add(line + ": " + (data == null ? "NULL" : data));
        return this;
    }

    public void output(TelemetryManager telemetryManager, Telemetry telemetry) {
        telemetryManager.setLines(lines);
        telemetryManager.update(telemetry);
        lines.clear();
    }

}
