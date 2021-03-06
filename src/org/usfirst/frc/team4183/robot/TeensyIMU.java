package org.usfirst.frc.team4183.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class TeensyIMU {
	private SerialPort serialPort;
	//public NetworkTable imuData;	
	private final int IMUMESSAGELEN = 39;
	
	
	public TeensyIMU(){
		System.out.println("Starting teeeeeeeeeeensy");
		serialPort = new SerialPort(SerialPortList.getPortNames()[0]);
		//System.out.println(serialPort.getPortName());
		
		    
		try {
			//Open serial port
			serialPort.openPort();
			//Set params.
		    serialPort.setParams(serialPort.BAUDRATE_115200, serialPort.DATABITS_8, 
		        						serialPort.STOPBITS_1, serialPort.PARITY_NONE);
		}catch (SerialPortException ex) {
		        System.out.println(ex);
		}
		//Thread for reading in serial data
		new Thread(new Runnable() {
			@Override
			public void run() {
				//Used as a bottleneck for raw data
				String inBuffer = "";
				//Raw data
				String rawIn = "";
				long timePrev = System.currentTimeMillis();
				long timeCurrent = System.currentTimeMillis();
				while(true){
					
					try {
						if((rawIn=serialPort.readString())!=null){
							//System.out.println(rawIn);
							inBuffer+=rawIn;
							for(String line : inBuffer.split("\n")){
								//New line counted as character
								line=line.substring(0, line.length()-1);
								if(line.length()==IMUMESSAGELEN){
									String[]poseData = line.split(",");
									if(poseData.length>=5){
										timeCurrent = System.currentTimeMillis();
										Robot.IMUTable.putNumber("Yaw", hexToDouble(poseData[4])*(180.0/Math.PI));
										Robot.IMUTable.putNumber("Pitch", hexToDouble(poseData[3])*(180.0/Math.PI));
										Robot.IMUTable.putNumber("Roll", hexToDouble(poseData[2])*(180.0/Math.PI));
										Robot.IMUTable.putNumber("Update rate", (double)(timeCurrent-timePrev));
										//System.out.println((double)(timeCurrent-timePrev));
							
										timePrev = timeCurrent;
									}
//									for(String datum:line.split(",")){
//										//First number is yaw angle
//										float yaw = hexToDouble(datum);
//										
//										//Puts yaw in public network table
//										Robot.IMUTable.putNumber("Yaw", yaw*(180.0/Math.PI));
//									}
									//Resets buffer
									inBuffer="";
								}else {
									inBuffer="";
								}
							}
						}		
					} catch (SerialPortException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Thread timeout
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
			}
		}).start();		 
	}
	private float hexToDouble(String str){		
		//Parses string as decimal
	    Long i = Long.parseLong(str, 16);
	    //Converts newly created decimals to floating point    
	    return Float.intBitsToFloat(i.intValue());
	}
		
	private long hexToLong(String str){
		return Long.parseLong(str,16);		
	}

}
