package com.thalmic.myo.example;

import java.util.ArrayList;
import java.util.List;

import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.FirmwareVersion;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;

/*
** Created by Adolfo Segura
*/

//This class provides a cleaner way to keep track of multiple Myos and printing the Data off of them
public class PrintMyoEvents {
    private final List<BluetoothDevice> myoDevicesArray = new ArrayList<>(); //An arraylist of type BlueoothDevice that I made
    private BluetoothDevice myoDevice = new BluetoothDevice(); //Creating a new BluetoothDevice. 
    private String poseToString;
   
    PrintMyoEvents() {
	    myoDevice.getHub().addListener(new AbstractDeviceListener() {
	    
		    @Override
		    public void onPair(Myo myo, long timestamp, FirmwareVersion firmwareVersion) {
		    	myoDevicesArray.add(myoDevice);
		    }
		
		    @Override
		    public void onPose(Myo myo, long timestamp, Pose pose) {
		    	//System.out.println(String.format("Myo %s switched to pose %s.", identifyMyo(myo), pose.toString()));
		    	//System.out.println(pose.toString());

		    	if (myo != null) {
		            if (pose.getType() != com.thalmic.myo.enums.PoseType.UNKNOWN) {
		                 switch (pose.getType()) {
		                     case REST:
		                       	System.out.println("REST");
		                       	//setposeString(pose.);
		                       	myoDevice.setposeString("rest");
		                        break;
		                     case FIST:
		                       	System.out.println("FIST");
		                    	myoDevice.setposeString("fist");
		                        break;
		                     case WAVE_IN:
		                       	System.out.println("WAVE_IN");
		                    	myoDevice.setposeString("wave-in");
		                        break;
		                     case WAVE_OUT:
		                       	System.out.println("WAVE_OUT");
		                    	myoDevice.setposeString("wave-out");
		                        break;
		                     case FINGERS_SPREAD:
		                       	System.out.println("FINGERS_SPREAD");
		                    	myoDevice.setposeString("fingers spread");
		                         break;
		                     case DOUBLE_TAP:
		                       	System.out.println("DOUBLE_TAP");
		                    	myoDevice.setposeString("Double tap");
		                        break;
		                default:
							break;
		                }
		            }
		    	}
		    }
		
		    @Override
		    public void onConnect(Myo myo, long timestamp, FirmwareVersion firmwareVersion) {
		    	System.out.println(String.format("Myo %s has connected.", identifyMyo(myo)));
		    }
		
		    @Override
		    public void onDisconnect(Myo myo, long timestamp) {
		    	System.out.println(String.format("Myo %s has disconnected.", identifyDevice(myo)));
		    }

		    private int identifyMyo(Myo myo) {
		    	return myoDevicesArray.indexOf(myo);
		    }
	    });
	    
		while (true) {
	          myoDevice.getHub().run(1000 / 20);
	    }
    }

	//Method to identify Multiple Myos. If no Myo exists it creates a new one by making a new BluetoothDevice()
	private BluetoothDevice identifyDevice(Myo myo) {
        if (this.myoDevicesArray.isEmpty()) {
        	BluetoothDevice myoDevice = new BluetoothDevice(myo, 0);
            if (this.myoDevicesArray == myoDevice) {
                return myoDevice;
            }
            this.myoDevicesArray.add(myoDevice);
            return myoDevice;
        } else {
            for (BluetoothDevice myoDevice : myoDevicesArray) {
                if (myoDevice.getMyo() == myo){
                    return myoDevice;
                }
            }
        }
        BluetoothDevice myoDevice = new BluetoothDevice(myo, this.myoDevicesArray.size());
        if (this.myoDevicesArray == myoDevice) {
            return myoDevice;
        }
        this.myoDevicesArray.add(myoDevice);
        return myoDevice;
    }
}
