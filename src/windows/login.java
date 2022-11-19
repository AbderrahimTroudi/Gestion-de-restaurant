package windows;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JButton;
	
import main_dataBase.MainAdmin;
import main_dataBase.dataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
public class login extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestion de stock");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		  frame.addComponentListener(new java.awt.event.ComponentAdapter() {
	            @Override
	            public void componentResized(java.awt.event.ComponentEvent e) {
	                titleAlign(frame);
	            }

	        });

		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(27, 86, 99, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(27, 173, 87, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(177, 86, 133, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 170, 133, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		// image icon 
		ImageIcon image = new ImageIcon ("C:\\Users\\user\\Desktop\\IMG\\hb1.jpg");		
		frame.setIconImage(image.getImage());
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataBase check = new dataBase();
				 System.out.println("echec");

				check.selectLogin(textField.getText(),textField_1.getText());

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(195, 225, 93, 28);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\foodIMG\\log.jpg"));
		lblNewLabel_2.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(lblNewLabel_2);
		
		 
	}
	
	 private void titleAlign(JFrame frame) {

	        Font font = frame.getFont();

	        String currentTitle = frame.getTitle().trim();
	        FontMetrics fm = frame.getFontMetrics(font);
	        int frameWidth = frame.getWidth();
	        int titleWidth = fm.stringWidth(currentTitle);
	        int spaceWidth = fm.stringWidth(" ");
	        int centerPos = (frameWidth / 2) - (titleWidth / 2);
	        int spaceCount = centerPos / spaceWidth;
	        String pad = "";
	        pad = String.format("%" + (spaceCount - 14) + "s", pad);
	        frame.setTitle(pad + currentTitle);

	    }
	
}
