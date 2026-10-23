package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.internal.RROpMode;
import org.firstinspires.ftc.teamcode.internal.util.OpModeGroup;
import org.firstinspires.ftc.teamcode.subsystems.BasicMecanumDrive;

@TeleOp(group = OpModeGroup.normal, name = "basic bitch opmode")
public class BasicMecanumOpMode extends RROpMode {

    public BasicMecanumOpMode() {
        addSubsystems(new BasicMecanumDrive());
    }

}
