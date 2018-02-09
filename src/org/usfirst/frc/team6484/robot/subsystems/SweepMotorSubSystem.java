package org.usfirst.frc.team6484.robot.subsystems;

import org.usfirst.frc.team6484.robot.commands.SweepMotorCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

/**
 *
 */ 
public class SweepMotorSubSystem extends Subsystem {

    Spark leftIntake;
    Spark rightIntake;
    
    public SweepMotorSubSystem()
    {
    	leftIntake = new Spark(4);
    	rightIntake = new Spark(5);
    }
    
    public void grabCube() {
    	leftIntake.set(1.0);
    	rightIntake.set(-1.0);
    }
    
    public void pushCube() {
    	leftIntake.set(-1.0);
    	rightIntake.set(1.0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SweepMotorCommand());
    }
}

