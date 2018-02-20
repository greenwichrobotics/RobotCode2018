package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.commands.SweepMotorCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */ 
public class SweepMotorSubSystem extends Subsystem {

	public static Solenoid sweeperCylinder;
    Spark leftIntake;
    Spark rightIntake;
    DigitalInput limitButton;
    
    public SweepMotorSubSystem()
    {
    	sweeperCylinder = new Solenoid(RobotMap.sweeper);
    	leftIntake = new Spark(RobotMap.leftSweeperMotor);
    	rightIntake = new Spark(RobotMap.rightSweeperMotor);
    }
    
    public void pullCube() {
    	leftIntake.set(-1.0);
    	rightIntake.set(1.0);
    }
    
    public void pushCube() {
    	leftIntake.set(1.0);
    	rightIntake.set(-1.0);
    }
    
    public void stopMotors() {
    	leftIntake.set(0.0);
    	rightIntake.set(0.0);
    }
    public void openSweep() {
    	sweeperCylinder.set(true);
    }
    public void closeSweep() {
    	sweeperCylinder.set(false);
    }
    public boolean getSweeperSwitch() {
    	return !limitButton.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SweepMotorCommand());
    }
    
}

