package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    //127.0.0.1
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/to_do_app";
    public static final String USER = "root";
    public static final String PASS = "eds169910@@";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro na conexão com o banco de dados");
        }
    }
    
    // FECHAR CONEXÃO //
    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados");
        }
    }
    
    // FECHAR CONEXÃO + STATEMENT //
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null){
                connection.close();
            }

            if (statement != null){
                statement.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados");
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultset){
        try {
            if (connection != null){
                connection.close();
            }

            if (statement != null){
                statement.close();
            }

            if (resultset != null){
                resultset.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados");
        }
    }

}
