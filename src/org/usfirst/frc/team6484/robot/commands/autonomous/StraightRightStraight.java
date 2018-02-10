package org.usfirst.frc.team6484.robot.commands.autonomous;

import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StraightRightStraight extends Command {
	private double Kp;
	private double forwardAngle;
	Timer timer;
    public StraightRightStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Gyro);
    	requires(Robot.DriveTrainSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Kp = 0.03;
    	forwardAngle = Robot.Gyro.getAngle();
    	timer = new Timer();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = forwardAngle - Robot.Gyro.getAngle();
    	double currentTime =  timer.get();
    	if (currentTime < 5.0)
    		Robot.DriveTrainSub.curvatureDrive(-0.3, angle * Kp, false); // drive towards heading 0
    	else if(currentTime <= 5.0 && currentTime < 7.0){
    		Robot.DriveTrainSub.curvatureDrive(0.0, 30 * Kp, true);
    	
    	}else if(currentTime <= 7.0 && currentTime < 10.0){
    		Robot.DriveTrainSub.curvatureDrive(-0.3, (angle + 30) * Kp, false);
    	}else
    		Robot.DriveTrainSub.stop();
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
