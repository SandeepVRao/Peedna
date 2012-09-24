/**
 * 
 */
package org.peedna.model;

import java.util.Calendar;

/**
 * @author Sandeep
 * 
 */
public class Model {

	private int SelectedAlarmMode;
	private Calendar setCalendar;
	private Calendar currentCalendar;
	private int SelectedRecurrence;
	private int SnoozeTime;
	private String PlayFilePath;
	private String AppPath;
	private String Message;
	private boolean selectedPlayFile;
	private boolean selectedMessage;
	private boolean selectedSnooze;
	private boolean SelectedDays[];
	
	
	/**
	 * @param selectedAlarmMode the selectedAlarmMode to set
	 */
	public void setSelectedAlarmMode(int selectedAlarmMode) {
		SelectedAlarmMode = selectedAlarmMode;
	}
	/**
	 * @return the selectedAlarmMode
	 */
	public int getSelectedAlarmMode() {
		return SelectedAlarmMode;
	}
	/**
	 * @param currentCalendar the currentCalendar to set
	 */
	public void setCurrentCalendar() {
		currentCalendar = Calendar.getInstance();
	}
	/**
	 * @return the currentCalendar
	 */
	public Calendar getCurrentCalendar() {
		return currentCalendar;
	}
	/**
	 * @param cal the cal to set
	 */
	public void setCal(Calendar cal) {
		setCalendar = cal;
	}
	/**
	 * @return the cal
	 */
	public Calendar getCal() {
		return setCalendar;
	}
	/**
	 * @param selectedRecurrence the selectedRecurrence to set
	 */
	public void setSelectedRecurrence(int selectedRecurrence) {
		SelectedRecurrence = selectedRecurrence;
	}
	/**
	 * @return the selectedRecurrence
	 */
	public int getSelectedRecurrence() {
		return SelectedRecurrence;
	}
	
	/**
	 * @param boolean array
	 */
	public void SetSelectedDays(boolean days[]){
		SelectedDays=days;
	}
	
	/**
	 * @return Selected Days Array
	 */
	public boolean[] getSelectedDays(){
		return SelectedDays;
	}
		
	/**
	 * @param snoozeTime the snoozeTime to set
	 */
	public void setSnoozeTime(int snoozeTime) {
		SnoozeTime = snoozeTime;
	}
	/**
	 * @return the snoozeTime
	 */
	public int getSnoozeTime() {
		return SnoozeTime;
	}
	/**
	 * @param playFile the playFile to set
	 */
	public void setPlayFile(String playFile) {
		PlayFilePath = playFile;
	}
	/**
	 * @return the playFile
	 */
	public String getPlayFile() {
		return PlayFilePath;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}
	/**
	 * @param appPath the appPath to set
	 */
	public void setApp(String appPath) {
		AppPath = appPath;
	}
	/**
	 * @return the appPath
	 */
	public String getApp() {
		return AppPath;
	}
	public void setSnoozeSelected(boolean snoozeState) {
		selectedSnooze=snoozeState;
	}
	public boolean isSnoozeSelected() {
		return selectedSnooze;
	}
	public void setPlayFileSelected(boolean selected) {
		selectedPlayFile = selected;
	}
	public boolean isPlayFileSelected(){
		return selectedPlayFile;
	}
	public void setMessageSelected(boolean selected) {
		selectedMessage=selected;
	}
	public boolean isMessageSelected(){
		return selectedMessage;
	}
	
	
	
}
