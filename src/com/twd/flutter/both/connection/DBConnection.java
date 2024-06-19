package com.twd.flutter.both.connection;

import java.sql.Connection;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {

	static Logger log = Logger.getLogger(DBConnection.class.getName());

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds;
			ds = (DataSource) envCtx.lookup("jdbc/flutterJSMPL");
			return ds.getConnection();
		} catch (Exception se) {
			se.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
