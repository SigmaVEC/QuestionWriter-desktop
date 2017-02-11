package questioneditor;

import java.util.Scanner;
import java.sql.*;

public class run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username;
		String password;
		String ipaddr = "localhost:3306";

		System.out.print("Enter user name: ");
		username = sc.nextLine();
		System.out.print("Enter password: ");
		password = sc.nextLine();
		System.out.print("Enter IP address [Default 'localhost:3306' if empty]: ");
		String temp = sc.nextLine();
		if (!temp.isEmpty()) {
			ipaddr = temp;
		}
		
		try {
			if (util.testServerConnection(ipaddr, username, password)) {
				//try {
				//	Class.forName("com.mysql.jdbc.Driver");
				//} catch (ClassNotFoundException e) {
				//	e.printStackTrace();
				//}
				MainUI.main(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
