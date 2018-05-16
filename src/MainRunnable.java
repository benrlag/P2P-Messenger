import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainRunnable {

	private static ChatFacade cf;
	
	public static void main(String[] args){
		//System.out.println("1");
		//http://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html
		try {
			//System.out.println("2");
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	//System.out.println("3");
		    	if ("Nimbus".equals(info.getName())) {
		    		//System.out.println("4");
		    		UIManager.setLookAndFeel(info.getClassName());
		    		//System.out.println("5");
		    		break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			//System.out.println("6");
			e.printStackTrace();
			//System.out.println("7");
		}
		
		cf = new ChatFacade();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchWindow window = new LaunchWindow(null);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//public void startChat(string ip, int port){
		
	//}
	
	
}
