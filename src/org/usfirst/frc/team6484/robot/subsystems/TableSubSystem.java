package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6484.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 */
public class TableSubSystem extends Subsystem {
	Solenoid table;
	


	public TableSubSystem() {
    	table = new Solenoid(RobotMap.table);
    }

    public void pushTable() { 
		table.set(true);
	}
	
	public void pullTable(){
		table.set(false);
	}
	public void initDefaultCommand()
	{
		//setDefaultCommand(new SweepMotorCommand());
	}
	
}