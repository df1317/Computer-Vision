
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.cscore.*;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.networktables.*;


public class Robot extends TimedRobot {

  //declarations
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("SmartDashboard");
  NetworkTableEntry testVal = table.getEntry("TestVal");
  HttpCamera test = new HttpCamera("Name", "http://frcvision.local:1182/?action=stream");

  @Override
  public void robotInit() {

    //initiation and whatnot
    inst.startClientTeam(1317);
		CameraServer.getInstance().addCamera(test);
    CameraServer.getInstance().startAutomaticCapture();
    
    //adding stuff to shuffleboard so that we can actually see the stuff from the pi
		Shuffleboard.getTab("SmartDashboard").add(test);
		Shuffleboard.update();

  }
  @Override
  public void robotPeriodic() {

    //retrieval and printing of data from the network table
    double foo = testVal.getDouble(0.0);
		System.out.println("foo" + foo);

  }
}
