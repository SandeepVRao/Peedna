/**
 * @author Sandeep
 */
package org.peedna.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.peedna.model.Model;
import org.peedna.ui.AlarmWindow;
import org.peedna.ui.RunAlarm;


public class MainController implements ActionListener, ItemListener{

	//New Alarm Window
	static AlarmWindow view;
	//the reusable model
	static Model model;
	//Window appearing after a Alarm is saved
	static RunAlarm RunningAlarmWindow;
	
	JFileChooser App=new JFileChooser();
	JFileChooser PlayFile = new JFileChooser();
	
	public MainController(AlarmWindow v, Model m, RunAlarm running) {
		MainController.model=m;
		MainController.view=v;
		MainController.RunningAlarmWindow=running;
		MainController.setEnabledPeriodicity(false);
		this.setEnabledSnooze(false);
		this.setEnabledPlaySound(false);
		this.setEnabledMessageBox(false);
		this.addActionListenertoView(this);
		this.addItemListenertoView(this);
		this.addActionListenertoSelectAlarmTime(new ActionListenertoAlarmTime());
		this.addActionListenertoSelectPeriodicity(new ActionListenertoDaysPanel());
		this.addActionListenertoSave(new ActionListenertoSave());
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

	/*
	 * Sets the visibility of panel, which sets the 
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
			System.exit(0);
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
	
	public void addActionListenertoSave(ActionListener arg0){
		MainController.view.setActionListenertoSave(arg0);
	}
	class ActionListenertoDaysPanel implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			JComboBox cmbBox= MainController.view.getSelectPeriodicity();
			int selectIndex = cmbBox.getSelectedIndex();
			//If Selected Item in dropdown of Periodicity is Manual 
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
	
	class updateRunAlarmUI extends TimerTask{
		int a=0;
		int b=0,c=0;
		String[] timeRem;
		
		public updateRunAlarmUI(String remainTime) {
			System.out.println("timeRem is"+remainTime);
			timeRem=remainTime.split(":");
			a = Integer.parseInt(timeRem[0]);
			b = Integer.parseInt(timeRem[1]);
			c = Integer.parseInt(timeRem[2]);
		}
		
		public void run(){
			System.out.println("a = "+a+" b = "+b+" c = "+c);
			String TimeToSet="";
			if(a==0 && b==0 && c==0){
				cancel();
				return;
			}
			else if(a!=0 && b==0 && c==0){
					a--;
					b=59;
					c=60;
				}
			else if(b != 0 && c == 0){
				b--;
				c=60;
			}
			c--;
			
			if(a<10) TimeToSet+="0";
			TimeToSet+=a+"";
			
			TimeToSet+=":";
			
			if(b<10) TimeToSet+="0";
			TimeToSet+=b+"";
			
			TimeToSet+=":";
			
			if(c<10) TimeToSet+="0";
			TimeToSet+=c+"";
			
			RunningAlarmWindow.setTime(TimeToSet);
		}
			
	}
	/*
	 * This class opens the file assuming that file can be read
	 */
	class RunFile extends TimerTask{
		File fileToRun = new File(model.getPlayFile());
		File appToRun=new File(model.getApp());
		String[] commandString = {model.getApp(), model.getPlayFile()};
		int whichToRun=0;
		
		public RunFile(int Number) {
			whichToRun=Number;
		}

		public void run() {
			if(whichToRun==4){
				cancel();
				return;
			}
			
			if(whichToRun==2 || whichToRun ==3){
				if(appToRun.canExecute()){
					try {
						Runtime.getRuntime().exec(commandString);
					} catch (IOException e) {
						System.out.println("Oh No!!The following went wrong :");
						e.printStackTrace();
					}
					System.out.println("using app");
				}
				else {
				try {
					Desktop currentDesktop=Desktop.getDesktop();
					currentDesktop.open(fileToRun);
				} catch (IOException e) {
					System.out.print("This filetype is not registered with your OS");
					e.printStackTrace();
				}
				}
			}
			
			if (whichToRun==1 ||whichToRun==3){
				JOptionPane.showMessageDialog(null, model.getMessage(),"Alarm",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	class ActionListenertoSave implements ActionListener{
		Calendar runningTime;
	    
		//Schedules to run the file
		Timer timer;
		
		//Schedules to update time left UI- RunningAlarmWindow
	    Timer timer2;
		public void actionPerformed(ActionEvent arg0) {
			
			if(arg0.getActionCommand().equals("Save")){
				/*
				 * Save the state to a file
				 */
				model.setSelectedAlarmMode(view.getSelectAlarmTime().getSelectedIndex());

				model.setSelectedRecurrence(view.getSelectPeriodicity().getSelectedIndex());
				
				model.SetSelectedDays(view.getStateofDays());
				
				model.setSnoozeSelected(view.getStateofSnooze());
				
				model.setSnoozeTime(view.getComboBoxSnooze());
				
				model.setPlayFileSelected(view.getChckbxPlayFile().isSelected());
				
				model.setMessageSelected(view.getChckbxDisplayMessage().isSelected());
				
				model.setPlayFile(view.getTextofPlayFile());
				
				model.setApp(view.getTextofApp());
				
				model.setMessage(view.getMessage());
				
				/*
				 * Code for starting the timer and Running the File in view goes here
				 * 
				 */
				runningTime = Calendar.getInstance();
				if(model.getSelectedAlarmMode()==0){
					runningTime.set(Calendar.HOUR_OF_DAY,view.getSpinHour());
					runningTime.set(Calendar.MINUTE, view.getSpinMinute());
				}
				else if (model.getSelectedAlarmMode()==1){
					runningTime.add(Calendar.MINUTE, 10);
				}
				else if (model.getSelectedAlarmMode()==2){
					runningTime.add(Calendar.MINUTE, 20);
				}
				else if(model.getSelectedAlarmMode()==3){
					runningTime.add(Calendar.MINUTE, 30);
				}
				else if(model.getSelectedAlarmMode()==4){
					runningTime.add(Calendar.HOUR_OF_DAY, 1);
				}
				
				//Update model
				model.setCurrentCalendar();
				model.setCal(runningTime);
				
				//Names the newly created Timer thread as "Timer Thread" and sets runAsDaemon as True 
				timer = new Timer("New Thread for timer",true);
				
				long diffInTime=model.getCal().getTimeInMillis()-model.getCurrentCalendar().getTimeInMillis();
				
				int whatToRun=0;
				if(model.isMessageSelected()) whatToRun=1;
				else if(model.isPlayFileSelected())whatToRun=2;
				else if(model.isMessageSelected() && model.isPlayFileSelected()) whatToRun=3;
				else whatToRun=4;
				
				if(model.isSnoozeSelected())
					timer.schedule(new RunFile(whatToRun), diffInTime,view.getComboBoxSnooze()*60*1000);
				
				else timer.schedule(new RunFile(whatToRun), diffInTime);

				/*
				 * Generates the Alarm Running UI which shows time left for the set
				 * program to execute
				 *  
				 */
				
				RunningAlarmWindow= new RunAlarm();
				String remainTime=new String();
				
				long secondsRemaining = (model.getCal().getTimeInMillis()-Calendar.getInstance().getTimeInMillis())/1000;
	            if (secondsRemaining / 3600 < 10)
	            	remainTime = remainTime + "0";
	            remainTime = remainTime + Long.toString(secondsRemaining / 3600);
	            remainTime = remainTime + ":";
	            if (secondsRemaining / 60 % 60 < 10)
		            remainTime = remainTime + "0";
		        remainTime = remainTime + Long.toString(secondsRemaining / 60 % 60);
		        remainTime = remainTime + ":";
		        if (secondsRemaining % 60 < 10)
		            remainTime = remainTime + "0";
		        remainTime = remainTime +  Long.toString(secondsRemaining % 60);
				
				System.out.println("Time Remaining : "+remainTime);
				
				/*
				 * Update RunAlarm's UI with time left to ring the bell 
				 */
				timer2=new Timer("Label Changer",true);
				updateRunAlarmUI inst = new updateRunAlarmUI(remainTime);
				timer2.schedule(inst , 0, 1000);
				
				RunningAlarmWindow.setVisible(true);
				
				view.setVisible(false);
				
			}
		}
		
	}
}