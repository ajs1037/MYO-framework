package com.thalmic.myo.example;

import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.FirmwareVersion;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;
import com.thalmic.myo.example.BluetoothDevice;



public class PrintEmgData extends AbstractDeviceListener {
	
	private BluetoothDevice myoDevice = new BluetoothDevice();
	
	PrintEmgData() {

		Hub tempHub = new Hub("com.example.print.emg.data");
		myoDevice.setHub(tempHub);
		

		DeviceListener dC = new DataCollector();
		myoDevice.getHub().addListener(dC);

		while (true) {
			myoDevice.getHub().run(1000 / 20);
			System.out.println(dC);
		}
	}
}