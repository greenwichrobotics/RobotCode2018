package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6484.robot.RobotMap;

/**
 *
 */
public class UltrasonicSubSystem extends Subsystem {
	//private static final AnalogInput mb1013 = new AnalogInput(0);
	private static final AnalogInput mb1013 = new AnalogInput(RobotMap.ultrasonic);
	
	private static final double VOLTS_TO_DIST = 1.0;

	public static double getVoltage() {
		return mb1013.getVoltage();
	}
	
	public static double getDistance() {
		return getVoltage() * VOLTS_TO_DIST;
	}
//	public static void updateDashboard() {
//		SmartDashboard.putNumber("Distance (volts)", getVoltage());
//		SmartDashboard.putNumber("Distance (real)", getDistance());
		 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

