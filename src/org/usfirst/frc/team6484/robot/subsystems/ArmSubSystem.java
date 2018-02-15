package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */
public class ArmSubSystem extends Subsystem {
	
	Spark armMotor;
	DigitalInput topArmSwitch;
	DigitalInput bottomArmSwitch;
	
	public ArmSubSystem()
	{
		armMotor = new Spark(RobotMap.armMotor);
		topArmSwitch = new DigitalInput(RobotMap.topArmSwitch);
		bottomArmSwitch = new DigitalInput(RobotMap.bottomArmSwitch);
	}
	
   public void armUp()
   {
	   armMotor.set(0.2);
   }
   public void armDown()
   {
	   armMotor.set(-0.2);
   }
   public boolean getTopSwitch()
   {
	   return !topArmSwitch.get();  
   }
   public boolean getBottomSwitch() 
   {
	   return !bottomArmSwitch.get();
   }
    public void initDefaultCommand() {
    	// setDefaultCommand
    }
}

