package org.peedna.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.Toolkit;

public class AlarmWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	private JPanel subPanel_2;
	
	private JCheckBox chckbxSnooze;
	private JComboBox selectAlarmTime;
	private JComboBox selectPeriodicity;
	private JComboBox comboBoxSnooze;
	private JCheckBox chckbxPlayFile;
	private JCheckBox chckbxDisplayMessage;
	private JCheckBox chckbxSunday;
	private JCheckBox chckbxMonday;
	private JCheckBox chckbxTuesday;
	private JCheckBox chckbxWednesday;
	private JCheckBox chckbxThursday;
	private JCheckBox chckbxFriday;
	private JCheckBox chckbxSaturday;
	private JTextArea MessageBox;
	private JButton btnBrowse;
	private JButton btnBrowse_1;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField txtFilePath;
	private JTextField txtAppPath;
	private JSpinner spinHour;
	private JSpinner spinMinute;
	private JLabel lblAlarmType;
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
			            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        } catch (UnsupportedLookAndFeelException e) {
			            e.printStackTrace();
			        } catch (IllegalAccessException e) {
			            e.printStackTrace();
			        } catch (InstantiationException e) {
			            e.printStackTrace();
			        } catch (ClassNotFoundException e) {
			            e.printStackTrace();
			        }
			        AlarmWindow frame = new AlarmWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * createGui - Creates the frame.
	 */
	public AlarmWindow() {
		createGui();
		pack();
	}
	public void createGui(){
		setTitle("Alarm Clock v0.1");
		try{
			setIconImage(Toolkit.getDefaultToolkit().getImage(AlarmWindow.class.getResource("/res/Alarm Clock.png")));
		}
		catch(NullPointerException e){
			System.err.print("No image found");
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(420,480));
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		JPanel Panel_1 = new JPanel();
		Panel_1.setBorder(new TitledBorder(null, "Alarm Time", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		contentPane.add(Panel_1);
		
		setSelectAlarmTime(new JComboBox());
		getSelectAlarmTime().setModel(new DefaultComboBoxModel(new String[] {"Manual", "10 min later", "20 min later", "30 min later", "1 hour later"}));
		
		spinHour = new JSpinner();
		spinHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		
		spinMinute = new JSpinner();
		spinMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPeridocity = new JLabel("Periodicity : ");
		
		setSelectPeriodicity(new JComboBox());
		getSelectPeriodicity().setModel(new DefaultComboBoxModel(new String[] {"Once", "Select Manually", "Weekends(Sat and Sun)", "Weekdays(Mon to Fri)"}));
		
		subPanel_2 = new JPanel();
		subPanel_2.setBorder(null);
		subPanel_2.setLayout(new GridLayout(2,0));
		
		chckbxSunday = new JCheckBox("Sunday");
		subPanel_2.add(chckbxSunday);
		
		chckbxMonday = new JCheckBox("Monday");
		subPanel_2.add(chckbxMonday);
		
		chckbxTuesday = new JCheckBox("Tuesday");
		subPanel_2.add(chckbxTuesday);
		
		chckbxWednesday = new JCheckBox("Wednesday");
		subPanel_2.add(chckbxWednesday);
		
		chckbxThursday = new JCheckBox("Thursday");
		subPanel_2.add(chckbxThursday);
		
		chckbxFriday = new JCheckBox("Friday");
		subPanel_2.add(chckbxFriday);
		
		chckbxSaturday = new JCheckBox("Saturday");
		subPanel_2.add(chckbxSaturday);
		
		JLabel lblAlarmTime = new JLabel("Alarm Time : ");
		
		setChckbxSnooze(new JCheckBox("Snooze : "));
		
		comboBoxSnooze = new JComboBox();
		comboBoxSnooze.setEditable(true);
		comboBoxSnooze.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JLabel lblMin = new JLabel("min");
		
		lblAlarmType = new JLabel("Alarm Type");
		
		setChckbxPlayFile(new JCheckBox("Play File"));
		
		setChckbxDisplayMessage(new JCheckBox("Display Message"));
		
		JLabel lblRunFile = new JLabel("Run File");
		
		txtFilePath = new JTextField();
		txtFilePath.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		
		JLabel lblRunWith = new JLabel("Run With");
		
		txtAppPath = new JTextField();
		txtAppPath.setColumns(10);
		
		btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.setActionCommand("Browse_1");
		
		JLabel lblMessage = new JLabel("Message to be displayed");
		
		MessageBox = new JTextArea();
		MessageBox.setText("Enter Message Here");
		
		btnSave = new JButton("Save");
		btnSave.setActionCommand("Save");
		
		btnCancel = new JButton("Cancel");
		btnCancel.setActionCommand("Cancel");
		
		
		GroupLayout gl_Panel_1 = new GroupLayout(Panel_1);
		gl_Panel_1.setHorizontalGroup(
			gl_Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_1.createSequentialGroup()
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel))
						.addGroup(gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAlarmTime)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectAlarmTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
							.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHour))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(spinMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMinute))
							.addGap(49))
						.addGroup(gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(chckbxSnooze)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxSnooze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMin))
						.addGroup(gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Panel_1.createSequentialGroup()
									.addComponent(lblRunFile)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtFilePath, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
								.addGroup(gl_Panel_1.createSequentialGroup()
									.addComponent(lblRunWith)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAppPath, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBrowse)
								.addComponent(btnBrowse_1)))
						//.addComponent(subPanel_2, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
						.addGroup(gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAlarmType)
							.addGap(18)
							.addComponent(chckbxPlayFile)
							.addGap(18)
							.addComponent(chckbxDisplayMessage))
						.addGroup(gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPeridocity)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectPeriodicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMessage)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MessageBox, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Panel_1.setVerticalGroup(
			gl_Panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Panel_1.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHour)
						.addComponent(lblMinute))
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlarmTime)
						.addComponent(selectAlarmTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeridocity)
						.addComponent(selectPeriodicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					/*.addComponent(subPanel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)*/
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxSnooze)
						.addComponent(comboBoxSnooze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlarmType)
						.addComponent(chckbxPlayFile)
						.addComponent(chckbxDisplayMessage))
					.addGap(14)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRunFile)
						.addComponent(txtFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse))
					.addGap(18)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRunWith)
						.addComponent(txtAppPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(MessageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMessage))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSave))
					.addContainerGap())
		);
		gl_Panel_1.setAutoCreateGaps(true);
		gl_Panel_1.setAutoCreateContainerGaps(true);
		Panel_1.setLayout(gl_Panel_1);
	}
	
	public int getComboBoxSnooze() {
		return Integer.parseInt((String) comboBoxSnooze.getModel().getSelectedItem());
	}

	public void setComboBoxSnooze(Object snoozeValue) {
		this.comboBoxSnooze.getModel().setSelectedItem(snoozeValue);
	}

	public int getSpinHour() {
		//System.out.println("Current hour is"+(String) spinHour.getValue());
		return Integer.parseInt(this.spinHour.getModel().getValue().toString());
	}

	public void setSpinHour(Object Hour) {
		this.spinHour.setValue(Hour);
	}

	public int getSpinMinute() {
		return Integer.parseInt(this.spinMinute.getModel().getValue().toString());
	}

	public void setSpinMinute(Object Minute) {
		this.spinMinute.setValue(Minute);
	}

	/*public int getSpinSecond() {
		return Integer.parseInt((String)spinSecond.getModel().getValue().toString());
	}

	public void setSpinSecond(Object Second) {
		this.spinSecond.setValue(Second);
	}*/

	public void setListener(ActionListener  action){
		btnBrowse.addActionListener(action);
		btnBrowse_1.addActionListener(action);
		btnCancel.addActionListener(action);
	}
	
	public void setItemListener(ItemListener arg0) {
		getChckbxPlayFile().addItemListener(arg0);
		getChckbxDisplayMessage().addItemListener(arg0);	
		getChckbxSnooze().addItemListener(arg0);
	}

	public void setTextofPlayFile(String path) {
		txtFilePath.setText(path);
	}
	
	public String getTextofPlayFile(){
		return txtFilePath.getText();
	}
	
	public void setTextofApp(String path) {
		txtAppPath.setText(path);
	}
	
	public String getTextofApp(){
		return txtAppPath.getText();
	}
	
	public void setMessage(String msg){
		MessageBox.setText(msg);
	}
	
	public String getMessage(){
		return MessageBox.getText() ;
	}
	
	/*
	 * Enables the Checkboxes to set the days on which
	 * this Alarm must be activated
	 */
	public void setDaysPanel(boolean x){
		this.chckbxSunday.setEnabled(x);
		this.chckbxMonday.setEnabled(x);
		this.chckbxTuesday.setEnabled(x);
		this.chckbxWednesday.setEnabled(x);
		this.chckbxThursday.setEnabled(x);
		this.chckbxFriday.setEnabled(x);
		this.chckbxSaturday.setEnabled(x);
	}
	/*
	 * This is used to check the Selected state of the corresponding button
	 * This function is called in Eventlistener of Save
	 */
	public boolean[] getStateofDays(){
		boolean days[]=new boolean[7];
		days[0]=this.chckbxSunday.isSelected();
		days[1]=this.chckbxMonday.isSelected();
		days[2]=this.chckbxTuesday.isSelected();
		days[3]=this.chckbxWednesday.isSelected();
		days[4]=this.chckbxThursday.isSelected();
		days[5]=this.chckbxFriday.isSelected();
		days[6]=this.chckbxSaturday.isSelected();
		return days;
	}
	public void setPlaySound(boolean x){
		this.txtFilePath.setEditable(x);
		this.txtAppPath.setEditable(x);
		this.btnBrowse.setEnabled(x);
		this.btnBrowse_1.setEnabled(x);
	}
	
	public void setMessagePanel(boolean x){
		this.MessageBox.setEnabled(x);
	}

	/**
	 * @param chckbxPlayFile the chckbxPlayFile to set
	 */
	public void setChckbxPlayFile(JCheckBox chckbxPlayFile) {
		this.chckbxPlayFile = chckbxPlayFile;
	}

	public void setEnableSnoozeTime(boolean b) {
		this.comboBoxSnooze.setEnabled(b);
		this.comboBoxSnooze.setEditable(b);
	}

	public void setTimePanel(boolean b) {
		this.spinHour.setEnabled(b);
		this.spinMinute.setEnabled(b);
		//this.spinSecond.setEnabled(b);
	}

	/**
	 * @return the chckbxPlayFile
	 */
	public JCheckBox getChckbxPlayFile() {
		return chckbxPlayFile;
	}

	/**
	 * @param chckbxDisplayMessage the chckbxDisplayMessage to set
	 */
	public void setChckbxDisplayMessage(JCheckBox chckbxDisplayMessage) {
		this.chckbxDisplayMessage = chckbxDisplayMessage;
	}

	/**
	 * @return the chckbxDisplayMessage
	 */
	public JCheckBox getChckbxDisplayMessage() {
		return chckbxDisplayMessage;
	}

	/**
	 * @param chckbxSnooze the chckbxSnooze to set
	 */
	public void setChckbxSnooze(JCheckBox chckbxSnooze) {
		this.chckbxSnooze = chckbxSnooze;
	}

	/**
	 * @return the chckbxSnooze
	 */
	public JCheckBox getChckbxSnooze() {
		return chckbxSnooze;
	}

	/**
	 * @param selectPeriodicity the recurrence of Alarm to set
	 */
	public void setSelectPeriodicity(JComboBox selectPeriodicity) {
		this.selectPeriodicity = selectPeriodicity;
	}

	/**
	 * @return the selectPeriodicity
	 */
	public JComboBox getSelectPeriodicity() {
		return selectPeriodicity;
	}

	public void setItemListenertoSelectPeriodicity(ActionListener arg0) {
		getSelectPeriodicity().addActionListener(arg0);
	}

	public void setActionListenertoSelectAlarmTime(ActionListener arg0) {
		getSelectAlarmTime().addActionListener(arg0);
	}

	/**
	 * @param selectAlarmTime the AlarmTime type to set
	 */
	public void setSelectAlarmTime(JComboBox selectAlarmTime) {
		this.selectAlarmTime = selectAlarmTime;
	}

	/**
	 * @return the selectAlarmTime
	 */
	public JComboBox getSelectAlarmTime() {
		return selectAlarmTime;
	}
	
	public void setActionListenertoSave(ActionListener arg0) {
		btnSave.addActionListener(arg0);
	}

	public boolean isSnoozeSelected() {
		return getChckbxSnooze().isSelected();
	}
	public boolean getStateofSnooze() {
		return chckbxSnooze.isSelected();
	}
}