import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private MainRunnable mr;
	private JLabel lblHandle;
	private JTextField textField_2;


	/**
	 * Create the frame.
	 */
	public ConnectFrame(MainRunnable mr) {
		setTitle("P2PChat V0.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConnectFrame.class.getResource("/windowBuilder/resources/lightning.png")));
		this.mr = mr;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[15%][85%,grow]", "[33%][33%][33%][]"));
		
		JLabel lblIp = new JLabel("IP:");
		contentPane.add(lblIp, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblPort = new JLabel("Port #:");
		contentPane.add(lblPort, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		
		btnConnect.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				ChatWindow chatframe = new ChatWindow();
					chatframe.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		lblHandle = new JLabel("Handle:");
		contentPane.add(lblHandle, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		contentPane.add(btnConnect, "cell 1 3,grow");
		
	}
}
