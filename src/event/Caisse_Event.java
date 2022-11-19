package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main_dataBase.dataBase;
import windows.FirstCase_admin_caisse;

public class Caisse_Event implements ActionListener {
	FirstCase_admin_caisse m ;
	float resultat ;
	int table2 = 0;
public Caisse_Event (FirstCase_admin_caisse m,int table2 ) {
	this.m=m;
	this.table2=table2;
	System.out.println(table2);

}
	public void actionPerformed(ActionEvent e) {
		String tableName="ClientOrder";
		//System.out.println(table2);

		dataBase base = new dataBase();
		
	 base.select(tableName,table2);	
		
	}
	/*public float getResultat() {
		return resultat;
		
	}*/
}
