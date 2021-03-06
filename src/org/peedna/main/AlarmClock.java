package org.peedna.main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.peedna.controller.MainController;
import org.peedna.model.Model;
import org.peedna.ui.AlarmWindow;
import org.peedna.ui.RunAlarm;
/**
 * @author Sandeep
 *
 */
public class AlarmClock {

	private static void init(){
		Model model=new Model();
		AlarmWindow view = new AlarmWindow();
		RunAlarm runng=new RunAlarm();
		MainController controller = new MainController(view, model, runng);
		view.setVisible(true);
		view.pack();
	}
	
	
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
			        	System.out.print("Unsupported Look and Feel");
			            e.printStackTrace();
			        } catch (IllegalAccessException e) {
			        	System.out.print("Illegal Access");
			            e.printStackTrace();
			        } catch (InstantiationException e) {
			        	System.out.print("Can't start the look and feel");
			            e.printStackTrace();
			        } catch (ClassNotFoundException e) {
			        	System.out.println("GetSystemlookandFeel class does not exist in this version of JDK!!");
			            e.printStackTrace();
			        }
			       init();
				} catch (Exception e) {
					System.out.print("Something went wrong!!");
					e.printStackTrace();
				}
			}
		});
	}

}
