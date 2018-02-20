package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team6484.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */
public class WinchSubSystem extends Subsystem {

	Spark winchMotor;
	Encoder enc;
	
	public WinchSubSystem() 
	{
		winchMotor = new Spark(RobotMap.winchMotor);
		enc = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
	}
	public void winchUp() {
		winchMotor.set(0.5);
	}
	public void winchDown() {
		winchMotor.set(-1.0);
	}
	public void winchStop() {
		winchMotor.set(0.0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public int getEncoder() {
    	return enc.get();
    }
    
    
    
}

