package org.usfirst.frc.team6484.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6484.robot.Robot;
import org.usfirst.frc.team6484.robot.subsystems.UltrasonicSubSystem;


/**
 *
 */
public class DriveForward extends Command {

	private double Kp;
	private double forwardAngle;
	Timer timer;
    public DriveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveTrainSub);
    	requires(Robot.Gyro);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Kp = 0.03;
    	forwardAngle = Robot.Gyro.getAngle();
    	timer = new Timer();
    	timer.start();
    	Robot.ClampSub.clampOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Distance", UltrasonicSubSystem.getDistance());
 	
    	
    	if(UltrasonicSubSystem.getDistance() <0.3)
    		Robot.DriveTrainSub.stop();
    	else {
    	double angle = forwardAngle - Robot.Gyro.getAngle();
    	if (timer.get() < 8.0)
    		Robot.DriveTrainSub.curvatureDrive(-0.3, angle * Kp, false); // drive towards heading 0
    	else
    		Robot.DriveTrainSub.stop();
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
