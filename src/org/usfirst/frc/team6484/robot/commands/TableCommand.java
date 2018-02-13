package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6484.robot.OI;

/**
 *
 */
public class TableCommand extends Command {
public boolean TablePush = false;
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
    	if(OI.pilotController.isLBButtonPressed())
    		if(TablePush == true)
    		{
    			TablePush = false;
    			Robot.TableSub.pushTable();
    		}
    		else if (TablePush == false)
    		{
    			TablePush = true;
    			Robot.TableSub.pullTable();
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
