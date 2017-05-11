package com.thalmic.myo.example;

import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;

//This class is the Sample code they provide in the Myo SDK. 
public class HelloMyo {
	public static void main(String[] args) {
		try {
			//As you can see the a new Hub is created
			Hub hub = new Hub("com.example.hello-myo");

			System.out.println("Attempting to find a Myo...");
			//Then a new Myo is created
			Myo myo = hub.waitForMyo(10000);

			if (myo == null) {
				throw new RuntimeException("Unable to find a Myo!");
			}

			System.out.println("Connected to a Myo armband!");
			//Then you have to add the dataCollector onto the hub.... or Myo?.... confusing right?
			DeviceListener dataCollector = new DataCollector();
			hub.addListener(dataCollector);				//It is more efficient to just create a new BluetoothDevice
										// that I made. 
			while (true) {
				hub.run(1000 / 20);
				System.out.print(dataCollector);
			}
		} catch (Exception e) {
			System.err.println("Error: ");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
