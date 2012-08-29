package org.peedna.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.border.EtchedBorder;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;

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
	private JSpinner spinSecond;
	
	
	public static void main(String[] args) {
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
	}

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
		//setBounds(200,275, 0, 0);
		setMinimumSize(new Dimension(400,475));
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		JPanel Panel_1 = new JPanel();
		Panel_1.setBorder(new TitledBorder(null, "Alarm Time", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		contentPane.add(Panel_1);
		
		setSelectAlarmTime(new JComboBox());
		getSelectAlarmTime().setModel(new DefaultComboBoxModel(new String[] {"Manual", "10 min later", "20 min later", "30 min later", "45 min later", "1 hour later"}));
		
		spinHour = new JSpinner();
		spinHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		
		spinMinute = new JSpinner();
		spinMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		spinSecond = new JSpinner();
		spinSecond.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSecond = new JLabel("Second");
		lblSecond.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		GroupLayout gl_Panel_1 = new GroupLayout(Panel_1);
		gl_Panel_1.setAutoCreateGaps(true);
		gl_Panel_1.setHorizontalGroup(
			gl_Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Panel_1.createSequentialGroup()
					.addComponent(getSelectAlarmTime(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHour))
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMinute)
						.addComponent(spinMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(spinSecond, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSecond))
					.addContainerGap())
		);
		gl_Panel_1.setVerticalGroup(
			gl_Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_1.createSequentialGroup()
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMinute)
						.addComponent(lblSecond)
						.addComponent(lblHour)
						.addComponent(getSelectAlarmTime(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinSecond, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					)
		);
		gl_Panel_1.setAutoCreateContainerGaps(true);
		Panel_1.setLayout(gl_Panel_1);
		
		JPanel Panel_2 = new JPanel();
		Panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(Panel_2);
		
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
		
		setChckbxSnooze(new JCheckBox("Snooze : "));
		
		comboBoxSnooze = new JComboBox();
		comboBoxSnooze.setEditable(true);
		comboBoxSnooze.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JLabel lblMin = new JLabel("min");
		GroupLayout gl_Panel_2 = new GroupLayout(Panel_2);
		gl_Panel_2.setHorizontalGroup(
			gl_Panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_2.createSequentialGroup()
					.addGroup(gl_Panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(subPanel_2, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
						.addGroup(gl_Panel_2.createSequentialGroup()
							.addComponent(lblPeridocity)
							.addComponent(selectPeriodicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_2.createSequentialGroup()
							.addComponent(chckbxSnooze)
							.addComponent(comboBoxSnooze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMin)))
					.addContainerGap())
		);
		gl_Panel_2.setVerticalGroup(
			gl_Panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_2.createSequentialGroup()
					.addGroup(gl_Panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeridocity)
						.addComponent(selectPeriodicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addComponent(subPanel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_Panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxSnooze)
						.addComponent(comboBoxSnooze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMin)))
		);
		gl_Panel_2.setAutoCreateContainerGaps(true);
		gl_Panel_2.setAutoCreateGaps(true);
		Panel_2.setLayout(gl_Panel_2);
		
		JPanel Panel_3 = new JPanel();
		Panel_3.setBorder(new TitledBorder(null, "Alarm Type", TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, null));
		contentPane.add(Panel_3);
		
		setChckbxPlayFile(new JCheckBox("Play File"));
		
		setChckbxDisplayMessage(new JCheckBox("Display Message"));
		
		JLabel label = new JLabel("");
		
		JLabel lblRunFile = new JLabel("Run File");
		
		txtFilePath = new JTextField();
		txtFilePath.setColumns(10);
		
		JLabel lblRunWith = new JLabel("Run With");
		
		txtAppPath = new JTextField();
		txtAppPath.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message to be displayed");
		
		MessageBox = new JTextArea();
		MessageBox.setText("Enter Message Here");
		
		btnBrowse = new JButton("Browse");
		
		btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.setActionCommand("Browse_1");
		GroupLayout gl_Panel_3 = new GroupLayout(Panel_3);
		gl_Panel_3.setHorizontalGroup(
				gl_Panel_3.createSequentialGroup()
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Panel_3.createSequentialGroup()
							.addGroup(gl_Panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxPlayFile)
								.addComponent(lblRunFile))
							.addGroup(gl_Panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(label, Alignment.TRAILING)
								.addGroup(Alignment.TRAILING, gl_Panel_3.createSequentialGroup()
									.addGroup(gl_Panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(txtAppPath, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
										.addComponent(txtFilePath, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
									.addGroup(gl_Panel_3.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnBrowse)
										.addComponent(btnBrowse_1)))
								.addGroup(gl_Panel_3.createSequentialGroup()
									.addComponent(chckbxDisplayMessage))))
						.addComponent(lblRunWith)
						.addGroup(gl_Panel_3.createSequentialGroup()
							.addComponent(lblMessage)
							.addComponent(MessageBox, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)))
					);
		gl_Panel_3.setVerticalGroup(
			gl_Panel_3.createSequentialGroup()
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxPlayFile)
						.addComponent(label)
						.addComponent(chckbxDisplayMessage))
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRunFile)
						.addComponent(txtFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse))
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRunWith)
						.addComponent(txtAppPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse_1))
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMessage)
						.addComponent(MessageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						);
		gl_Panel_3.setAutoCreateGaps(true);
		gl_Panel_3.setAutoCreateContainerGaps(true);
		Panel_3.setLayout(gl_Panel_3);
		
		JPanel Panel_4 = new JPanel();
		Panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.add(Panel_4);
		FlowLayout fl_Panel_4 = new FlowLayout(FlowLayout.RIGHT);
		Panel_4.setLayout(fl_Panel_4);
		
		btnSave = new JButton("Save");
		btnSave.setActionCommand("Save");
		Panel_4.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setActionCommand("Cancel");
		Panel_4.add(btnCancel);
	}
	
	public void setListener(ActionListener  action){
		btnBrowse.addActionListener(action);
		btnBrowse_1.addActionListener(action);
		//btnSave.addActionListener(action);
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
		this.spinSecond.setEnabled(b);
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
	
}