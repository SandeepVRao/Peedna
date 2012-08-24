package org.peedna.main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.peedna.controller.MainController;
import org.peedna.ui.AlarmWindow;
/**
 * @author Sandeep
 *
 */
public class AlarmClock {

	private static void init(){
		AlarmWindow view = new AlarmWindow();
		view.setVisible(true);
		MainController controller = new MainController(view);
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
			        	System.out.print("Cant start the look and feel");
			            e.printStackTrace();
			        } catch (ClassNotFoundException e) {
			        	System.out.println("GetSystemlookandFeel class does not exist in this version of JDK!!");
			            e.printStackTrace();
			        }
			       init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
