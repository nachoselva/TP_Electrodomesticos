package AccesoDatos;

import java.sql.*;

public class AdaptadorConeccion {

	private static AdaptadorConeccion instancia;
	public static AdaptadorConeccion getInstancia(){
		if(instancia==null){
			instancia=new AdaptadorConeccion();
		}
		return instancia;
	}
	
	private static String dbUrl="jdbc:mysql://localhost:3306/db_electrodomesticos";
	private static String dbUser="root";
	private static String dbPassword="selva";
	
	
	private AdaptadorConeccion(){}
	
	private Connection conn;
	
	public Connection getConn(){
		try {
			if(conn==null){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn= DriverManager.getConnection(dbUrl,dbUser,dbPassword);	
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public void CloseConn(){
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}





