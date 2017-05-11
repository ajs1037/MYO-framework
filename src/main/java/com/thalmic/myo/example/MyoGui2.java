package com.thalmic.myo.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Adolfo Segura.... 
 */

//This is where I made the Gui for the myo
public class MyoGui2 {

	private JFrame frame;
	private JTextField textField;
	private BluetoothDevice myoDevice = new BluetoothDevice(); //Uses the class I made to make an 
								   // instance of the BluetoothDevice (Myo)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyoGui2 window = new MyoGui2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyoGui2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(6, 88, 438, 184);
		frame.getContentPane().add(textField);
		
		JButton VibrateButton = new JButton("Vibrate");
		VibrateButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				jButtonVibrateActionPerformed(e);
			}
		});
		
		
		VibrateButton.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(VibrateButton);
								//Locks the Myo when it is clicked 
		JButton LockButton = new JButton("Lock");		
		LockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonLockActionPerformed(e);
			}
		});
		LockButton.setBounds(6, 37, 117, 29);
		frame.getContentPane().add(LockButton);
									//Unlocks the Myo when it is clicked 
		JButton UnlockButton = new JButton("UnLock");
		UnlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonUnlockActionPerformed(e);
			}
		});
		UnlockButton.setBounds(135, 6, 117, 29);
		frame.getContentPane().add(UnlockButton);
									//Streams the current data from Myo when it is clicked 
		JButton StreamButton = new JButton("Stream Data");
		StreamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonStreamDataActionPerformed(e);
			}
		});
		StreamButton.setBounds(135, 37, 117, 29);
		frame.getContentPane().add(StreamButton);
									//Once clicked, it will print out the current pose  
									//whenever the user changes poses
		JButton PoseButton = new JButton("Current Pose");
		PoseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonPoseActionPerformed(e);
			}
		});
		PoseButton.setBounds(264, 6, 117, 29);
		frame.getContentPane().add(PoseButton);
		
		JButton ExitButton = new JButton("Exit");		//System.exit(0);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonExitActionPerformed(e);
			}
		});
		ExitButton.setBounds(264, 37, 117, 29);
		frame.getContentPane().add(ExitButton);
		
	}
	private void jButtonVibrateActionPerformed(ActionEvent e) {
		
		myoDevice.vibrate(); //Uses the vibrate method made available when a new Bluetoothdevice instance is made
		textField.setText("Vibrating Myo");
	}
	
	private void jButtonPoseActionPerformed(java.awt.event.ActionEvent evt) {
		
		myoDevice.getCurrentPose(); //Uses the getCurrentPose method I made in BluetoothDevice
	 }
	
	private void jButtonLockActionPerformed(java.awt.event.ActionEvent evt) {
		 myoDevice.lock(); //Uses the lock method I made in BluetoothDevice
		 textField.setText("Myo locked");
	 }
	
	private void jButtonUnlockActionPerformed(java.awt.event.ActionEvent evt) {
		 myoDevice.unlock(); //Uses the unlock method I made in BluetoothDevice
		 textField.setText("Myo Unlocked");
	 }
	 
	 private void jButtonStreamDataActionPerformed(java.awt.event.ActionEvent evt) {
		 myoDevice.getEmgData(); //Uses the getEmgData method I made in BluetoothDevice
		 textField.setText("Getting all the EMG data from Myo");
	 }
	 
	 private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
		 textField.setText("Exiting!");
		 System.exit(0);
	 }
}
