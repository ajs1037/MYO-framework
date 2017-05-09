package com.thalmic.myo.example;

import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.FirmwareVersion;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;
import com.thalmic.myo.example.BluetoothDevice;



public class PrintEmgData extends AbstractDeviceListener {
	
	private BluetoothDevice myoDevice = new BluetoothDevice(); //Creates a new BluetoothDevice
	
	PrintEmgData() {

		Hub tempHub = new Hub("com.example.print.emg.data"); //Creating a new Hub
		myoDevice.setHub(tempHub); //Setting the hub to BluetoothDevice setter that I made
		

		DeviceListener dC = new DataCollector();
		myoDevice.getHub().addListener(dC); //Setting the hub from BluetoothDevice getter that I made

		while (true) {
			myoDevice.getHub().run(1000 / 20);
			System.out.println(dC);
		}
	}
}
