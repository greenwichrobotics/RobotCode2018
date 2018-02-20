package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */
public class ScissorSubsystem extends Subsystem {
	
	private static Solenoid scissor;
	private static DigitalInput tableSwitch;
	
	public ScissorSubsystem()
	{
		scissor = new Solenoid(RobotMap.lift);
		tableSwitch = new DigitalInput(RobotMap.tableDown);
	}
	public void ScissorUp()
	{
		scissor.set(true);
	}
	
	public void ScissorDown()
	{
		scissor.set(false);
	}

	public boolean getBottonSwitch() {
		 return !tableSwitch.get();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

