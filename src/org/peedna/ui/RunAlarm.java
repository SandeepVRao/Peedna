package org.peedna.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RunAlarm extends JFrame {

	private static final long serialVersionUID = -824996736600518253L;
	private JPanel contentPane;
	
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public RunAlarm() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RunAlarm.class.getResource("/res/Alarm Clock.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		label = new JLabel("00:00:00");
		label.setToolTipText("Time Remaining for Alarm to ring");
		label.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSnooze = new JButton("Snooze");
		btnSnooze.setToolTipText("Stops the running file and snoozes it to already set snooze time");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setToolTipText("Exits the Alarm Clock App");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnChangeSettings = new JButton("Change Settings");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSnooze)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnChangeSettings)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(btnCancel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSnooze)
						.addComponent(btnCancel)
						.addComponent(btnChangeSettings))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	 
	public void setTime(String time){
		 label.setText(time);
	}
	 
	/*public String getTime() {
		return label.getText();
	}*/
}
