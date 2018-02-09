package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SweepMotorCommand extends Command {

    public SweepMotorCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.SweepMotorSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//ToDo if button ? is pressed and held
    	//Robot.SweepMotorSub.grabCube();
    	//Need to add method for a switch
    	//If the switch is pressed then do not run the motors in. 
    	//else if button ? is pressed and held
    	Robot.SweepMotorSub.pushCube();
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
