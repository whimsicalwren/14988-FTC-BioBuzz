package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.internal.RRobotKt;
import org.firstinspires.ftc.teamcode.internal.RRSubsystem;

public class BasicMecanumDrive implements RRSubsystem {

    public static BasicMecanumDrive INSTANCE;
    public BasicMecanumDrive() { INSTANCE = this; }

    @Override
    public void onInit() {
        RRobotKt.gamepad1().leftTrigger.greaterThan(0.3).whenBecomesTrue(Commands.SLOWMODE_ON);
        RRobotKt.gamepad1().leftTrigger.greaterThan(0.3).whenBecomesFalse(Commands.SLOWMODE_OFF);
    }

    @Override
    public void preUpdate() {
        Commands.DRIVE.run();
    }
}
