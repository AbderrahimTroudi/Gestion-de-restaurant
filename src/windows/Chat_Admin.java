package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chat_Admin extends JFrame {

	private JPanel contentPane;
	static ServerSocket ss ;
	static Socket s;
	static DataInputStream din ; 
	static DataOutputStream dout ; 
	static JTextArea msg_area;
	
	private JTextField msg_text;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat_Admin frame = new Chat_Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String msgin ="";
		try {
			ss = new ServerSocket (1201);
			s = ss.accept();
			din = new DataInputStream (s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(!msgin.equals("exit")){
				msgin=din.readUTF();
				msg_area.setText(msg_area.getText().trim()+"\n client : \t"+msgin);
			}
			
		}
		catch(Exception e ) {}
		
	}

	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Chat_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("chef Chat");

		 msg_area = new JTextArea();
		msg_area.setBounds(10, 0, 426, 194);
		contentPane.add(msg_area);
		
		msg_text = new JTextField();
		msg_text.setBounds(10, 204, 304, 49);
		contentPane.add(msg_text);
		msg_text.setColumns(10);
		
		JButton msg_send = new JButton("Send");
		msg_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msgout = "";

				try {
					if (msg_text.getText().equals(".clear")) {
		                msg_area.setText("Cleared all messages\n");
		                msg_text.setText("");
		            }
					else {
					msgout = msg_text.getText().trim();
					msg_area.append( " \n"+"me :"+msg_text.getText());

					dout.writeUTF(msgout);

				} 
				}catch (Exception e2) {
				}
			}
		});
		msg_send.setBounds(310, 203, 126, 51);
		contentPane.add(msg_send);
	}
}
