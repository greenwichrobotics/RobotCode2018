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
	public static int driveMotor1 = 0;//check right
	public static int driveMotor2 = 1;//check right
	public static int driveMotor3 = 2;//check left
	public static int driveMotor4 = 3;//check left
	public static int leftSweeperMotor = 6;//check
	public static int rightSweeperMotor = 7;//check
	public static int armMotor = 5;//check bob
	public static int winchMotor = 4;//check
	
	//DIO

	//public static int intakeSwitch = 2;
	
	public static int armEncoderA = 0;
	public static int armEncoderB = 1;
	public static int topArmSwitch = 2; //check
	public static int bottomArmSwitch = 6; //check
	public static int armPositionSwitch = 3; //check
	public static int tableDown = 7; //check
	
	public static int winchEncoderA = 4; //check
	public static int winchEncoderB = 5; //check
	

	//Pneumatics
	public static int armLockPin = 0;
	public static int lift = 1;
	public static int sweeper = 3;
	public static int table = 4;
	public static int clamp = 6;
	
	//USB
	public static int pilotControllerPort = 0;
	public static int copilotControllerPort = 1;
}
