package windows;

import event.Caisse_Event;


import main_dataBase.dataBase;
import net.proteanit.sql.DbUtils;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.awt.*;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import windows.Chat_Admin;


public class FirstCase_admin_caisse extends JFrame{
	private JFormattedTextField payed;
	public static JLabel TableLabel2 ;
	public static JLabel TableLabel3 ;
	public static JLabel TableLabel4 ;
	public static JLabel TableLabel5 ;
	public static JLabel TableLabel6 ;
	public static JLabel TableLabel7 ;
	public static JLabel TableLabel8 ;
	public static JLabel TableLabel9 ;
	public static JLabel TableLabel10;
	private JTable table;
	private int rech;
	private JTable table_1;
	public static JLabel Total;
	JLabel Reste;
	private JFormattedTextField TableId;
	dataBase bd ;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public FirstCase_admin_caisse() {
		 
		initialize();
	
	}
	    

	/**
	 * Initialize the contents of the this.
	 */
	
	private void initialize() {
		this.setBounds(300, 300, 1016, 562);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		//comment section

		
		
		

		/********************************
				instance of dataBase

			*********************************/

			bd= new dataBase();		


		/********************************
				instance of dataBase

		 *********************************/
			
			
			 System.out.println("valide");


      JPanel panel = new JPanel();
      panel.setBorder(new LineBorder(Color.DARK_GRAY, 3));
		panel.setBounds(10, 10, 357, 266);
		this.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Table ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(10, 50, 53, 30);
		lblNewLabel_1.setFont(new Font("Zilla Slab", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Payer");
		lblNewLabel_2.setFont(new Font("Zilla Slab", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 90, 59, 30);
		panel.add(lblNewLabel_2);
		
		 NumberFormat format = NumberFormat.getInstance();
		    NumberFormatter formatter = new NumberFormatter(format);
		    formatter.setValueClass(Integer.class);
		    formatter.setMinimum(0);
		    formatter.setMaximum(Integer.MAX_VALUE);
		    formatter.setAllowsInvalid(false);
		    // If you want the value to be committed on each keystroke instead of focus lost
		    formatter.setCommitsOnValidEdit(true);
		
		
		payed = new JFormattedTextField(formatter);
		payed.setBounds(87, 95, 99, 29);
		panel.add(payed);
		payed.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Reste");
		lblNewLabel_3.setFont(new Font("Zilla Slab", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 145, 63, 21);
		panel.add(lblNewLabel_3);
		
		/*JButton rechercher = new JButton("rechercher");
		rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((Integer.valueOf(TableId.getText())< '0') || (Integer.valueOf(TableId.getText()) > '9'))) {

					 rech=Integer.parseInt(TableId.getText());
				bd.recherche(rech,table_1);				}
				else
						JOptionPane.showMessageDialog(null, "Please enter a number not a word");

				
			}
		});
		rechercher.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		rechercher.setBounds(838, 310, 106, 21);
		getContentPane().add(rechercher);*/
		
		
		
	
		
		 Total = new JLabel("0");
		Total.setBounds(87, 58, 84, 22);
		panel.add(Total);
		
		 Reste= new JLabel("0");
		Reste.setBounds(87, 148, 74, 22);
		panel.add(Reste);
		
		JButton btnNewButton_3 = new JButton("Calcul");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float reste = Integer.parseInt(payed.getText()) - Integer.parseInt(Total.getText());
				Reste.setText(Float.toString(reste));
			}
		});
		btnNewButton_3.setBounds(132, 200, 85, 21);
		panel.add(btnNewButton_3);
		
		 System.out.println("echec");

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setBounds(441, 83, 365, 441);
		getContentPane().add(scrollPane_1);
		 System.out.println("echec");

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	 int selectedRow = table_1.getSelectedRow();
                 DefaultTableModel model = (DefaultTableModel)table_1.getModel();
                 TableId.setText(model.getValueAt(selectedRow, 0).toString());
                 Total.setText(model.getValueAt(selectedRow, 1).toString());

                
            }
        });
		JButton btnNewButton_1 = new JButton("Refrech");
		btnNewButton_1.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		btnNewButton_1.setSelectedIcon(new ImageIcon("C:\\Users\\user\\Desktop\\foodIMG\\BREAK100.jpg"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.UpdateTable(table_1,"clientorder");
			}

			
		});
		btnNewButton_1.setBounds(510, 34, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gestion de Stock");
		btnNewButton_2.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			GestionStock gestion = new GestionStock();
				gestion.main(null);
			}
		});
		btnNewButton_2.setBounds(628, 34, 127, 21);
		getContentPane().add(btnNewButton_2);
		
		JButton Delete = new JButton("Delete by ID");
		Delete.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				bd.delete(Integer.parseInt(TableId.getText()),"clientorder");}
		
		});
		
		Delete.setBounds(838, 205, 106, 21);
		getContentPane().add(Delete);
		
		JButton DeleteAll = new JButton("Delete All");
		DeleteAll.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		DeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = 1 ; 
				while(i <25) {
				bd.delete(i,"clientorder");
				i++;}
			}
		});
		DeleteAll.setBounds(838, 257, 106, 21);
		getContentPane().add(DeleteAll);
		
		TableId = new JFormattedTextField(formatter);
		TableId.setForeground(Color.RED);
		TableId.setBounds(838, 147, 106, 19);
		getContentPane().add(TableId);
		TableId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-15, 0, 1017, 548);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\foodIMG\\back.jpg"));

		getContentPane().add(lblNewLabel);
		
		
		
		
		
	


	}
}
