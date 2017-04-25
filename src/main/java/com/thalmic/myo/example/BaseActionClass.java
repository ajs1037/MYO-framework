/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thalmic.myo.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BaseActionClass implements ActionListener {
 
	
	    private static boolean active = true;
	    public static void setActive(boolean active){
	    	BaseActionClass.active = active;
	    }

	    protected abstract void doPerformAction(ActionEvent e);

	    @Override
	    public final void actionPerformed(ActionEvent e){
	        if(active){
	            doPerformAction(e);
	        }
	    }
	
	
}