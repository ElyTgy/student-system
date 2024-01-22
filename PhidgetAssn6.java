import java.lang.Thread;
import com.phidget22.*;
import java.util.Scanner; 
import java.io.IOException;



public class PhidgetAssn6 extends Thread {
    /**
     * Summary: Constructor for Main class
     * @params: None
     * @return: None
     */
    public PhidgetAssn6(){
        //None
    }//END of constructor
    
    
    
    
    
    /**
     * Summary: run the logic for phidgets
     * @params: None
     * @return: None
     */
    @Override public void run() {
        try {
            //Creates object for LED and RFID sensor
            DigitalOutput redLED = new DigitalOutput();
            RFID rfid0 = new RFID();
             
            //Tells program where to find the device
            redLED.setHubPort(1);
            redLED.setIsHubPortDevice(true);
    
            //Establishes connection between the object and the Phidget. Timeout value of 1000 to give the program 1 second to locate the Phidget. If the Phidget can't be found, an exception will be thrown.
            redLED.open(1000);
            
            
    
            rfid0.addTagListener(new RFIDTagListener() {
                public void onTag(RFIDTagEvent e) {
                    try
                    {
                        redLED.setState(true);
                    }
                    catch (PhidgetException pe)
                    {
                        pe.printStackTrace();
                    }//End of Try Catch
                }//End of onTag 
            });
    
            rfid0.addTagLostListener(new RFIDTagLostListener() {
                public void onTagLost(RFIDTagLostEvent e) {
                    try
                    {
                        redLED.setState(false);
                    }
                    catch (PhidgetException pe)
                    {
                        pe.printStackTrace();
                    }//End of Try Catch
                }//End of onTagLost
            });
    
            rfid0.open(5000);
    
            //Wait until Enter has been pressed before exiting
            System.in.read();
    
            rfid0.close();
                
     
        }
        catch (Exception E){
            System.out.println("Error");
        }//END of try-catch
        
    }//End of main method
}//End of class