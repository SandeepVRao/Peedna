/**
 * 
 */
package org.peedna.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JFileChooser;

import org.peedna.ui.AlarmWindow;

/**
 * @author Sandeep
 *
 */
public class MainController implements ActionListener{

	/**
	 * @param args
	 */
	AlarmWindow view;
	JFileChooser japp=new JFileChooser("C:/Program Files/");
	JFileChooser jfile = new JFileChooser("");
	public MainController(AlarmWindow v) {
		this.view=v;
		this.addActionListenertoView(this);
	}

	public void actionPerformed(ActionEvent e){
		if("Browse".equals(e.getActionCommand())){
			int returnVal = jfile.showOpenDialog(this.view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = jfile.getSelectedFile();
		            this.view.txtFilePath.setText(file.getAbsolutePath());
			 }
	       }
		else if("Browse_1".equals(e.getActionCommand())){
			int returnVal = japp.showOpenDialog(this.view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = japp.getSelectedFile();
		            this.view.txtFilePath.setText(file.getAbsolutePath());
			 }
		}
		System.out.println(e.getActionCommand()+" was pressed");
	}
	
	public void addActionListenertoView(ActionListener arg0){
		this.view.setListener(arg0);
	}
}