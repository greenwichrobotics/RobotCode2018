package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */
public class ArmSubSystem extends Subsystem {
	
	DoubleSolenoid lockPin;
	Spark armMotor;
	DigitalInput topArmSwitch;
	DigitalInput bottomArmSwitch;
	DigitalInput armPositionSwitch;
	
	public ArmSubSystem()
	{
		armMotor = new Spark(RobotMap.armMotor);
		topArmSwitch = new DigitalInput(RobotMap.topArmSwitch);
		bottomArmSwitch = new DigitalInput(RobotMap.bottomArmSwitch);
		lockPin = new DoubleSolenoid(RobotMap.lockIn,RobotMap.lockOut);
		armPositionSwitch = new DigitalInput(RobotMap.armPositionSwitch);
	}	
	
   public void armUp()
   {
	   armMotor.set(0.2);
   }
   public void armDown()
   {
	   armMotor.set(-0.2);
   }
   public void armStop()
   {
	   armMotor.set(0);
   }
   public boolean getTopSwitch()
   {
	   return !topArmSwitch.get();  
   }
   public boolean getBottomSwitch() 
   {
	   return !bottomArmSwitch.get();
   }
   public boolean getPositionSwitch()
   {
	   return !armPositionSwitch.get();
   }
   public void lockIn()
   {
	   lockPin.set(DoubleSolenoid.Value.kForward);
   }
   public void lockOut()
   {
	   lockPin.set(DoubleSolenoid.Value.kReverse);
   }
   public String getCurrentPosition(String lastPosition,String direction) {
	   if(direction == "up") {
		   switch(lastPosition)
		   {
			   case "Start":
				   return "Climb";
			   case "Switch":
				   return "Start";
			   case "Bottom":
				   return "Switch";
		   }
	   }			 
	   else if(direction == "down") {
		   switch(lastPosition)
		   {
		   	   case "Start":
		   		   return "Switch";
		   	   case "Climb":
		   		   return "Start";
		   	   case "Switch":
		   		   return "Bottom";
		   }
		   
		   }
	   return lastPosition;
		   
	   }

   
    public void initDefaultCommand() {
    	// setDefaultCommand
    }

		
}

