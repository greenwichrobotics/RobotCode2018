package org.usfirst.frc.team6484.robot.commands.autonomous;

import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CenterToLeft extends Command {
	private double Kp;
	private double forwardAngle;
	Timer timer;
	private double speed = -0.1;
    public CenterToLeft() {
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
    	speed = SmartDashboard.getNumber("Speed", -0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = forwardAngle - Robot.Gyro.getAngle();
    	double currentTime =  timer.get();
    	if (currentTime < 2.0)
    		Robot.DriveTrainSub.curvatureDrive(speed, angle * Kp, false); // drive towards heading 0
//    	else if(currentTime >= 2.0 && currentTime < 2.2){
//    		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle - 10) *  Kp, true);
//    	}else if(currentTime >= 2.2 && currentTime < 2.4){
//    		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle - 10) *  Kp, true);
//    	}else if(currentTime >= 2.4 && currentTime < 2.6){
//    		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle - 10) *  Kp, true);    	
//    	}else if(currentTime >= 2.6 && currentTime < 2.8){
//    		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle - 10) *  Kp, true);    	
//    	}else if(currentTime >= 2.8 && currentTime < 3.0){
//    		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle - 10) *  Kp, true);    	
      	else if(currentTime >= 2.0 && currentTime < 8.0){
    		Robot.DriveTrainSub.curvatureDrive(speed, (angle - 50) * Kp, false);
//      	}else if(currentTime >= 8.0 && currentTime < 8.2){
//        		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle + 10) *  Kp, true);
//        	}else if(currentTime >= 8.2 && currentTime < 8.4){
//        		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle + 10) *  Kp, true);
//        	}else if(currentTime >= 8.4 && currentTime < 8.6){
//        		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle + 10) *  Kp, true);    	
//        	}else if(currentTime >= 8.6 && currentTime < 8.8){
//        		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle + 10) *  Kp, true);    	
//        	}else if(currentTime >= 8.8 && currentTime < 9.0){
//        		Robot.DriveTrainSub.curvatureDrive(-0.0, (angle + 10) *  Kp, true);   
    	}else if(currentTime >= 8.0 && currentTime < 11.0 ) {
    		Robot.DriveTrainSub.curvatureDrive(speed, angle * Kp, false);
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
