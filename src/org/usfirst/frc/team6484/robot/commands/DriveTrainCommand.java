package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.Robot;
import org.usfirst.frc.team6484.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainCommand extends Command {

    public DriveTrainCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveTrainSub);
       // requires(Robot.UltrasonicSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveTrainSub.arcadeDrive(-1*OI.pilotController.getTriggerValue(), OI.pilotController.getLeftStickX());
    	
//    	Scheduler.getVoltage();
//    	Scheduler.getDistance().run();
    	
//    	if(OI.pilotController.getLeftTrigger() > 0 && OI.pilotController.getRightTrigger() > 0)
//    		Robot.DriveTrainSub.arcadeDrive(0.0, 0.0);
//    	else if(OI.pilotController.getRightTrigger() > 0)
//    		Robot.DriveTrainSub.arcadeDrive(OI.pilotController.getRightTrigger(), OI.pilotController.getLeftStickX());
//    	else if(OI.pilotController.getLeftTrigger() > 0)
//    		Robot.DriveTrainSub.arcadeDrive(-1 * OI.pilotController.getLeftTrigger(), OI.pilotController.getLeftStickX());
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
