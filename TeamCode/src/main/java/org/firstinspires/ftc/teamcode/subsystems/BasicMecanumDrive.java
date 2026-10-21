package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

public class BasicMecanumDrive implements RRSubsystem {

    public static BasicMecanumDrive INSTANCE;

    public BasicMecanumDrive() {
        INSTANCE = this;
    }

    @Override
    public void onInit() {
        Commands.SLOWMODE_ON.bind(gamepad1().leftTrigger.greaterThan(0.3));
        Commands.SLOWMODE_OFF.bind(gamepad1().leftTrigger.lessThan(0.3));
    }

    @Override
    public void preUpdate() {
        Commands.DRIVE.run();
    }
}
