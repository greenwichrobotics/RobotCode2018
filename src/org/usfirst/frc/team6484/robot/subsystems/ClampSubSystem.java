package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6484.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class ClampSubSystem extends Subsystem {
	
	private static DoubleSolenoid clamp;
	
	public ClampSubSystem()
	{
		clamp = new DoubleSolenoid(RobotMap.clampOut, RobotMap.clampIn);
	}
	
	public void clampOn()
	{
		clamp.set(DoubleSolenoid.Value.kForward);
	}	
	
	public void clampOff()
	{
		clamp.set(DoubleSolenoid.Value.kReverse);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}