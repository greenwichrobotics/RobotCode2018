package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6484.robot.OI;

/**
 *
 */
public class SweepMotorCommand extends Command {

	public Boolean sweepIn = false;
	private Boolean toggleX = true;
	private Boolean toggleY = true;
    public SweepMotorCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.SweepMotorSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(toggleY && OI.pilotController.isYButtonPressed())
    	{
   			Robot.SweepMotorSub.openSweep();
   			toggleY = false;
   			toggleX = true;
    	}
    	else if(toggleX && OI.pilotController.isXButtonPressed())
    	{
    		Robot.SweepMotorSub.closeSweep();
    		toggleX = false;
    		toggleY = true;
    	}
    	
//    	else if (!OI.pilotController.isYButtonPressed()){
//		toggleY = false;
//	}
    
//    	if(OI.copilotController.getTriggerValue() > 0)
//    		Robot.SweepMotorSub.pullCube();
//    	else if(OI.copilotController.getTriggerValue() < 0)
//    		Robot.SweepMotorSub.pushCube();
//    	else
//    		Robot.SweepMotorSub.stopMotors();
//    	
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
