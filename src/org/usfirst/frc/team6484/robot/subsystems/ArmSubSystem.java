package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */
public class ArmSubSystem extends Subsystem {
	
	Solenoid lockPin;
	Spark armMotor;
	DigitalInput topArmSwitch;
	DigitalInput bottomArmSwitch;
	DigitalInput armPositionSwitch;
	DoubleSolenoid armRatchet;
	public int armLocation;
	String direction;
	boolean togglePositionSwitch;
	
	
	public ArmSubSystem()
	{
		armMotor = new Spark(RobotMap.armMotor);
		topArmSwitch = new DigitalInput(RobotMap.topArmSwitch);
		bottomArmSwitch = new DigitalInput(RobotMap.bottomArmSwitch);
		//lockPin = new Solenoid(RobotMap.armLockPin);
		armRatchet = new DoubleSolenoid(0, 1);
		armPositionSwitch = new DigitalInput(RobotMap.armPositionSwitch);
		armLocation = 0;
		direction="";
		togglePositionSwitch = false;
		
	}	
	
   public void armUp()
   {
	   ratchetOut();
	   armMotor.set(1.0);
   }
   public void armDown()
   {
	   ratchetOut();
	   armMotor.set(-0.3);
   }
   public void armStop()
   {
	   armMotor.set(0);
	   ratchetIn();
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
	   return armPositionSwitch.get();
   }
   public void lockIn()
   {
	   lockPin.set(true);
   }
   public void lockOut()
   {
	   lockPin.set(false);
   }
   public void ratchetIn()
   {
	   armRatchet.set(DoubleSolenoid.Value.kForward);
   }
    
   public void ratchetOut()
   {
	   armRatchet.set(DoubleSolenoid.Value.kReverse);
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
   	public void increasePosition() {
   		armLocation++;
   	}
   	public void decreasePosition() {
   		armLocation--;
   	}
   	
//   	public void moveToBase() {
//   		moveTo(0);
//   	}
//   	public void moveToStart() {
//   		moveTo(1);
//   	}
//   	public void moveToSwitch() {
//   		moveTo(2);
//   	}
//   	public void moveToClimb() {
//   		moveTo(3);
//   	}
//   	
//   	
//   	private void moveTo(int position) {
//   		trackArmLocation();
//   		if (armLocation != position) {
//   			if(armLocation > position){
//   				ratchetOut();
//   				direction = "down";
//   				armMotor.set(-0.3);
//   			}else if (armLocation < position){
//   				ratchetOut();
//   				direction="up";
//   				armMotor.set(0.5);
//   			}else {
//   				armMotor.set(0.0);
//   				ratchetIn();
//   				togglePositionSwitch = false;
//   			}
//   		}else {
//   			armMotor.set(0.0);
//   			ratchetIn();
//   			togglePositionSwitch = false;
//   		}
//   	}
//   	private final void trackArmLocation() {
//   		if(togglePositionSwitch && getPositionSwitch()) {
//   			togglePositionSwitch=false;
//   			if (direction == "up" && armLocation < 3) {
//   				armLocation++;
//   			}else if(direction=="down" && armLocation > 0) {
//   				armLocation--;
//   			}
//   		}
//   		if (!getPositionSwitch()) {
//   			togglePositionSwitch=true;
//   		}
//   	}
   	
   	
   
    public void initDefaultCommand() {
    	// setDefaultCommand
    }

		
}

