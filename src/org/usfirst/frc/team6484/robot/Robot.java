/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team6484.robot.commands.ArmCommand;
import org.usfirst.frc.team6484.robot.commands.ClampCommand;
import org.usfirst.frc.team6484.robot.commands.ScissorCommand;
import org.usfirst.frc.team6484.robot.commands.SweepMotorCommand;
import org.usfirst.frc.team6484.robot.commands.TableCommand;
import org.usfirst.frc.team6484.robot.commands.autonomous.*;
import org.usfirst.frc.team6484.robot.subsystems.DriveTrainSubSystem;
import org.usfirst.frc.team6484.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team6484.robot.subsystems.SweepMotorSubSystem;
import org.usfirst.frc.team6484.robot.subsystems.ArmSubSystem;
import org.usfirst.frc.team6484.robot.subsystems.ClampSubSystem;
import org.usfirst.frc.team6484.robot.subsystems.TableSubSystem;
import org.usfirst.frc.team6484.robot.subsystems.ScissorSubsystem;
import org.usfirst.frc.team6484.robot.subsystems.WinchSubSystem;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveTrainSubSystem DriveTrainSub = new DriveTrainSubSystem();
	public static final SweepMotorSubSystem SweepMotorSub = new SweepMotorSubSystem();
	public static final GyroSubsystem Gyro = new GyroSubsystem();
	public static final TableSubSystem TableSub = new TableSubSystem();
	public static final ClampSubSystem ClampSub = new ClampSubSystem();
	public static final ScissorSubsystem ScissorSub = new ScissorSubsystem();
	public static final WinchSubSystem WinchSub = new WinchSubSystem();
	public static final ArmSubSystem ArmSub = new ArmSubSystem(); 
	//public static final UltrasonicSubSystem UltrasonicSub = new UltrasonicSubSystem();

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		OI.init();

		m_chooser.addDefault("Nothing", null);
		m_chooser.addObject("Baseline", new DriveForward());
		m_chooser.addObject("Left Delivery", new LeftDelivery());
		m_chooser.addObject("Right Delivery", new RightDelivery());
		m_chooser.addObject("Center Delivery",  new CenterDelivery());
//		m_chooser.addObject("Center To Left", new CenterToLeft());
//		m_chooser.addObject("Center To Right", new CenterToRight());
//		m_chooser.addObject("StraightAndDeliver", new DriveForwardDeliverBox());
		
		SmartDashboard.putData("Auto Mode", m_chooser);
		SmartDashboard.putNumber("Speed", -0.4);
		CameraServer.getInstance().startAutomaticCapture();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		
//		String gameData;
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
//                if(gameData.length() > 0)
//                {
//		  if(gameData.charAt(0) == 'L')
//		  {
//			  m_autonomousCommand = new CenterToLeft();
//		  } else {
//			  m_autonomousCommand = new CenterToRight();
//		  }
//                }
//                
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		Scheduler.getInstance().add(new ArmCommand());
		Scheduler.getInstance().add(new ClampCommand());
		Scheduler.getInstance().add(new ScissorCommand());
		//((Object) Scheduler.getInstance()).startAutomaticCapture();
		//Scheduler.getInstance().add(new SweepMotorCommand());
		Scheduler.getInstance().add(new TableCommand());
		//Scheduler.getInstance().add(new WinchCommand());
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Arm Bottom Switch", ArmSub.getBottomSwitch());
		SmartDashboard.putBoolean("Arm Top Switch", ArmSub.getTopSwitch());	
		SmartDashboard.putNumber("Copilot Trigger", OI.copilotController.getTriggerValue());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
