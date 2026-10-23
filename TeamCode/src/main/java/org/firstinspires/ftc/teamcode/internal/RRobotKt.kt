package org.firstinspires.ftc.teamcode.internal

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerNotifier
import org.firstinspires.ftc.teamcode.internal.util.DeltaTimer
import org.firstinspires.ftc.teamcode.internal.util.TelemetryHelper

@Suppress("unused")
object RRobotKt : OpModeManagerNotifier.Notifications {

    private fun <T> fromOpMode(func: RROpMode.() -> T): T =
        runningOpMode?.func() ?: error("RROpMode not initialized!")

    @JvmField
    var runningOpMode: RROpMode? = null

    @JvmStatic
    @get:JvmName("gamepad1")
    val gamepad1: RRGamepad get() = fromOpMode { p1 }

    @JvmStatic
    @get:JvmName("gamepad2")
    val gamepad2: RRGamepad get() = fromOpMode { p2 }

    @JvmStatic
    @get:JvmName("telemetry")
    val telemetry: TelemetryHelper get() = fromOpMode { helper }

    @JvmStatic
    @get:JvmName("deltaTimer")
    val deltaTimer: DeltaTimer get() = fromOpMode { deltaTimer }

    override fun onOpModePreInit(opMode: OpMode?) {
        if (opMode == null || opMode !is RROpMode) return
        runningOpMode = opMode
    }

    override fun onOpModePreStart(opMode: OpMode?) {}
    override fun onOpModePostStop(opMode: OpMode?) {}
}