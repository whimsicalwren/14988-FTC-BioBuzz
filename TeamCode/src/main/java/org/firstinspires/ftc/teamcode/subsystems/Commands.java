package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.internal.RRobotKt;
import org.firstinspires.ftc.teamcode.internal.RRobot;
import org.firstinspires.ftc.teamcode.internal.util.Config;

public enum Commands implements Runnable {
    SLOWMODE_ON(Command.build().setExecute(() -> Config.setSlowmodeModifier(Config.slowmode))),
    SLOWMODE_OFF(Command.build().setExecute(() -> Config.setSlowmodeModifier(1.0))),
    DRIVE(Command.build()
            .setExecute(() -> {
                double y = RRobotKt.gamepad1().leftStickY.get() * Config.driveYModifier.get();
                double x = RRobotKt.gamepad1().leftStickX.get() * Config.driveXModifier.get();
                double r = RRobotKt.gamepad1().rightStickX.get() * Config.driveRModifier.get();

                double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(r), 1.0);

                RRobot.INSTANCE.flDrive.setThrottle((y + x + r) / denominator);
                RRobot.INSTANCE.frDrive.setThrottle((y - x - r) / denominator);
                RRobot.INSTANCE.blDrive.setThrottle((y - x + r) / denominator);
                RRobot.INSTANCE.brDrive.setThrottle((y + x - r) / denominator);
            }))
    ;

    private final Command command;

    Commands(Command command) { this.command = command; }

    @Override
    public void run() { command.schedule(); }
}
