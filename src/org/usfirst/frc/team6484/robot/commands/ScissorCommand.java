package org.usfirst.frc.team6484.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.Robot;

public class ScissorCommand extends Command {
boolean scissorUp = false;
    public ScissorCommand() {
    	requires(Robot.ScissorSub);
      
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (OI.pilotController.isRBButtonPressed())
    		if(scissorUp == false)
    		{
    			scissorUp = false;
    			Robot.ScissorSub.ScissorUp();
    		}
    		else if(scissorUp == true) 
    		{
    			scissorUp = true;
    			Robot.ScissorSub.ScissorDown();
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
