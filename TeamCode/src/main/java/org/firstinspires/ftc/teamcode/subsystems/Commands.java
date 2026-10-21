package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.internal.Manager;
import org.firstinspires.ftc.teamcode.internal.subsystems.RobotConfig;
import org.firstinspires.ftc.teamcode.internal.subsystems.Sensitivities;

import dev.nextftc.bindings.Button;

public enum Commands implements Runnable {
    SLOWMODE_ON(Command.build().setExecute(() -> Sensitivities.slowmodeValue = Sensitivities.slowmode)),
    SLOWMODE_OFF(Command.build().setExecute(() -> Sensitivities.slowmodeValue = 1.0)),
    DRIVE(Command.build()
            .setExecute(() -> {
                double x = Manager.p1.leftStickX.get() * Sensitivities.driveX * Sensitivities.slowmodeValue;
                double y = Manager.p1.leftStickY.get() * Sensitivities.driveY * Sensitivities.slowmodeValue;
                double r = Manager.p1.rightStickX.get() * Sensitivities.driveYaw * Sensitivities.slowmodeValue;

                double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(r), 1.0);

                RobotConfig.INSTANCE.flDrive.setThrottle((y + x + r) / denominator);
                RobotConfig.INSTANCE.frDrive.setThrottle((y - x - r) / denominator);
                RobotConfig.INSTANCE.blDrive.setThrottle((y - x + r) / denominator);
                RobotConfig.INSTANCE.brDrive.setThrottle((y + x - r) / denominator);
            }))
    ;

    private final Command command;

    Commands(Command command) {
        this.command = command;
    }

    @Override
    public void run() {
        command.schedule();
    }

    public void bind(Button button) {
        button.whenBecomesTrue(this);
    }
}
