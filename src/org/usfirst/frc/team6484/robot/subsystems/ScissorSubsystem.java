package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */
public class ScissorSubsystem extends Subsystem {
	
	private static DoubleSolenoid scissor;
	
	public ScissorSubsystem()
	{
		scissor = new DoubleSolenoid(RobotMap.scissorUp, RobotMap.scissorDown);
	}
	public void ScissorUp()
	{
		scissor.set(DoubleSolenoid.Value.kForward);
	}
	
	public void ScissorDown()
	{
		scissor.set(DoubleSolenoid.Value.kReverse);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

