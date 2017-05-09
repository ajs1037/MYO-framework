package com.thalmic.myo.example;


import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;
import com.thalmic.myo.Vector3;
import com.thalmic.myo.enums.Arm;
import com.thalmic.myo.enums.UnlockType;
import com.thalmic.myo.enums.VibrationType;

/**
 * Created by adolfosegura on 2/21/17.
 */

//I created this BluetoothDevice class so the developer only has to create a new instance
// of BluetoothDevice and this class will automatically take care of getting/setting myo and hub
public class BluetoothDevice{
	
	//private BluetoothDevice myoDevice = new BluetoothDevice();
	
    private Hub hub;
    private Myo myo;
    private PrintMyoEvents pose;
    private Pose pose1;
    private int id;
    private String poseString;
    //private String accelerometer;
    //private String gyroscope;
    private Vector3 orientation;
    private int rssi;
    //private boolean withEmg;
    private PrintEmgData emg;
    private int batteryLevel;

    //Constructor
    BluetoothDevice() {
    	this.hub = new Hub("");
    	this.myo = hub.waitForMyo(10000);
        this.poseString = getposeString();
        //this.firmware = "";
        this.rssi = 0;
        this.getRssi();
        this.batteryLevel = 0;
        this.getBatteryLevel();
        //this.pose = new Pose();
        this.orientation = new Vector3();
        //this.accelerometer = new Vector3();
        //this.gyroscope = new Vector3();
    }
	
    
     BluetoothDevice(Myo myo, int id) {
    	this.hub = new Hub("");
    	this.myo = hub.waitForMyo(10000);
     }
     
	public Hub getHub() {
		return hub;
	}

	public void setHub(Hub hub) {
		this.hub = hub;
	}

	public String getposeString() {
		return poseString;
	}

	public void setposeString(String pS) {
		this.poseString = pS;
	}
	
	public void getCurrentPose() {
		setPose(new PrintMyoEvents());
	}
	
	public Myo getMyo() {
		return myo;
	}

	public void setMyo(Myo myo) {
		this.myo = myo;
	}

	public void getEmgData() {
		emg = new PrintEmgData();
	}
	
	public BluetoothDevice lock() {
        this.myo.lock();
        return this;
    }
	
	public BluetoothDevice unlock(UnlockType mode) {
        switch (mode) {
            case UNLOCK_HOLD:
                this.myo.unlock(UnlockType.UNLOCK_HOLD);
                break;
            case UNLOCK_TIMED:
            default:
                this.myo.unlock(UnlockType.UNLOCK_TIMED);
                break;
        }
        return this;
    }
	
	public BluetoothDevice unlock() {
        this.myo.unlock(UnlockType.UNLOCK_HOLD);
        return null;
    }
	
	public int getRssi() {
        return this.rssi;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public BluetoothDevice requestRssi() {
        this.myo.requestRssi();
        return this;
    }

    public BluetoothDevice requestBatteryLevel() {
        this.myo.requestBatteryLevel();
        return this;
    }
	
    public void vibrate() {
        this.myo.vibrate(VibrationType.VIBRATION_MEDIUM);
    }

	public PrintMyoEvents getPose() {
		return pose;
	}

	public void setPose(PrintMyoEvents pose) {
		this.pose = pose;
	}
}
