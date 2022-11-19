package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import org.jdom.Content;
import org.w3c.dom.events.MouseEvent;

import main_dataBase.dataBase;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class GestionStock  {
	DefaultTableModel model;
	private JFrame frame;
	private JTable table;
	private JTextField idField;
	private JTextField prenomField;
	private JTextField nomField;
	dataBase bd	= new dataBase();
;
	private JFormattedTextField FoodId;
	private JTextField FoodName;
	private JFormattedTextField FoodPrice;
	private JFormattedTextField InventoryStock;
	private JFormattedTextField ActuelStock;
	private JFormattedTextField Quantite;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionStock window = new GestionStock();
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
	public GestionStock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("gestion de stock");
		frame.setBounds(100, 100, 1005, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 10, 470, 574);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		          
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	 int selectedRow = table.getSelectedRow();
                 DefaultTableModel model = (DefaultTableModel)table.getModel();
                 FoodId.setText(model.getValueAt(selectedRow, 0).toString());
                 FoodName.setText(model.getValueAt(selectedRow, 1).toString());
                 FoodPrice.setText(model.getValueAt(selectedRow, 2).toString());
                 Quantite.setText(model.getValueAt(selectedRow, 3).toString());
                 InventoryStock.setText(model.getValueAt(selectedRow, 4).toString());
                 ActuelStock.setText(model.getValueAt(selectedRow, 5).toString());
            }
        });

		
		
		
		JButton btnNewButtonUpdate = new JButton("update");
		btnNewButtonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				{bd.update(Integer.parseInt(FoodId.getText()),
						FoodName.getText(), 
						Integer.parseInt(FoodPrice.getText()),
						Integer.parseInt(Quantite.getText()),
						Integer.parseInt(InventoryStock.getText()),
						Integer.parseInt(ActuelStock.getText()));

				}
				}
		});
		btnNewButtonUpdate.setBounds(157, 250, 89, 23);
		frame.getContentPane().add(btnNewButtonUpdate);
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					bd.UpdateTable(table,"menu");
			}
		});
		btnNewButton.setBounds(397, 251, 85, 21);
		frame.getContentPane().add(btnNewButton);
		 NumberFormat format = NumberFormat.getInstance();
		    NumberFormatter formatter = new NumberFormatter(format);
		    formatter.setValueClass(Integer.class);
		    formatter.setMinimum(0);
		    formatter.setMaximum(Integer.MAX_VALUE);
		    formatter.setAllowsInvalid(false);
		    // If you want the value to be committed on each keystroke instead of focus lost
		    formatter.setCommitsOnValidEdit(true);
		 /*   JFormattedTextField field = new JFormattedTextField(formatter);
		    field.setBounds(340, 59, 63, 13);
			frame.getContentPane().add(field);

		    JOptionPane.showMessageDialog(null, field);

		    // getValue() always returns something valid
		    System.out.println(field.getValue());*/
		
		FoodId = new JFormattedTextField(formatter);
		FoodId.setBounds(114, 56, 96, 19);
		frame.getContentPane().add(FoodId);
		FoodId.setColumns(10);
		
		FoodName = new JTextField();
		FoodName.setBounds(114, 104, 96, 19);
		frame.getContentPane().add(FoodName);
		FoodName.setColumns(10);
		
		FoodPrice = new JFormattedTextField(formatter);
		FoodPrice.setBounds(303, 104, 96, 19);
		frame.getContentPane().add(FoodPrice);
		FoodPrice.setColumns(10);
		
		InventoryStock = new JFormattedTextField(formatter);
		InventoryStock.setBounds(114, 147, 96, 19);
		frame.getContentPane().add(InventoryStock);
		InventoryStock.setColumns(10);
		
		ActuelStock = new JFormattedTextField(formatter);
		ActuelStock.setBounds(303, 147, 96, 19);
		frame.getContentPane().add(ActuelStock);
		ActuelStock.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Food Id :");
		lblNewLabel.setBounds(10, 59, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Food Name :");
		lblNewLabel_1.setBounds(10, 107, 94, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price :");
		lblNewLabel_2.setBounds(230, 107, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Inventroy Stock :");
		lblNewLabel_3.setBounds(10, 150, 94, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Actuel Stock :");
		lblNewLabel_3_1.setBounds(230, 150, 72, 13);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JButton btnNewButton_4 = new JButton("Ajouter");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.insert(FoodName.getText(), Integer.parseInt(FoodPrice.getText()),Integer.parseInt(Quantite.getText()),Integer.parseInt(InventoryStock.getText()), Integer.parseInt(ActuelStock.getText()));
			}
		});
		btnNewButton_4.setBounds(279, 251, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((Integer.valueOf(FoodId.getText())< '0') || (Integer.valueOf(FoodId.getText()) > '9'))) {
				bd.delete(Integer.parseInt(FoodId.getText()),"menu");}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter a number not a string");
				}
			}
		});
		btnNewButton_2.setBounds(27, 251, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel quantite = new JLabel("Quantite : ");
		quantite.setBounds(230, 59, 63, 13);
		frame.getContentPane().add(quantite);
		
		Quantite = new JFormattedTextField(formatter);
		Quantite.setBounds(303, 56, 96, 19);
		frame.getContentPane().add(Quantite);
		Quantite.setColumns(10);
		
	}
}
