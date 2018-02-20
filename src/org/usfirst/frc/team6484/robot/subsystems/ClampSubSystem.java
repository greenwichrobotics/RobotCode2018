package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6484.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

public class ClampSubSystem extends Subsystem {
	
	private static Solenoid clamp;
	
	public ClampSubSystem()
	{
		clamp = new Solenoid(RobotMap.clamp);
	}
	
	public void clampOn()
	{
		clamp.set(true);
	}	
	
	public void clampOff()
	{
		clamp.set(false);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}