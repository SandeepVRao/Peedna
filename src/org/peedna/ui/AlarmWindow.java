package org.peedna.ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

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

public class AlarmWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	public JTextField txtFilePath;
	public JTextField txtAppPath;
	public JButton btnBrowse;
	public JButton btnBrowse_1;
	JFileChooser jfc= new JFileChooser("C:/Program Files");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*try {
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
			        }*/
			        AlarmWindow frame = new AlarmWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlarmWindow() {
		createGui();
	}
	public void createGui(){
		setTitle("Alarm Clock v0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 465);
		setMinimumSize(new Dimension(400,465));
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel Panel_1 = new JPanel();
		Panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(Panel_1);
		
		JLabel lblAlarmTime = new JLabel("Alarm Time");
		lblAlarmTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox selectAlarmTime = new JComboBox();
		lblAlarmTime.setLabelFor(selectAlarmTime);
		selectAlarmTime.setModel(new DefaultComboBoxModel(new String[] {"Manual", "10 min later", "20 min later", "30 min later", "45 min later", "1 hour later"}));
		
		JSpinner spinHour = new JSpinner();
		spinHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		
		JSpinner spinMinute = new JSpinner();
		spinMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JSpinner spinSecond = new JSpinner();
		spinSecond.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSecond = new JLabel("Second");
		lblSecond.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		GroupLayout groupLayout_Panel_1 = new GroupLayout(Panel_1);
		groupLayout_Panel_1.setHorizontalGroup(
			groupLayout_Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_Panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAlarmTime)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(selectAlarmTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(groupLayout_Panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHour))
					.addGap(18)
					.addGroup(groupLayout_Panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMinute)
						.addComponent(spinMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout_Panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(spinSecond, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSecond))
					.addContainerGap())
		);
		groupLayout_Panel_1.setVerticalGroup(
			groupLayout_Panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_Panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlarmTime)
						.addComponent(lblMinute)
						.addComponent(lblSecond)
						.addComponent(selectAlarmTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHour))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout_Panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinSecond, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinMinute, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		//groupLayout_Panel_1.setAutoCreateGaps(true);
		groupLayout_Panel_1.setAutoCreateContainerGaps(true);
		Panel_1.setLayout(groupLayout_Panel_1);
		
		JPanel Panel_2 = new JPanel();
		Panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(Panel_2);
		
		JLabel lblPeridocity = new JLabel("Periodicity : ");
		
		JComboBox selectPeriodicity = new JComboBox();
		selectPeriodicity.setModel(new DefaultComboBoxModel(new String[] {"Once", "Select Manually", "Weekends(Sat and Sun)", "Weekdays(Mon to Fri)"}));
		
		JPanel subPanel_2 = new JPanel();
		subPanel_2.setBorder(null);
		subPanel_2.setLayout(new GridLayout(2,0));
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		subPanel_2.add(chckbxSunday);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		subPanel_2.add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		subPanel_2.add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		subPanel_2.add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		subPanel_2.add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		subPanel_2.add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		subPanel_2.add(chckbxSaturday);
		
		JCheckBox chckbxSnooze = new JCheckBox("Snooze : ");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setEditable(true);
		GroupLayout gl_Panel_2 = new GroupLayout(Panel_2);
		gl_Panel_2.setHorizontalGroup(
			gl_Panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(subPanel_2, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addGroup(gl_Panel_2.createSequentialGroup()
							.addComponent(lblPeridocity)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selectPeriodicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Panel_2.createSequentialGroup()
							.addComponent(chckbxSnooze)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_Panel_2.setVerticalGroup(
			gl_Panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_Panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeridocity)
						.addComponent(selectPeriodicity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(subPanel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxSnooze)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2))
		);
		Panel_2.setLayout(gl_Panel_2);
		
		JPanel Panel_3 = new JPanel();
		Panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(Panel_3);
		
		JButton btnCancel = new JButton("Cancel");
		
		JButton btnSave = new JButton("Save");
		
		JLabel lblAlarmType = new JLabel("Alarm Type");
		
		JCheckBox chckbxPlaySound = new JCheckBox("Play Sound");
		
		JCheckBox chckbxDisplayMessage = new JCheckBox("Display Message");
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_Panel_3 = new GroupLayout(Panel_3);
		gl_Panel_3.setHorizontalGroup(
			gl_Panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_Panel_3.createSequentialGroup()
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
							.addComponent(btnCancel))
						.addGroup(Alignment.LEADING, gl_Panel_3.createSequentialGroup()
							.addComponent(lblAlarmType)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxPlaySound)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxDisplayMessage)))
					.addContainerGap())
		);
		gl_Panel_3.setVerticalGroup(
			gl_Panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlarmType)
						.addComponent(chckbxPlaySound)
						.addComponent(chckbxDisplayMessage))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSave)))
		);
		
		JLabel lblMessage = new JLabel("Message to be displayed");
		
		JTextArea txtrEnterMessageHere = new JTextArea();
		txtrEnterMessageHere.setText("Enter Message Here");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMessage)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtrEnterMessageHere, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMessage)
						.addComponent(txtrEnterMessageHere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblPlayFile = new JLabel("Play File");
		
		txtFilePath = new JTextField();
		txtFilePath.setColumns(20);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setActionCommand("Browse");
		
		JLabel lblApplication = new JLabel("Application");
		
		txtAppPath = new JTextField();
		txtAppPath.setColumns(18);
		
		btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.setActionCommand("Browse_1");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPlayFile)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFilePath, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBrowse))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblApplication)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtAppPath, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBrowse_1)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlayFile)
						.addComponent(txtFilePath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApplication)
						.addComponent(txtAppPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBrowse_1))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		Panel_3.setLayout(gl_Panel_3);
	}
	/*public void actionPerformed(ActionEvent e){
		if("Browse".equals(e.getActionCommand())){
			int returnVal = jfc.showOpenDialog(AlarmWindow.this);
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = jfc.getSelectedFile();
		            AlarmWindow.this.txtFilePath.setText(file.getAbsolutePath());
			 }
	       }
	}*/
	public void setListener(ActionListener  action){
		btnBrowse.addActionListener(action);
		btnBrowse_1.addActionListener(action);
	}
	
	public void setText(String text, JTextArea txtarea){
		txtarea.setText(text);
	}
	
	public String getText(JTextArea txtarea){
		return txtarea.getText();
	}
	
}

