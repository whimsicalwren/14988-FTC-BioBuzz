package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.internal.RRSubsystem;
import org.firstinspires.ftc.teamcode.internal.subsystems.RobotConfig;
import org.firstinspires.ftc.teamcode.internal.subsystems.Sensitivities;

public class BasicMecanumDrive implements RRSubsystem {

    public static BasicMecanumDrive INSTANCE;

    public BasicMecanumDrive() {
        INSTANCE = this;
    }

    private Command driveCommand;
    private double slowmode = 1;

    @Override
    public void onInit() {
        gamepad1().leftTrigger.greaterThan(0.3).whenBecomesTrue(() -> slowmode = Sensitivities.slowmode);
        gamepad1().leftTrigger.greaterThan(0.3).whenBecomesFalse(() -> slowmode = 1);

        driveCommand = Command.build()
                .setExecute(() -> {
                    double x = gamepad1().leftStickX.get() * Sensitivities.driveX;
                    double y = gamepad1().leftStickY.get() * Sensitivities.driveY;
                    double r = gamepad1().rightStickX.get() * Sensitivities.driveYaw;

                    double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(r), 1.0);

                    RobotConfig.INSTANCE.flDrive.setThrottle(((y + x + r) / denominator) * slowmode);
                    RobotConfig.INSTANCE.frDrive.setThrottle(((y - x - r) / denominator) * slowmode);
                    RobotConfig.INSTANCE.blDrive.setThrottle(((y - x + r) / denominator) * slowmode);
                    RobotConfig.INSTANCE.brDrive.setThrottle(((y + x - r) / denominator) * slowmode);
                });
    }

    @Override
    public void preUpdate() {
        driveCommand.schedule();
    }
}
