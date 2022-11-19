package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main_dataBase.dataBase;
import windows.login;

public class login_Event implements ActionListener {
login log ; 
String login;
String mdp;
public login_Event(login log,String login,String mdp)
{this.log=log;
this.login=login;
this.mdp=mdp;
}
	public void actionPerformed(ActionEvent e) {

		dataBase check = new dataBase();
		check.selectLogin(login,mdp);
	}

}
