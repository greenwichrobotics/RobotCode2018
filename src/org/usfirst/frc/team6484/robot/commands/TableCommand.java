package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6484.robot.OI;

/**
 *
 */
public class TableCommand extends Command {	
	private boolean tablePush = false;
	private boolean toggleLB = true;
    public TableCommand() {
        requires(Robot.TableSub);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(toggleLB && OI.pilotController.isLBButtonPressed())
    	{
    		toggleLB = false;
    		if(tablePush == true)
    		{
    			tablePush = false;
    			Robot.TableSub.pushTable();
    		}
    		else if (tablePush == false)
    		{
    			tablePush = true;
    			Robot.TableSub.pullTable();
    		}
    	}
    	else if(!OI.pilotController.isLBButtonPressed())
    		toggleLB = true;
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
