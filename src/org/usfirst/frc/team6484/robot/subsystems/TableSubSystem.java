package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6484.robot.RobotMap;
import org.usfirst.frc.team6484.robot.commands.SweepMotorCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class TableSubSystem extends Subsystem {
	DoubleSolenoid table;
	


	public TableSubSystem() {
    	table = new DoubleSolenoid(RobotMap.tableOut,RobotMap.tableIn);
    }

    public void pushTable() { 
		table.set(DoubleSolenoid.Value.kForward);
	}
	
	public void pullTable(){
		table.set(DoubleSolenoid.Value.kReverse);
	}
	public void initDefaultCommand()
	{
		//setDefaultCommand(new SweepMotorCommand());
	}
	
}