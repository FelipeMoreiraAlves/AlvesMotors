package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String user = "RM77246";
		String pass = "201194";
		
		return DriverManager.getConnection(url, user, pass);
	}

}
