package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

 /*
 */
public class ClampCommand extends Command {
private boolean clampIn = false;
private boolean toggleB = true;
    public ClampCommand() {
    	requires(Robot.ClampSub);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.ClampSub.clampOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(toggleB && OI.copilotController.isBButtonPressed()) {
    		toggleB = false;
    		if(clampIn == true)
    		{
    			clampIn = false;
    			Robot.ClampSub.clampOff();
    		}
    		else if(clampIn == false)
    		{
    			clampIn = true;
    			Robot.ClampSub.clampOn();
    		}
    	}else if (!OI.copilotController.isBButtonPressed()){
    		toggleB = true;
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
