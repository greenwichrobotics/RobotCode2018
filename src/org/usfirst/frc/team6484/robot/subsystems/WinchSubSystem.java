package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6484.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class WinchSubSystem extends Subsystem {

	Spark winchMotor;
	
	public WinchSubSystem() 
	{
		winchMotor = new Spark(RobotMap.winchMotor);
	}
	public void winchUp() {
		winchMotor.set(0.5);
	}
	public void winchDown() {
		winchMotor.set(1.0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

