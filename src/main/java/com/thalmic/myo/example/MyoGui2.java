package com.thalmic.myo.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyoGui2 {

	private JFrame frame;
	private JTextField textField;
	private BluetoothDevice myoDevice = new BluetoothDevice();

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
		
		JButton LockButton = new JButton("Lock");
		LockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonLockActionPerformed(e);
			}
		});
		LockButton.setBounds(6, 37, 117, 29);
		frame.getContentPane().add(LockButton);
		
		JButton UnlockButton = new JButton("UnLock");
		UnlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonUnlockActionPerformed(e);
			}
		});
		UnlockButton.setBounds(135, 6, 117, 29);
		frame.getContentPane().add(UnlockButton);
		
		JButton StreamButton = new JButton("Stream Data");
		StreamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonStreamDataActionPerformed(e);
			}
		});
		StreamButton.setBounds(135, 37, 117, 29);
		frame.getContentPane().add(StreamButton);
		
		JButton PoseButton = new JButton("Current Pose");
		PoseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonPoseActionPerformed(e);
			}
		});
		PoseButton.setBounds(264, 6, 117, 29);
		frame.getContentPane().add(PoseButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonExitActionPerformed(e);
			}
		});
		ExitButton.setBounds(264, 37, 117, 29);
		frame.getContentPane().add(ExitButton);
		
	}
	private void jButtonVibrateActionPerformed(ActionEvent e) {
		
		myoDevice.vibrate();
		textField.setText("Vibrating Myo");
	}
	
	private void jButtonPoseActionPerformed(java.awt.event.ActionEvent evt) {
		
		myoDevice.getCurrentPose();
	 }
	
	private void jButtonLockActionPerformed(java.awt.event.ActionEvent evt) {
		 myoDevice.lock();
		 textField.setText("Myo locked");
	 }
	
	private void jButtonUnlockActionPerformed(java.awt.event.ActionEvent evt) {
		 myoDevice.unlock();
		 textField.setText("Myo Unlocked");
	 }
	 
	 private void jButtonStreamDataActionPerformed(java.awt.event.ActionEvent evt) {
		 myoDevice.getEmgData();
		 textField.setText("Getting all the EMG data from Myo");
	 }
	 
	 private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
		 textField.setText("Exiting!");
		 System.exit(0);
	 }
}
