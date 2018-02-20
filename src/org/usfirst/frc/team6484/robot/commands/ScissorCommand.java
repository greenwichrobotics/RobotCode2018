package org.usfirst.frc.team6484.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.Robot;

public class ScissorCommand extends Command {
boolean scissorUp = false; 
boolean rbToggle = true;
    public ScissorCommand() {
    	requires(Robot.ScissorSub);
    	requires(Robot.WinchSub);
    }

    // Called just before this Command runs the first time*9
    protected void initialize() {
    	SmartDashboard.putNumber("WinchEncoder", 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (rbToggle && OI.pilotController.isRBButtonPressed()) {
    		rbToggle = false;
    		if(scissorUp == false)
    		{
    			scissorUp = true;
    			Robot.ScissorSub.ScissorUp();
       			Robot.WinchSub.winchUp(); 
    		}
    		else if(scissorUp == true) 
    		{
    			scissorUp = false;
    			Robot.ScissorSub.ScissorDown();
    			Robot.WinchSub.winchDown();
    		}
    	}
    	else if(!OI.pilotController.isRBButtonPressed()) {
    		rbToggle = true;}
    	
    	if(Robot.ScissorSub.getBottonSwitch() && !scissorUp)
    	{
    		Robot.WinchSub.winchStop();
    	}
    	SmartDashboard.putNumber("WinchEncoder", Robot.WinchSub.getEncoder());
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
