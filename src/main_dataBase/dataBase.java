package main_dataBase;

import javax.swing.*;

import windows.FirstCase_admin_caisse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


public class dataBase {
	//initilisation of ma3oun el 5edma 
	Connection connex = null ;
	ResultSet resultat = null ;
	PreparedStatement prepared = null ;
	//main
	JTable table;
	
	//connection to data base
	
	public static Connection ConnectDataBase()
	{		   
		try {
			  Class.forName("com.mysql.jdbc.Driver");
	           //get a connection to database
	           Connection connex=DriverManager.getConnection("jdbc:mysql://localhost:3307/resto","root","");
	        
	           return connex;
		} catch (Exception e) {
			 System.out.println("echec");
			return null;
		}
		}
	
	
	
	
	
	
	
	
	
	
	
	// the selection from the data base with a specific table name 
	
public void select(String tableName,int table) {
		System.out.print(table);

		String sql = "select TotalPrice from"+" " + tableName;
	try {			 

			connex = ConnectDataBase();
			

			prepared = connex.prepareStatement(sql);
			resultat = prepared.executeQuery();
		//System.out.print(table);
				switch(table) {
					case 1 : 
						resultat.next() ;
						float u1= resultat.getInt("TotalPrice");
						//FirstCase_admin_caisse.TableLabel1().setText(Float.toString(u1));
				break;
					case 2 : 
				resultat.next() ;
				float u2= resultat.getInt("TotalPrice");
				//FirstCase_admin_caisse.TableLabel2().setText(Float.toString(u2));
				break;
				
				
			}
		
		}
		catch(SQLException e) 
		{throw new RuntimeException("Cannot connect to database", e);
		}}	



public String selectFoodName(int id) {

	String sql = "select Food from menu where id="+ id ;
try {
		connex = ConnectDataBase();
		prepared = connex.prepareStatement(sql);
		resultat = prepared.executeQuery();
			
					resultat.next() ;
					String u1= resultat.getString("Food");
					return u1 ; 
			
		}
	
	
	catch(SQLException e) 
	{throw new RuntimeException("Cannot connect to database", e);
	}}	

public int selectUnitPrice(int id) {

	String sql = "select Price from menu where id="+ id ;
try {
		connex = ConnectDataBase();
		prepared = connex.prepareStatement(sql);
		resultat = prepared.executeQuery();
			
					resultat.next() ;
					int u1= resultat.getInt("Price");
					return u1 ; 
			
		}
	
	
	catch(SQLException e) 
	{throw new RuntimeException("Cannot connect to database", e);
	}}	


	// SELECT LOGIN
public void selectLogin(String login,String mdp) {
		
		String sql = "select login,mdp from login";
	try {			 

			connex = ConnectDataBase();
			prepared = connex.prepareStatement(sql);
			resultat = prepared.executeQuery();
			while(resultat.next()) {
				
				String u1= resultat.getString("login");
				String u2= resultat.getString("mdp");

				if(u1.equals(login) && u2.equals(mdp))
				{JOptionPane.showMessageDialog(null, "connection is deployed successfully");
				MainAdmin admin = new MainAdmin();
				admin.main(null);}
				else
				{JOptionPane.showMessageDialog(null, "Erreur");}
					
	}
		}
		catch(SQLException e) 
		{throw new RuntimeException("Cannot connect to database", e);
		}}	
	
	//***********the insertion of values in the data base	
public  void insert(String Food,int Price,int quantite,int IS,int AS)
	{ 
		String sql = "insert into menu (Food,price,quantite,InventoryStock,ActuelStock) values(?,?,?,?,?)";
	try {
		connex = ConnectDataBase();
		prepared = connex.prepareStatement(sql);
		prepared.setString(1,Food);
		prepared.setInt(2,Price);
		prepared.setInt(3,quantite);
		prepared.setInt(4,IS);
		prepared.setInt(5,AS);
		prepared.execute();
		System.out.print("insert Succeded");
	}
	catch(SQLException e ){
		System.out.print("insert failed");
	}
	}
	

             /**************************************
             * 
             * insert in TableOrder
             * 
             */

public  void InsertOrder(int tableId,int TableTotal)
{ 
	String sql = "insert into clientorder (TableId,TotalPrice) values(?,?)";
try {
	connex = ConnectDataBase();
	prepared = connex.prepareStatement(sql);
	prepared.setInt(1,tableId);
	prepared.setInt(2,TableTotal);
	
	prepared.execute();
	System.out.print("insert Succeded");
}
catch(SQLException e ){
	System.out.print("insert failed");
}
}

public  void InsertChef(int tableId,String FoodName,int FoodQuantite)
{ 
	String sql = "insert into chef (TableId,FoodName,FoodQuantite) values(?,?,?)";
try {
	System.out.println("********************"+FoodQuantite);
	connex = ConnectDataBase();
	prepared = connex.prepareStatement(sql);
	prepared.setInt(1,tableId);
	prepared.setString(2,FoodName);
	prepared.setInt(3,FoodQuantite);

	
	prepared.execute();
	System.out.print("insert Succeded");
}
catch(SQLException e ){
	System.out.print("insert failed");
}
}



	//****************** update from data base 
	public void update( int id,String Food,int Price,int quantite,int IS,int AS)
	{			String sql = "update menu set Food = ? , Price = ?,quantite = ?,InventoryStock = ? ,ActuelStock = ?  where id = ? ";


		try {
		connex = ConnectDataBase();
	prepared = connex.prepareStatement(sql);
	
	prepared.setString(1,Food);
	prepared.setInt(2,Price);
	prepared.setInt(3,quantite);
	prepared.setInt(4,IS);
	prepared.setInt(5,AS);
	prepared.setInt(6,id);
	prepared.execute();
	JOptionPane.showMessageDialog(null, "Update succeded");}
	catch(SQLException e ){
		JOptionPane.showMessageDialog(null, "Update Failed");	
		e.printStackTrace();
	}
	}
	
	
//updating the table and affichage of values
	
	
	public void UpdateTable(JTable table,String TableName) {
		
		String sql = "SELECT * FROM "+TableName;
		
		try {
			connex = ConnectDataBase();
			prepared = connex.prepareStatement(sql);
			resultat = prepared.executeQuery();
		
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
	
	
	
	
	
	public void recherche(int a, JTable table) {
		String sql = "select * from clientorder where TableId= ? " ;

		try {  
			
				connex = ConnectDataBase();
			prepared = connex.prepareStatement(sql);
			prepared.setInt(1, a);
 		resultat = prepared.executeQuery();

 					System.out.println(resultat.getInt("TableId"));
 					table.setModel(DbUtils.resultSetToTableModel(resultat));

			}catch(Exception ee) {
				ee.printStackTrace();

				JOptionPane.showConfirmDialog(null,"erreur de systeme","Erreur",JOptionPane.PLAIN_MESSAGE);	
			}
		
	}
	
	// *******************delete from data base 
	
	public void delete(int id,String TableName)
	{			String sql = "delete from"+" "+TableName +" "+"where TableId = ? ";

		try {
		connex = ConnectDataBase();
	prepared = connex.prepareStatement(sql);
	prepared.setInt(1, id);
	prepared.execute();
	System.out.print("delete Succeded");}
	catch(SQLException e ){
		System.out.print("delete failed");
		e.printStackTrace();
	}
	}
	
	
}


