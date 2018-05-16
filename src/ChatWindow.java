import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.ScrollPaneConstants;

public class ChatWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane textInputPane;
	private JScrollPane chatLogPane;
<<<<<<< HEAD
	private ConnectFrame connect;
	private String handle;
	
	
	//public ChatWindow(ConnectFrame user){
	//	connect = user;
	//	handle = connect.getHandle();
	//}
=======

>>>>>>> ab68e94684c2c6710229f268aac67db31cd32197
	
	/**
	 * Create the frame.
	 */
<<<<<<< HEAD
	public ChatWindow(Partner p) {
=======
	public ChatWindow() {
		String handle;
>>>>>>> ab68e94684c2c6710229f268aac67db31cd32197
		setTitle("P2PChat V0.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatWindow.class.getResource("/windowBuilder/resources/lightning.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[50%,grow][50%]", "[80%,grow][20%,grow]"));
		
		chatLogPane = new JScrollPane();
		chatLogPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chatLogPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(chatLogPane, "flowx,cell 0 0 2 1,grow");
		
		JTextArea chatLog = new JTextArea();
		chatLog.setEditable(false);
		//chatLog.setVisible(true);
		chatLogPane.setViewportView(chatLog);
		chatLog.setLineWrap(true);
		
		JButton sendButton = new JButton("Send");
		contentPane.add(sendButton, "cell 1 1,grow");
		
		
		textInputPane = new JScrollPane();
		textInputPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		textInputPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(textInputPane, "cell 0 1,growx");
		
		JTextArea textInput = new JTextArea();
		textInput.setVisible(true);
		textInputPane.setViewportView(textInput);
		textInput.setLineWrap(true);
		textInput.setRows(3);
		//contentPane.add(chatLog, "cell 0 0 2 1,grow");
		//contentPane.add(textInput, "cell 0 1,grow");
		
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textInput.getText() == ""){
					textInput.setText("");
					textInput.setCaretPosition(0);
<<<<<<< HEAD
				}
				else{
					try{
						chatLog.setText("Sender: " + textInput.getText());
						//chatLog.setText(handle + ": " + textInput.getText());
					}
					catch (Exception e){
						e.printStackTrace();
					}
					textInput.setText("");
					textInput.setCaretPosition(0);
				}
=======
				}
				else{
					try{
						chatLog.setText("Sender: " + textInput.getText());
						//chatLog.setText(senderName + ": " + textInput.getText());
					}
					catch (Exception e){
						e.printStackTrace();
					}
					textInput.setText("");
					textInput.setCaretPosition(0);
				}
>>>>>>> ab68e94684c2c6710229f268aac67db31cd32197
				textInput.setText("");
				textInput.setCaretPosition(0);
				//chatLog.setText(textInput.getText());
			}
		});
		
		textInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
					//chatLog.setText(textInput.getText());
				}
			}
		});
		
	}

}
