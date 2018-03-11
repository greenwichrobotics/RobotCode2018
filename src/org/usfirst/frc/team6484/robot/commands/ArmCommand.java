package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmCommand extends Command {
public boolean lockIn;
public String currentPosition;
public String direction;
private boolean toggleX;
private boolean toggleY;
private boolean toggleA; 
private boolean toggleB;
private boolean toggleDown;
    public ArmCommand() {
       requires(Robot.ArmSub);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lockIn = false;
    	currentPosition = "Start";
    	direction = "";
    	toggleX = true;
    	toggleY = true;
    	toggleA = true;
    	toggleB = true;
    	toggleDown = true;
    	Robot.ArmSub.ratchetIn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Position", Robot.ArmSub.armLocation);
    	SmartDashboard.putBoolean("ArmPosition", Robot.ArmSub.getPositionSwitch());
    	SmartDashboard.putBoolean("DownToggle", toggleDown);
    	if(OI.copilotController.getRightTrigger() > 0) {
    		//if(OI.copilotController.getLeftStickY() > 0 && !Robot.ArmSub.getTopSwitch()) {
    		Robot.ArmSub.armUp(); 
    		direction = "up";
    	}
		else if (OI.copilotController.getLeftTrigger() > 0 && !Robot.ArmSub.getBottomSwitch() && toggleDown) {
			Robot.ArmSub.armUp();
			Timer.delay(.06);
    		Robot.ArmSub.armDown();
    		toggleDown = false;
    		direction = "down";
    	}else if(OI.copilotController.getLeftTrigger() > 0 && !Robot.ArmSub.getBottomSwitch()) {
    		Robot.ArmSub.armDown();	
    		direction = "down";
    	}
    	else {
    		Robot.ArmSub.armStop(); 
    		toggleDown = true;
    		}
//    	if(toggleX && OI.pilotController.isXButtonPressed())
//    	{
//    		Robot.ArmSub.ratchetIn();
//    		toggleX = false;
//    		toggleY = true;
//    	}
//    	if(toggleY && OI.pilotController.isYButtonPressed())
//    	{
//    		Robot.ArmSub.ratchetOut();
//    		toggleY = false;
//    		toggleX = true;
//    	}
    		
//    	if(OI.copilotController.isAButtonPressed()) {
//    		Robot.ArmSub.moveToBase();
////    		if(lockIn == true) {
////    		lockIn = false;
////    		Robot.ArmSub.lockOut();
////    	}
////    	else if(lockIn == false); {
////    		lockIn = true;
////    		Robot.ArmSub.lockIn();
////    	}
//    		
//      }else	if(OI.copilotController.isBButtonPressed()) {
//    		Robot.ArmSub.moveToStart();
//    	}else if(OI.copilotController.isYButtonPressed()) {
//    		Robot.ArmSub.moveToSwitch();
//    	}else if(OI.copilotController.isXButtonPressed()) {
//    		Robot.ArmSub.moveToClimb();
//    	}else {
//    		Robot.ArmSub.armStop();
//    	}
    	if(Robot.ArmSub.getPositionSwitch())
    	{
    		currentPosition = Robot.ArmSub.getCurrentPosition(currentPosition, direction);
    		SmartDashboard.putString("Current Position", currentPosition);
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
