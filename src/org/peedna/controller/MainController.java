/**
 * @author Sandeep
 */
package org.peedna.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import org.peedna.ui.AlarmWindow;

import sun.applet.Main;

public class MainController implements ActionListener, ItemListener{

	static AlarmWindow view;
	JFileChooser App=new JFileChooser();
	JFileChooser PlayFile = new JFileChooser();
	public MainController(AlarmWindow v) {
		MainController.view=v;
		MainController.setEnabledPeriodicity(false);
		this.setEnabledSnooze(false);
		this.setEnabledPlaySound(false);
		this.setEnabledMessageBox(false);
		this.addActionListenertoView(this);
		this.addItemListenertoView(this);
		this.addActionListenertoSelectAlarmTime(new ActionListenertoAlarmTime());
		this.addActionListenertoSelectPeriodicity(new ActionListenertoDaysPanel());
	}

	private void setEnabledSnooze(boolean b) {
		MainController.view.setEnableSnoozeTime(b);
	}

	/*
	 * Sets the visibility of Message text area
	 */
	private void setEnabledMessageBox(boolean b) {
		MainController.view.setMessagePanel(b);
	}

	/*Sets the visibility of panel, which sets the 
	 * parameters of the file to be played
	 */
	private void setEnabledPlaySound(boolean b) {
		MainController.view.setPlaySound(b);
	}

	static void setEnabledPeriodicity(boolean b) {
		MainController.view.setDaysPanel(b);
	}
	
	private static void setEnabledTimePanel(boolean b) {
		MainController.view.setTimePanel(b);
	}

	public void actionPerformed(ActionEvent ae){
		if("Browse".equals(ae.getActionCommand())){
			int returnVal = PlayFile.showOpenDialog(MainController.view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = PlayFile.getSelectedFile();
		            MainController.view.setTextofPlayFile(file.getAbsolutePath());
			 }
	       }
		else if("Browse_1".equals(ae.getActionCommand())){
			int returnVal = App.showOpenDialog(MainController.view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file2 = App.getSelectedFile();
		            MainController.view.setTextofApp(file2.getAbsolutePath());
			 }
		}
		else if("Cancel".equals(ae.getActionCommand())){
			view.dispose();
		}
	}
	
	public void itemStateChanged(ItemEvent ie) {
		JCheckBox cb1 = (JCheckBox)ie.getItem();
		if(cb1.equals(MainController.view.getChckbxPlayFile())){
			if(cb1.isSelected()==true)
				this.setEnabledPlaySound(true);
			else this.setEnabledPlaySound(false);
		}
		else if(cb1.equals(MainController.view.getChckbxDisplayMessage())){
			if(cb1.isSelected())
				this.setEnabledMessageBox(true);
			else this.setEnabledMessageBox(false);
		}
		else if(cb1.equals(MainController.view.getChckbxSnooze())){
			if(cb1.isSelected())
				MainController.view.setEnableSnoozeTime(true);
			else MainController.view.setEnableSnoozeTime(false);
		}

	}
	
	/*public void addPeriodicityItemStateChanged() implements ItemListener{
	}*/
	public void addActionListenertoView(ActionListener arg0){
		MainController.view.setListener(arg0);
	}
	
	public void addItemListenertoView(ItemListener arg0){
		MainController.view.setItemListener(arg0);
	}
	
	public void addActionListenertoSelectPeriodicity(ActionListener arg0){
		MainController.view.setItemListenertoSelectPeriodicity(arg0);
	}
	
	public void addActionListenertoSelectAlarmTime(ActionListener arg0){
		MainController.view.setActionListenertoSelectAlarmTime(arg0);
	}
	
	class ActionListenertoDaysPanel implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			JComboBox cmbBox= MainController.view.getSelectPeriodicity();
			int selectIndex = cmbBox.getSelectedIndex();
			if(selectIndex==1){
				MainController.setEnabledPeriodicity(true);
				}
			else MainController.setEnabledPeriodicity(false);
		}
		
	}
	
	class ActionListenertoAlarmTime implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			JComboBox cmbBox = MainController.view.getSelectAlarmTime();
			String selection =cmbBox.getSelectedItem().toString();
			if (selection.equals("Manual")){
				MainController.setEnabledTimePanel(true);
			}
			else MainController.setEnabledTimePanel(false);
			
		}
		
	}
	
}

	