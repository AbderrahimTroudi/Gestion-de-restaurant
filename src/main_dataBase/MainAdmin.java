package main_dataBase;
import windows.login;
import windows.Chat_Admin;
import windows.chattest;

import javax.swing.JFrame;

import windows.FirstCase_admin_caisse;
public class MainAdmin extends JFrame {

	public static void main(String[] args) {
		FirstCase_admin_caisse admin = new FirstCase_admin_caisse();
		
		admin.setVisible(true);
		Chat_Admin CHAT = new Chat_Admin();
		CHAT.setVisible(true);
	}

}
