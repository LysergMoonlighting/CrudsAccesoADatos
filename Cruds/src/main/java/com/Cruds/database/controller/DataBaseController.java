package com.Cruds.database.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBaseController {
	private String serverUrl;
	private String serverPort;
	private String databaseName;
	private String user;
	private String password;
	private String jdbcDriver;
	private Connection connection;
	private PreparedStatement pstat;
	private static DataBaseController dataBaseController;

	private DataBaseController(String serverUrl, String serverPort, String databaseName, String user, String password,
			String jdbcDriver) {
		this.serverUrl = serverUrl;
		this.serverPort = serverPort;
		this.databaseName = databaseName;
		this.user = user;
		this.password = password;
		this.jdbcDriver = jdbcDriver;
	}

	private DataBaseController() {
		initConfig();
	}

	public static DataBaseController getInstance(String serverUrl, String serverPort, String databaseName, String user,
			String password, String jdbcDriver) {
		if (dataBaseController == null) {
			dataBaseController = new DataBaseController(serverUrl, serverPort, databaseName, user, password,
					jdbcDriver);
		}
		return dataBaseController;
	}

	public static DataBaseController getInstance() {
		if (dataBaseController == null) {
			dataBaseController = new DataBaseController();
		}
		return dataBaseController;
	}

	private void initConfig() {
		this.serverUrl = "localhost";
		this.serverPort = "3306";
		this.databaseName = "empresa";
		this.user = "root";
		this.password = "";
		this.jdbcDriver = "com.mysql.cj.jdbc.Driver";
	}

	public void open() {
		try {
			Class.forName(jdbcDriver);
			String url = "jdbc:mysql://" + serverUrl + ":" + serverPort + "/" + databaseName;
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			pstat.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet select(String querry, Object... params) {
		ResultSet rs = null;
		try {
			pstat = connection.prepareStatement(querry);
			for (int e = 0; e < params.length; e++) {
				pstat.setObject(e + 1, params[e]);
			}
			rs = pstat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int update(String querry, Object... params) {
		int lines = 0;
		try {
			pstat = connection.prepareStatement(querry);
			for (int e = 0; e < params.length; e++) {
				pstat.setObject(e + 1, params[e]);
			}
			lines = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
