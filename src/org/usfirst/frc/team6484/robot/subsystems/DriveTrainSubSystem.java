package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team6484.robot.commands.DriveTrainCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainSubSystem extends Subsystem {
	DifferentialDrive m_drive;
	Spark m_frontLeft;
	Spark m_rearLeft;
	Spark m_frontRight;
	Spark m_rearRight;
	SpeedControllerGroup m_left;
	SpeedControllerGroup m_right;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveTrainSubSystem() {
    	   m_frontLeft = new Spark(0);
    	   m_rearLeft = new Spark(1);
    	   m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    	   m_frontRight = new Spark(2);
    	   m_rearRight = new Spark(3);
    	   m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    	   m_drive = new DifferentialDrive(m_left, m_right);
    }
    
    public void arcadeDrive(double xSpeed, double zRotation) {
    	m_drive.arcadeDrive(xSpeed, zRotation);
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveTrainCommand());
    }
}

