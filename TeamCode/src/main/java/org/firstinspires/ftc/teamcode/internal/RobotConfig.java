package org.firstinspires.ftc.teamcode.internal;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

/**
 * the one the only robot config.
 * goddamn this file changes every year
 */
public class RobotConfig {

    public VoltageSensor voltageSensor;

    public RobotConfig(HardwareMap hardwareMap) {
        initHardware(hardwareMap);
    }

    private void initHardware(HardwareMap map) {

    }

    private <T> T get(HardwareMap map, DeviceLocation loc, Class<T> tClass) {
        return map.get(tClass, loc.name);
    }

    private enum DeviceLocation {
        CHUB_MOTOR_0("cm0")
        ;

        final String name;

        DeviceLocation(String name) {
            this.name = name;
        }
    }
}
