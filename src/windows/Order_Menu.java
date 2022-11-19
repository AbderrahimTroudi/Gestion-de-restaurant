package windows;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import main_dataBase.dataBase;

public class Order_Menu extends JFrame{

	Timer timer1 = new Timer()  ;
	 

	Connection cnx=null;
	PreparedStatement prepared =null;
	ResultSet resultat =null;
	public JFrame frame;
	JCheckBox chckbxNewCheckBox;
	int foodprice=0;
	JLabel TotalPrice;
	dataBase db ;
	JTextPane TableId ; 
	String [] TabFood = new String [30] ;
	int [] TabQuantite = new int[100];
	int totalprice=0;
	
	 int i = -1; 
	 int j = -1 ; 
	 
	 JSpinner spinner;
	 JSpinner spinner_1;
	 JSpinner spinner_2;
	 JSpinner spinner_3;
	 JSpinner spinner_4;
	 JSpinner spinner_5;
	 JSpinner spinner_6;
	 JSpinner spinner_7;
	 JSpinner spinner_8;
	 JSpinner spinner_9;
	 JSpinner spinner_10;

	 JSpinner spinner_8_1;
	 JSpinner spinner_8_2;
	 JSpinner spinner_8_2_1;
	 JSpinner spinner_8_2_2;
	 JSpinner spinner_8_2_3;
	 JSpinner spinner_8_2_4;
	 JSpinner spinner_8_2_5;
	 JSpinner spinner_8_3;
	 JSpinner spinner_8_4;
	 JSpinner spinner_8_5;
	 JSpinner spinner_8_5_1;
	 JSpinner spinner_8_5_2;
	 JSpinner spinner_8_5_3;
	 JSpinner spinner_8_5_4;
	 JSpinner spinner_8_5_5;
	 JSpinner spinner_8_5_6;







