package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	//OBS IMPORTANTE: Conectar com o banco de dados no JDBC trata-se de intanciar um objeto do tipo "Connection"
	
	
	//Objeto de conexão com o banco de dados do JDBC
	private static Connection conn = null;
	
	
	//Criação de métodos estáticos para conectar/desconectar com o banco de dados (MySQL)
	
	//Método completo responsável por gerar a conexão com o banco de dados
	public static Connection getConnection() {
		if(conn == null) {
			
			try { 
				//propriedades de conexão com o banco de dados
				Properties props = loadProperties();
				
				//url do banco de dados
				String url = props.getProperty("dburl");
				
				//conexão com o banco de dados
				conn =  DriverManager.getConnection(url, props);  //Conexão salva no objeto 'conn'
			}
			catch (SQLException e) {
				throw new dbException(e.getMessage());  //Exceção personalizada
			}
		}
		return conn;
	}
	
	//Método responsável por fechar a conexão com o banco de dados
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new dbException(e.getMessage());
			}
		}
	}
	
	//Método auxiliar que carregará as propriedades  (dados de conexão com o banco) que estão no arquivo 'db.properties'
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);  //'load' faz a leitura do arquivo 'db.properties' ao qual está apontado pelo InputStream 'fs' e então guarda dentro do objeto 'props'
			return props;
		} 
		catch (IOException e) {
			throw new dbException(e.getMessage());
		}
	}
	
	//Método auxiliar para fechar os objetos (Statement 'st' e resultSet 'rs')
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}catch (SQLException e) {
				throw new dbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				throw new dbException(e.getMessage());
			}
		}
	}
	
}
