package org.usfirst.frc.team4183.robot;

/**
 * The format for the conversion constants is <code>[INPUT]_TO_[OUTPUT]</code>.
 * When you multiply something with the <code>[INPUT]</code> units by the
 * constant, you get a number in the <code>[OUTPUT]</code> units. units are as
 * follows: MMS = millimetres per second IN = inches MM = millimetres FT = feet
 * REV = revolutions of the encoder shaft RPM = REV per minute WRPM = wheel RPM
 * K = constant
 * 
 * @author James Wyeth
 *
 */
public class Constants {
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////// UNIT
	///////////////////////////////////////////////////////////////////////////////////////////////////////////// CONVERTERS///////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** Inch to mm converter so that low level programming can be done in mm **/
	public static final double IN_TO_MM = 25.4;
	/** Inch to foot converter **/
	public static final int FT_TO_IN = 12;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////// DIMENSIONS/////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** The wheel circumference in inches (in/rev) **/
	public static final double WHEEL_CIRCUMFERENCE_IN = 10 * Math.PI;
	/** The wheel circumference in mm (mm/rev) **/
	public static final int WHEEL_CIRCUMFERENCE_MM = (int) Math.round(WHEEL_CIRCUMFERENCE_IN * IN_TO_MM);
	/** The number of teeth on the driving sprocket from the gearbox. **/
	public static final int DRIVE_SPROCKET_TEETH = 12;
	/**
	 * The number of teeth on the sprockets that are attached to the wheels.
	 **/
	public static final int WHEEL_SPROCKET_TEETH = 36;
	/** The conversion from the wheel RPM to the drive RPM **/
	public static final double WRPM_TO_RPM = DRIVE_SPROCKET_TEETH / WHEEL_SPROCKET_TEETH;
	/** Maximum RPM for the wheels **/
	public static final int MAX_WRPM = 275;
	/** Maximum RPM for the motors **/
	public static final int MAX_RPM = (int) (MAX_WRPM * WRPM_TO_RPM);

	/**
	 * The width between the centre of the left centre wheel and the right
	 * centre wheel in IN.
	 **/
	public static final double WHEEL_WIDTH_IN = 18.5;
	/**
	 * The width betweeen the centre of the left centre wheel and the right
	 * centre wheel in REV.
	 **/
	public static final double WHEEL_WIDTH_REV = WHEEL_WIDTH_IN * WRPM_TO_RPM / WHEEL_CIRCUMFERENCE_IN;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final double INTAKE_SPEED = 0.5;
	public static final double SHOOTER_SPEED = 1;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** Multiply with a velocity in mm/s to get RPM of the wheels **/
	public static final int DRIVE_VEL_MMS_TO_WRPM = (1 / WHEEL_CIRCUMFERENCE_MM) * 60;

	/** arbitrary value atm **/
	public static final double DRIVE_RAD_TO_WRPM = 0.25;
	/** The counts per revolution of the encoders on the drive motor **/
	public static final int DRIVE_ENC_CPR = 1000;

	public static final double DRIVE_KANGLE = 1;
           
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** The angle to set the servo to to unlock the ratchet **/
	public static final int WINCH_SERVO_UNLOCK_ANGLE = 70;
	/** The angle to set the servo to to lock the ratchet **/
	public static final int WINCH_SERVO_LOCK_ANGLE = 118;
	
	/** Shoot setpoint **/
	public static final int WINCH_SHOOT_POS = -75000;
	/** Lift setpoint **/
	public static final int WINCH_LIFT_POS = -450000;
	/** Ball sepoint **/
	public static final int WINCH_INTAKE_POS = -2000;
	
	/** The speed to run the winch at **/
	public static final double WINCH_SPEED = 0.4;
	/**The speed to run the winch before unlatching**/
	public static final double WINCH_PREP_SPEED = 0.75;
	
	/** Time in ms to unlatch the winch ratchet **/
	public static final int WINCH_UNLAT_TIME = 400;
	/**Time in ms to get to the ball grabbing position**/
	public static final int SWARMY_DOWN_TIME = 300;
	/**Time in ms to get to the up position**/
	public static final int SWARMY_UP_TIME = 300;
	/**Time in ms to wait after ball is detected on intake**/
	public static final int INTAKE_TIMEOUT_TIME = 1000;
	/**Time in ms for the ball to cease contact with the shooter**/
	public static final int SHOOT_DELAY_TIME = 100;
	
	/** Max current for winch motor **/
	public static final int WINCH_MAX_CURRENT = 50;
	/** Max current for intake motor **/
	public static final int INTAKE_MAX_CURRENT = 25;
	/** Safe mode constant **/
	public static final double SAFE_MODE = .5;
	
	/**Max voltage for winch motor**/
	public static final int MAX_WINCH_VOLTAGE = 2;
	
/////////////////////////////////////////////Winch PID Values//////////////////////////////////////////////////////////////
	public static final double WINCH_P = 10.0/500000.0;
	public static final double WINCH_I = 0.001/50000.0;
	public static final double WINCH_D = 0;
	public static final double WINCH_ACCEPTANCE_RANGE = 10000;
	public static final double WINCH_PID_PERIOD = 0.01;
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final double CHEZ_GAIN = 1.0;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////// POWER DISTRIBUTION BOARD CHANNELS/////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**Winch motor power channel one**/
	public static final int WINCH_POWER_ONE = 4;
	/**Winch motor power channel two**/
	public static final int WINCH_POWER_TWO = 1;
			
	public class Autonomous {
		/** The driving velocity in MMS **/
		public static final int DRIVE_VEL = 25;

		public static final double DRIVE_ANGLE_COEFFICIENT = 180;
	}

}