	public Order_Menu() {
		setBounds(100, 100, 928, 553);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Your total price :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(237, 25, 125, 30);
		getContentPane().add(lblNewLabel);
		
		JOptionPane.showMessageDialog(null, "Only breakfast,Pizza and sandwitch are working because i had no time to make the other works too + check the box then set the quantity"
				+ "+ the chat is working just open the admin chat before the client chat ");
		
		
												/********************************
														instance of dataBase
		
					 							*********************************/
		
														db= new dataBase();		
		
		
												/********************************
														instance of dataBase
		
												 *********************************/
		
		
		
		JButton btnNewButton = new JButton("Confirm Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     Integer.parseInt(TableId.getText());
				     System.out.println("An integer");
				     if(TableId.getText()!="" && Integer.valueOf(TableId.getText())>=1 && Integer.valueOf(TableId.getText())<=30 ) {
							int i2 = 0 ;
					
						db.InsertOrder(Integer.valueOf(TableId.getText()),totalprice);
						
						while(i2<=20) {
							if(TabFood[i2]!=null) {
							db.InsertChef( Integer.valueOf(TableId.getText()),TabFood[i2],TabQuantite[i2]);
							i2++;}
							else {
								i2++;
							}
							
							System.out.println("도도도::도도도"+" :"+TabQuantite[i2]);
						}
						  timer1.cancel();
						  


						}
						else
									{JOptionPane.showMessageDialog(null, "Please enter you table Number entre 1 et 30");}
				
				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please enter you table Number not a word");
				}
				}});
		
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(483, 24, 154, 30);
		getContentPane().add(btnNewButton);
		
		 TotalPrice = new JLabel("0");
		TotalPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		TotalPrice.setBounds(365, 30, 108, 20);
		getContentPane().add(TotalPrice);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Breakfast");
		lblNewLabel_2.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 113, 108, 30);
		getContentPane().add(lblNewLabel_2);
		
		JLabel ImageLabel = new JLabel("New label");
		ImageLabel.setBounds(209, 103, 102, 84);
		getContentPane().add(ImageLabel);
		
		
		ImageIcon image = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\BREAK100.jpg");
	//	Image scaleImage = image.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel.setIcon(image);
		ImageLabel.setVerticalTextPosition(JLabel.TOP);
		
		  chckbxNewCheckBox = new JCheckBox("Pancakes");
		chckbxNewCheckBox.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(0, 167, 93, 20);
		chckbxNewCheckBox.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox.isSelected())
            		{
            		totalprice = totalprice + TotalPrice(1) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[0] =  db.selectFoodName(1);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[0] = (Integer) spinner.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
            	else 
        		{
            		totalprice = totalprice - TotalPrice(1) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		TabFood[0] =  null;
            		TabQuantite[0] = 0 ;
            	
            		
        		
        	}
            }    
         });
		
		getContentPane().add(chckbxNewCheckBox);
	/*int c =  0 ;
		while(c<30) {
			
		String b = "spinner_" + c;
		System.out.println(b);
		c++;
	//(JSpinner)	b.getValue();
		}*/
		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Waffles");
		chckbxNewCheckBox_1.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_1.setBounds(0, 189, 93, 21);
		
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {
            	//TotalPrice.setText((String) (e.getStateChange()==1?String.valueOf(db.selectUnitPrice(2)):String.valueOf(totalprice)));    
            	if(chckbxNewCheckBox_1.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(2) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[1] =  db.selectFoodName(2);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[1] = (Integer) spinner_1.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(2) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[1] =  null;
        		TabQuantite[1] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_1);
		
		final JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Croissant");
		chckbxNewCheckBox_2.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_2.setBounds(0, 212, 93, 21);
		chckbxNewCheckBox_2.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_2.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(3) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[2] =  db.selectFoodName(3);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    			TabQuantite[2] = (Integer) spinner_2.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(3) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[2] =  null;
        		TabQuantite[2] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_2);
		
		final JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Donut");
		chckbxNewCheckBox_3.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_3.setBounds(0, 235, 93, 21);
		chckbxNewCheckBox_3.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_3.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(4) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[3] =  db.selectFoodName(4);
            		
            		 timer1= new Timer();

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[3] = (Integer) spinner_3.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(4) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[3] =  null;
        		TabQuantite[3] = 0 ;
        		}}
         });
		getContentPane().add(chckbxNewCheckBox_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pizza");
		lblNewLabel_2_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 279, 108, 30);
		getContentPane().add(lblNewLabel_2_1);
		
		final JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Chicken Pizza");
		chckbxNewCheckBox_4.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_4.setBounds(0, 316, 118, 20);
		chckbxNewCheckBox_4.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_4.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(5) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[4] =  db.selectFoodName(5);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[4] = (Integer) spinner_4.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(5) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[4] =  null;
        		TabQuantite[4] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_4);
		
		final JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Pineaplle Shrimp Pizza");
		chckbxNewCheckBox_5.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_5.setBounds(0, 338, 163, 20);
		chckbxNewCheckBox_5.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_5.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(6) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[5] =  db.selectFoodName(6);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[5] = (Integer) spinner_5.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(6) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[5] =  null;
        		TabQuantite[5] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_5);
		
		final JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Meat Pizza");
		chckbxNewCheckBox_6.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_6.setBounds(0, 360, 118, 20);
		chckbxNewCheckBox_6.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_6.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(7) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[6] =  db.selectFoodName(7);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[6] = (Integer) spinner_6.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(7) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[6] =  null;
        		TabQuantite[6] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_6);
		
		final JCheckBox chckbxNewCheckBox_7 = new JCheckBox("4 season pizza");
		chckbxNewCheckBox_7.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_7.setBounds(0, 382, 118, 20);
		chckbxNewCheckBox_7.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_7.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(8) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[7] =  db.selectFoodName(8);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[7] = (Integer) spinner_7.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(8) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[7] =  null;
        		TabQuantite[7] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_7);
		
		 spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1.setBounds(99, 193, 30, 20);
		getContentPane().add(spinner_1);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2.setBounds(99, 214, 30, 20);
		getContentPane().add(spinner_2);
		
		 spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_3.setBounds(99, 237, 30, 20);
		getContentPane().add(spinner_3);
		
		 spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(99, 169, 30, 20);
		getContentPane().add(spinner);
		
		 spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_4.setBounds(168, 318, 30, 20);
		getContentPane().add(spinner_4);
		
		 spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_5.setBounds(168, 340, 30, 20);
		getContentPane().add(spinner_5);
		
		 spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_6.setBounds(168, 364, 30, 20);
		getContentPane().add(spinner_6);
		
		 spinner_7 = new JSpinner();
		spinner_7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_7.setBounds(168, 384, 30, 20);
		getContentPane().add(spinner_7);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Sandwich");
		lblNewLabel_2_1_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(404, 113, 108, 30);
		getContentPane().add(lblNewLabel_2_1_1);
		
		final JCheckBox chckbxBeedSteackChesse = new JCheckBox("Beed Steack Chesse Sandwich");
		chckbxBeedSteackChesse.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxBeedSteackChesse.setBounds(400, 168, 201, 20);
		chckbxBeedSteackChesse.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxBeedSteackChesse.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(9) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[8] =  db.selectFoodName(9);
            		
            		 	timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[8] = (Integer) spinner_8.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(9) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[8] =  null;
        		TabQuantite[8] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxBeedSteackChesse);
		
		final JCheckBox chckbxChickenFiletSandwich = new JCheckBox("Chicken Filet Sandwich");
		chckbxChickenFiletSandwich.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxChickenFiletSandwich.setBounds(400, 190, 201, 20);
		chckbxChickenFiletSandwich.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxChickenFiletSandwich.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(10) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[9] =  db.selectFoodName(10);
            		

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[9] = (Integer) spinner_9.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(10) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[9] =  null;
        		TabQuantite[9] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxChickenFiletSandwich);
		
	final	JCheckBox chckbxTunaSaladSandwich = new JCheckBox("Tuna Salad Sandwich");
		chckbxTunaSaladSandwich.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxTunaSaladSandwich.setBounds(400, 213, 201, 20);
		chckbxTunaSaladSandwich.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxTunaSaladSandwich.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(28) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[27] =  db.selectFoodName(28);
            		


            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[27] = (Integer) spinner_10.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(28) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[27] =  null;
        		TabQuantite[27] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxTunaSaladSandwich);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(607, 169, 30, 20);
		getContentPane().add(spinner_8);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(607, 191, 30, 20);
		getContentPane().add(spinner_9);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(607, 214, 30, 20);
		getContentPane().add(spinner_10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Additional");
		lblNewLabel_2_1_1_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(705, 279, 108, 30);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Juice");
		lblNewLabel_2_1_1_2.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(404, 279, 108, 30);
		getContentPane().add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("Cakes");
		lblNewLabel_2_1_1_3.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1_1_3.setBounds(705, 113, 108, 30);
		getContentPane().add(lblNewLabel_2_1_1_3);
		
		final JCheckBox chckbxOrangeJuice = new JCheckBox("Orange juice");
		chckbxOrangeJuice.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxOrangeJuice.setBounds(404, 316, 138, 20);
		chckbxOrangeJuice.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxOrangeJuice.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(11) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[10] =  db.selectFoodName(11);
            		


            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[10] = (Integer) spinner_8_1.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(11) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[10] =  null;
        		TabQuantite[10] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxOrangeJuice);
		
		final JCheckBox chckbxStrawberryesJuice = new JCheckBox("Strawberries juice");
		chckbxStrawberryesJuice.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxStrawberryesJuice.setBounds(404, 338, 138, 20);
		chckbxStrawberryesJuice.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxStrawberryesJuice.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(12) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[11] =  db.selectFoodName(12);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[11] = (Integer) spinner_8_2.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(12) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[11] =  null;
        		TabQuantite[11] = 0 ;
        		}}
         });
		getContentPane().add(chckbxStrawberryesJuice);
		
		final JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Waffles");
		chckbxNewCheckBox_10.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_10.setBounds(404, 360, 93, 20);
		chckbxNewCheckBox_10.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_10.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(13) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[12] =  db.selectFoodName(13);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[12] = (Integer) spinner_8_2_1.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(13) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[12] =  null;
        		TabQuantite[12] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_10);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Soda");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2_1.setBounds(404, 387, 108, 30);
		getContentPane().add(lblNewLabel_2_1_1_2_1);
		
		final JCheckBox chckbxCocaCola = new JCheckBox("Coca Cola");
		chckbxCocaCola.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxCocaCola.setBounds(404, 423, 93, 20);
		chckbxCocaCola.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxCocaCola.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(14) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[13] =  db.selectFoodName(14);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[13] = (Integer) spinner_8_2_2.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(14) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[13] =  null;
        		TabQuantite[13] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxCocaCola);
		
		final JCheckBox chckbxSprite = new JCheckBox("Sprite");
		chckbxSprite.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxSprite.setBounds(404, 448, 93, 20);
		chckbxSprite.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxSprite.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(15) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
           TabFood[14] =  db.selectFoodName(15);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[14] = (Integer) spinner_8_2_3.getValue();
            		    }
            		 }, 0, 1000);
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(15) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[14] =  null;
        		TabQuantite[14] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxSprite);
		
		final JCheckBox chckbxFanta = new JCheckBox("Fanta");
		chckbxFanta.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxFanta.setBounds(404, 470, 93, 20);
		chckbxFanta.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxFanta.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(16) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[15] =  db.selectFoodName(16);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[15] = (Integer) spinner_8_2_4.getValue();
            		    }
            		 }, 0, 1000);
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(16) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[15] =  null;
        		TabQuantite	[15] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxFanta);
		
		final JCheckBox chckbxBouga = new JCheckBox("Bouga");
		chckbxBouga.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxBouga.setBounds(404, 490, 93, 20);
		
		chckbxBouga.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxBouga.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(17) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[16] =  db.selectFoodName(17);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[16] = (Integer) spinner_8_2_5.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(17) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[16] =  null;
        		TabQuantite[16] = 0 ;
        		}
            }    
         });
		
		getContentPane().add(chckbxBouga);
		
		JSpinner spinner_8_1 = new JSpinner();
		spinner_8_1.setBounds(549, 318, 30, 20);
		getContentPane().add(spinner_8_1);
		
		JSpinner spinner_8_2 = new JSpinner();
		spinner_8_2.setBounds(549, 340, 30, 20);
		getContentPane().add(spinner_8_2);
		
		JSpinner spinner_8_2_1 = new JSpinner();
		spinner_8_2_1.setBounds(549, 362, 30, 20);
		getContentPane().add(spinner_8_2_1);
		
		JSpinner spinner_8_2_2 = new JSpinner();
		spinner_8_2_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_8_2_2.setBounds(549, 425, 30, 20);
		getContentPane().add(spinner_8_2_2);
		
		
		
		JSpinner spinner_8_2_3 = new JSpinner();
		spinner_8_2_3.setBounds(549, 450, 30, 20);
		getContentPane().add(spinner_8_2_3);
		
		JSpinner spinner_8_2_4 = new JSpinner();
		spinner_8_2_4.setBounds(549, 472, 30, 20);
		getContentPane().add(spinner_8_2_4);
		
		JSpinner spinner_8_2_5 = new JSpinner();
		spinner_8_2_5.setBounds(549, 492, 30, 20);
		getContentPane().add(spinner_8_2_5);
		
		final JCheckBox chckbxChesseCake = new JCheckBox("Chesse Cake");
		chckbxChesseCake.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxChesseCake.setBounds(705, 163, 125, 20);
		
		chckbxChesseCake.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxChesseCake.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(18) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[17] =  db.selectFoodName(18);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[17] = (Integer) spinner_8_3.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(18) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[17] =  null;
        		TabQuantite[17] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxChesseCake);
		
		final JCheckBox chckbxC = new JCheckBox("Chocolate Cake");
		chckbxC.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxC.setBounds(705, 190, 125, 20);
		chckbxC.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxC.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(19) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[18] =  db.selectFoodName(19);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[18] = (Integer) spinner_8_4.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(19) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[18] =  null;
        		TabQuantite[18] = 0 ;
        		}
            }    
         });
		
		getContentPane().add(chckbxC);
		
		final JCheckBox chckbxCo = new JCheckBox("Cookies");
		chckbxCo.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxCo.setBounds(705, 213, 93, 20);
		chckbxCo.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxCo.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(20) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[19] =  db.selectFoodName(20);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[19] = (Integer) spinner_8_5.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(20) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[19] =  null;
        		TabQuantite[19] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxCo);
		
		JSpinner spinner_8_3 = new JSpinner();
		spinner_8_3.setBounds(828, 167, 30, 20);
		getContentPane().add(spinner_8_3);
		
		JSpinner spinner_8_4 = new JSpinner();
		spinner_8_4.setBounds(828, 191, 30, 20);
		getContentPane().add(spinner_8_4);
		
		JSpinner spinner_8_5 = new JSpinner();
		spinner_8_5.setBounds(828, 214, 30, 20);
		getContentPane().add(spinner_8_5);
		
		final JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Nutela Chocolat");
		chckbxNewCheckBox_1_1.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_1_1.setBounds(705, 317, 125, 21);
		chckbxNewCheckBox_1_1.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_1_1.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(21) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[20] =  db.selectFoodName(21);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[20] = (Integer) spinner_8_5_4.getValue();
            		    }
            		 }, 0, 1000);
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(21) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[20] =  null;
        		TabQuantite[20] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_1_1);
		
		final JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("Bread");
		chckbxNewCheckBox_1_2.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_1_2.setBounds(705, 339, 93, 21);
		chckbxNewCheckBox_1_2.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_1_2.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(22) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[21] =  db.selectFoodName(22);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[21] = (Integer) spinner_8_5_5.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(22) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[21] =  null;
        		TabQuantite[21] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_1_2);
		
	final 	JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("Butter");
		chckbxNewCheckBox_1_3.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_1_3.setBounds(705, 361, 93, 21);
		chckbxNewCheckBox_1_3.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_1_3.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(23) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[22] =  db.selectFoodName(23);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[22] = (Integer) spinner_8_5_6.getValue();
            		    }
            		 }, 0, 1000);
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(23) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[22] =  null;
        		TabQuantite[22] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(139, 174, 45, 13);
		lblNewLabel_3.setText(String.valueOf(db.selectUnitPrice(1))+" "+"DT");
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setBounds(139, 194, 45, 13);
		lblNewLabel_3_1.setText(String.valueOf(db.selectUnitPrice(2))+" "+"DT");

		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setBounds(139, 217, 45, 13);
		lblNewLabel_3_2.setText(String.valueOf(db.selectUnitPrice(3))+" "+"DT");

		getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("New label");
		lblNewLabel_3_3.setBounds(139, 240, 45, 13);
		lblNewLabel_3_3.setText(String.valueOf(db.selectUnitPrice(4))+" "+"DT");

		getContentPane().add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("New label");
		lblNewLabel_3_4.setBounds(209, 321, 45, 13);
		lblNewLabel_3_4.setText(String.valueOf(db.selectUnitPrice(5))+" "+"DT");

		getContentPane().add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("New label");
		lblNewLabel_3_5.setBounds(209, 343, 45, 13);
		lblNewLabel_3_5.setText(String.valueOf(db.selectUnitPrice(6))+" "+"DT");

		getContentPane().add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("New label");
		lblNewLabel_3_6.setBounds(209, 365, 45, 13);
		lblNewLabel_3_6.setText(String.valueOf(db.selectUnitPrice(7))+" "+"DT");

		getContentPane().add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("New label");
		lblNewLabel_3_7.setBounds(209, 387, 45, 13);
		lblNewLabel_3_7.setText(String.valueOf(db.selectUnitPrice(8))+" "+"DT");
		getContentPane().add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("New label");
		lblNewLabel_3_8.setBounds(647, 172, 45, 13);
		lblNewLabel_3_8.setText(String.valueOf(db.selectUnitPrice(9))+" "+"DT");

		getContentPane().add(lblNewLabel_3_8);
		
		JLabel lblNewLabel_3_9 = new JLabel("New label");
		lblNewLabel_3_9.setBounds(647, 194, 45, 13);
		lblNewLabel_3_9.setText(String.valueOf(db.selectUnitPrice(10))+" "+"DT");

		getContentPane().add(lblNewLabel_3_9);
		
		JLabel lblNewLabel_3_10 = new JLabel("New label");
		lblNewLabel_3_10.setBounds(647, 217, 45, 13);
		lblNewLabel_3_10.setText(String.valueOf(db.selectUnitPrice(28))+" "+"DT");

		getContentPane().add(lblNewLabel_3_10);
		
		JLabel lblNewLabel_3_11 = new JLabel("New label");
		lblNewLabel_3_11.setBounds(589, 321, 45, 13);
		lblNewLabel_3_11.setText(String.valueOf(db.selectUnitPrice(11))+" "+"DT");

		getContentPane().add(lblNewLabel_3_11);
		
		JLabel lblNewLabel_3_12 = new JLabel("New label");
		lblNewLabel_3_12.setBounds(589, 343, 45, 13);
		lblNewLabel_3_12.setText(String.valueOf(db.selectUnitPrice(12))+" "+"DT");

		getContentPane().add(lblNewLabel_3_12);
		
		JLabel lblNewLabel_3_13 = new JLabel("New label");
		lblNewLabel_3_13.setBounds(589, 365, 45, 13);		
		lblNewLabel_3_13.setText(String.valueOf(db.selectUnitPrice(13))+" "+"DT");
		getContentPane().add(lblNewLabel_3_13);
		
		JLabel lblNewLabel_3_14 = new JLabel("New label");
		lblNewLabel_3_14.setBounds(589, 428, 45, 13);
		lblNewLabel_3_14.setText(String.valueOf(db.selectUnitPrice(14))+" "+"DT");
		getContentPane().add(lblNewLabel_3_14);
		
		JLabel lblNewLabel_3_15 = new JLabel("New label");
		
		lblNewLabel_3_15.setBounds(589, 453, 45, 13);
		lblNewLabel_3_15.setText(String.valueOf(db.selectUnitPrice(15))+" "+"DT");
		getContentPane().add(lblNewLabel_3_15);
		
		JLabel lblNewLabel_3_16 = new JLabel("New label");
		lblNewLabel_3_16.setBounds(589, 475, 45, 13);
		lblNewLabel_3_16.setText(String.valueOf(db.selectUnitPrice(16))+" "+"DT");

		getContentPane().add(lblNewLabel_3_16);
		
		JLabel lblNewLabel_3_17 = new JLabel("New label");
		lblNewLabel_3_17.setBounds(589, 495, 45, 13);
		getContentPane().add(lblNewLabel_3_17);
		lblNewLabel_3_17.setText(String.valueOf(db.selectUnitPrice(17))+" "+"DT");

		
		JLabel lblNewLabel_3_18 = new JLabel("New label");
		lblNewLabel_3_18.setBounds(848, 321, 30, 13);
		lblNewLabel_3_18.setText(String.valueOf(db.selectUnitPrice(21))+" "+"DT");
		getContentPane().add(lblNewLabel_3_18);
		
		JLabel lblNewLabel_3_19 = new JLabel("New label");
		lblNewLabel_3_19.setBounds(804, 343, 45, 13);
		lblNewLabel_3_19.setText(String.valueOf(db.selectUnitPrice(22))+" "+"DT");
		getContentPane().add(lblNewLabel_3_19);
		
		JLabel lblNewLabel_3_20 = new JLabel("New label");
		lblNewLabel_3_20.setBounds(804, 365, 45, 13);
		lblNewLabel_3_20.setText(String.valueOf(db.selectUnitPrice(23))+" "+"DT");

		getContentPane().add(lblNewLabel_3_20);
		
		JLabel lblNewLabel_3_21 = new JLabel("New label");
		lblNewLabel_3_21.setBounds(859, 172, 30, 13);
		getContentPane().add(lblNewLabel_3_21);
		lblNewLabel_3_21.setText(String.valueOf(db.selectUnitPrice(18))+" "+"DT");

		JLabel lblNewLabel_3_21_1 = new JLabel("New label");
		lblNewLabel_3_21_1.setBounds(859, 194, 30, 13);
		getContentPane().add(lblNewLabel_3_21_1);
		lblNewLabel_3_21_1.setText(String.valueOf(db.selectUnitPrice(19))+" "+"DT");

		JLabel lblNewLabel_3_21_2 = new JLabel("New label");
		lblNewLabel_3_21_2.setBounds(859, 217, 30, 13);
		getContentPane().add(lblNewLabel_3_21_2);
		lblNewLabel_3_21_2.setText(String.valueOf(db.selectUnitPrice(20))+" "+"DT");

		JLabel ImageLabel_1 = new JLabel("New label");
		ImageLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		ImageLabel_1.setBounds(260, 217, 102, 101);
		getContentPane().add(ImageLabel_1);
		
		ImageIcon imagePizza = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\Pizza.jpg");
	//	Image scaleImagePizza = imagePizza.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel_1.setIcon(imagePizza);
		ImageLabel_1.setVerticalTextPosition(JLabel.TOP);
		
		JLabel ImageLabel_2 = new JLabel("New label");
		ImageLabel_2.setVerticalTextPosition(SwingConstants.TOP);
		ImageLabel_2.setBounds(522, 80, 102, 84);
		getContentPane().add(ImageLabel_2);
		
		ImageIcon ImageSandwich = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\Sandwich.jpg");
		//Image scaleImageSandwich = ImageSandwich.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel_2.setIcon(ImageSandwich);
		ImageLabel_2.setVerticalTextPosition(JLabel.TOP);
		
		JLabel ImageLabel_3 = new JLabel("New label");
		ImageLabel_3.setVerticalTextPosition(SwingConstants.TOP);
		ImageLabel_3.setBounds(483, 235, 102, 73);
		getContentPane().add(ImageLabel_3);
		
		ImageIcon ImageJuice = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\juice.jpg");
	//	Image scaleImageJuice = ImageJuice.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel_3.setIcon(ImageJuice);
		ImageLabel_3.setVerticalTextPosition(JLabel.TOP);
		
		JLabel ImageLabel_4 = new JLabel("New label");
		ImageLabel_4.setVerticalTextPosition(SwingConstants.TOP);
		ImageLabel_4.setBounds(260, 426, 102, 84);
		getContentPane().add(ImageLabel_4);
		
		ImageIcon ImageCoffee = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\coffee.jpg");
		//Image scaleImageCoffee = ImageCoffee.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel_4.setIcon(ImageCoffee);
		ImageLabel_4.setVerticalTextPosition(JLabel.TOP);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Coffee");
		lblNewLabel_2_1_2.setFont(new Font("Urdu Typesetting", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(10, 413, 108, 30);
		getContentPane().add(lblNewLabel_2_1_2);
		
		final JCheckBox chckbxAmericanExpress = new JCheckBox("American Express");
		chckbxAmericanExpress.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxAmericanExpress.setBounds(0, 449, 138, 20);
		chckbxAmericanExpress.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxAmericanExpress.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(25) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[24] =  db.selectFoodName(25);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[24] = (Integer) spinner_8_5_1.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(25) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[24] =  null;
        		TabQuantite[24] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxAmericanExpress);
		
		final JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Cream Coffee");
		chckbxNewCheckBox_9.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_9.setBounds(0, 471, 118, 20);
		chckbxNewCheckBox_9.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_9.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(26) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[25] =  db.selectFoodName(26);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[25] = (Integer) spinner_8_5_2.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(26) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[25] =  null;
        		TabQuantite[25] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_9);
		
		final JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Waffles");
		chckbxNewCheckBox_11.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_11.setBounds(0, 491, 93, 20);
		chckbxNewCheckBox_11.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_11.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(27) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[26] =  db.selectFoodName(27);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[26] = (Integer) spinner_8_5_3.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(27) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[26] =  null;
        		TabQuantite[26] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_11);
		
		JSpinner spinner_8_5_1 = new JSpinner();
		spinner_8_5_1.setBounds(139, 450, 30, 20);
		getContentPane().add(spinner_8_5_1);
		
		JSpinner spinner_8_5_2 = new JSpinner();
		spinner_8_5_2.setBounds(139, 472, 30, 20);
		getContentPane().add(spinner_8_5_2);
		
		JSpinner spinner_8_5_3 = new JSpinner();
		spinner_8_5_3.setBounds(139, 492, 30, 20);
		getContentPane().add(spinner_8_5_3);
		
		JSpinner spinner_8_5_4 = new JSpinner();
		spinner_8_5_4.setBounds(881, 318, 30, 20);
		getContentPane().add(spinner_8_5_4);
		
		JSpinner spinner_8_5_5 = new JSpinner();
		spinner_8_5_5.setBounds(859, 362, 30, 20);
		getContentPane().add(spinner_8_5_5);
		
		JSpinner spinner_8_5_6 = new JSpinner();
		spinner_8_5_6.setBounds(859, 340, 30, 20);
		getContentPane().add(spinner_8_5_6);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("New label");
		lblNewLabel_3_4_1.setBounds(171, 453, 45, 13);
		getContentPane().add(lblNewLabel_3_4_1);
		lblNewLabel_3_4_1.setText(String.valueOf(db.selectUnitPrice(25))+" "+"DT");

		JLabel lblNewLabel_3_4_3 = new JLabel("New label");
		lblNewLabel_3_4_3.setBounds(171, 495, 45, 13);
		getContentPane().add(lblNewLabel_3_4_3);
		lblNewLabel_3_4_3.setText(String.valueOf(db.selectUnitPrice(27))+" "+"DT");

		JLabel lblNewLabel_3_4_2 = new JLabel("New label");
		lblNewLabel_3_4_2.setBounds(168, 475, 45, 13);
		getContentPane().add(lblNewLabel_3_4_2);
		lblNewLabel_3_4_2.setText(String.valueOf(db.selectUnitPrice(26))+" "+"DT");

		JLabel ImageLabel_4_1 = new JLabel("New label");
		ImageLabel_4_1.setVerticalTextPosition(SwingConstants.TOP);
		ImageLabel_4_1.setBounds(657, 402, 102, 84);
		getContentPane().add(ImageLabel_4_1);

		
		ImageIcon ImageSoda = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\Soda.jpg");
		//Image scaleImageSoda = ImageSoda.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel_4_1.setIcon(ImageSoda);
		ImageLabel_4_1.setVerticalTextPosition(JLabel.TOP);
		
		JLabel ImageLabel_4_2 = new JLabel("New label");
		ImageLabel_4_2.setVerticalTextPosition(SwingConstants.TOP);
		ImageLabel_4_2.setBounds(771, 59, 102, 84);

		getContentPane().add(ImageLabel_4_2);
		
		ImageIcon ImageCake = new ImageIcon ("C:\\Users\\user\\Desktop\\foodIMG\\Cake.jpg");
	//	Image scaleImageCake = ImageCake.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
		ImageLabel_4_2.setIcon(ImageCake);
		ImageLabel_4_2.setVerticalTextPosition(JLabel.TOP);
		
		final JCheckBox chckbxNewCheckBox_1_3_1 = new JCheckBox("Water");
		chckbxNewCheckBox_1_3_1.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		chckbxNewCheckBox_1_3_1.setBounds(705, 383, 93, 21);
		
		chckbxNewCheckBox_1_3_1.addItemListener(new ItemListener() {    

            public void itemStateChanged(ItemEvent e) {
            	if(chckbxNewCheckBox_1_3_1.isSelected())
            	{
            		totalprice = totalprice + TotalPrice(24) ;
            		TotalPrice.setText(String.valueOf(totalprice));
            		i++;
            		TabFood[23] =  db.selectFoodName(24);
            		
            		 

            		timer1.schedule( new TimerTask() {
            		    public void run() {
                    		TabQuantite[23] = (Integer) spinner.getValue();
            		    }
            		 }, 0, 1000);
            		j++;
            		}
        	else 
    		{totalprice = totalprice - TotalPrice(24) ;
        		TotalPrice.setText(String.valueOf(totalprice));
        		TabFood[23] =  null;
        		TabQuantite[23] = 0 ;
        		}
            }    
         });
		getContentPane().add(chckbxNewCheckBox_1_3_1);
		
		JLabel lblNewLabel_3_20_1 = new JLabel("New label");
		lblNewLabel_3_20_1.setBounds(804, 387, 45, 13);
		getContentPane().add(lblNewLabel_3_20_1);
		lblNewLabel_3_20_1.setText(String.valueOf(db.selectUnitPrice(24))+" "+"DT");

		
		JSpinner spinner_8_5_5_1 = new JSpinner();
		spinner_8_5_5_1.setBounds(859, 384, 30, 20);
		getContentPane().add(spinner_8_5_5_1);
		
		 TableId = new JTextPane();
		TableId.setBounds(110, 86, 74, 30);
		getContentPane().add(TableId);
		
		JLabel lblNewLabel_1 = new JLabel("Table Number :");
		lblNewLabel_1.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 90, 100, 26);
		getContentPane().add(lblNewLabel_1);
		
		
		
		
	}
	public int TotalPrice(int i )
	{int total = db.selectUnitPrice(i) ; 
	
		return total;}
	public int UnitPrice(int i )
	{int UnitPrice = db.selectUnitPrice(i) ; 
	
		return UnitPrice;}
	public String getTableId ()
	{
		return TableId.getText();
	}
}
