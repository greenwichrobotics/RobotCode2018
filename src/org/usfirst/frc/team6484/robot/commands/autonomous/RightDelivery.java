package org.usfirst.frc.team6484.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6484.robot.Robot;
import org.usfirst.frc.team6484.robot.subsystems.UltrasonicSubSystem;

/**
 *
 */
public class RightDelivery extends Command {

	private double Kp;
	private double forwardAngle;
	private boolean isClamped = false;
	private boolean isScissorUp = false;
	private boolean isTableOut = false;
	Timer timer;
	private double speed = -0.1;

	public RightDelivery() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.DriveTrainSub);
		requires(Robot.Gyro);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Kp = 0.03;
		forwardAngle = Robot.Gyro.getAngle();
		speed = SmartDashboard.getNumber("Speed", -0.1);		
		timer = new Timer();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'R') {
				SmartDashboard.putNumber("Distance", UltrasonicSubSystem.getDistance());
				// Move Arm down
				// Clamp Box
				if (!isClamped) {
					isClamped = true;
					Robot.ClampSub.clampOn();
				} else if (isClamped && timer.get() > 2.0 && !isScissorUp) {
					isScissorUp = true;
					Robot.ScissorSub.ScissorUp();
				} else if (isScissorUp && timer.get() > 8.0) {
					double angle = forwardAngle - Robot.Gyro.getAngle();
					if (UltrasonicSubSystem.getDistance() < 0.3) {
						Robot.DriveTrainSub.stop();
						Robot.ClampSub.clampOff();
					} else {
						if (timer.get() < 15.0)
							Robot.DriveTrainSub.curvatureDrive(speed, angle * Kp, false); // drive towards heading 0
						else
							Robot.DriveTrainSub.stop();
					}
				}
			}
			else {
		    	if(UltrasonicSubSystem.getDistance() <0.3)
		    		Robot.DriveTrainSub.stop();
		    	else {
		    	double angle = forwardAngle - Robot.Gyro.getAngle();
		    	if (timer.get() < 8.0)
		    		Robot.DriveTrainSub.curvatureDrive(speed, angle * Kp, false); // drive towards heading 0
		    	else
		    		Robot.DriveTrainSub.stop();
		    	}				
			}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
