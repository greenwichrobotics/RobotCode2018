/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6484.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Motors
	public static int driveMotor1 = 0;
	public static int driveMotor2 = 1;
	public static int driveMotor3 = 2;
	public static int driveMotor4 = 3;
	public static int leftSweeperMotor = 4;
	public static int rightSweeperMotor = 5;
	public static int armMotor = 6;
	public static int winchMotor = 7;
	
	//DIO
	public static int pilotControllerPort = 0;
	public static int copilotControllerPort = 1;
	public static int intakeSwitch = 2;
	public static int topArmSwitch = 3;
	public static int bottomArmSwitch = 4;
	public static int armPositionSwitch = 5;
	

	//Pneumatics
	public static int tableOut = 0;//out
	public static int tableIn = 1;//in
	public static int clampOut = 2;
	public static int clampIn = 3;
	public static int scissorUp = 4;
	public static int scissorDown = 5;
	public static int sweepIn = 6;
	public static int sweepOut = 7;
	public static int lockIn = 8;
	public static int lockOut = 9;
}
