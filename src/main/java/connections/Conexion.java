package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/lancershotel";
	private static final String USER = "root";
	private static final String PASSWORD = "5184";

	/**
	 * Conecta el lenguaje con la base de datos en MySQL
	 * 
	 * @return Retorna la conexión con la base de datos.
	 */
	public Connection connect() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}

	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}