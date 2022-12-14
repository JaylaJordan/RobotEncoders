package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.Constants;

import android.util.MalformedJsonException;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.StringJoiner;


@Autonomous(name = "red zone red terminal", group = "complex auto")
public class RedZoneRedTerminal extends LinearOpMode {

    @Override
    public void runOpMode() {
      //  Robot robot = new Robot(hardwareMap);

        RobotEncoded robotencoded = new RobotEncoded(hardwareMap);

        waitForStart();
        //if (isStopRequested()) return;

//        robotencoded.forward(3,800);
//
//        robotencoded.turnLeft(24, 800);
//
//        robotencoded.forward(24,800);
//
//        robotencoded.backward(19, 800);
//
//        robotencoded.turnRight(24, 800);
//
//        robotencoded.forward(24, 800);

        robotencoded.closeClaw();

        robotencoded.forward(24,800);

        robotencoded.strafeRight(12,800);

        robotencoded.forward(3,800);

        robotencoded.setSlidePosition(900, Constants.MJ);

        robotencoded.forward(3,800);
        robotencoded.closeClaw();
        sleep(4000); // wait until the arm stops shaking midair

        robotencoded.openClaw();
        sleep(1000);

        robotencoded.backward(5,800);

        robotencoded.setSlidePosition(900, Constants.GJ);

        robotencoded.strafeLeft(16,800);

        if (opModeIsActive()) {
            telemetry.addData("front right", robotencoded.frontRight.getPower());
            telemetry.addData("front left", robotencoded.frontLeft.getPower());
            telemetry.addData("back right", robotencoded.backRight.getPower());
            telemetry.addData("back left", robotencoded.backLeft.getPower());
            telemetry.update();
        }

    }
}

