import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;


//LOOK UP HOW TO SET NIMBUS AS DEFAULT LOOK AND FEEL
public class LaunchWindow {

	private JFrame frmPpchatV;
	private MainRunnable mr;

	/**
	 * Create the application.
	 */
	public LaunchWindow(MainRunnable mr) {
		this.mr = mr;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 331, 172);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(new MigLayout("", "[25%][25%][25%][25%]", "[33%][33%][33%]"));
		
		JLabel lblPpchatV = new JLabel("");
		getFrame().getContentPane().add(lblPpchatV, "cell 0 0 4 1,alignx center");
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConnectFrame conframe = new ConnectFrame(mr);
					conframe.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		getFrame().getContentPane().add(btnConnect, "cell 0 1 2 1,grow");
		
		JButton btnSettings = new JButton("Settings");
		getFrame().getContentPane().add(btnSettings, "cell 2 1 2 1,grow");
	}

	public JFrame getFrame() {
		return frmPpchatV;
	}

	public void setFrame(JFrame frame) {
		this.frmPpchatV = frame;
		frmPpchatV.setTitle("P2PChat V0.1");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LaunchWindow.class.getResource("/windowBuilder/resources/lightning.png")));
	}

}
