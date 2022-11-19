package main_dataBase;

import windows.Order_Menu;
import windows.Chat_Client;
public class MainCustomer {

	public static void main(String[] args) {

Order_Menu order = new Order_Menu();
order.setVisible(true);

Chat_Client client = new Chat_Client();
client.setVisible(true);
	}

}
