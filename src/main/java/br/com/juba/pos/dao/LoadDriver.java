package br.com.juba.pos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {

    public LoadDriver() {
            // The newInstance() call is a work around for some
            // broken Java implementations
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
     }

    protected Connection getConnection() {
        // URL de conexão com o banco de dados
        String url = "jdbc:mysql://localhost/base_empresa";
        // Conecta utilizando a URL, usuário e senha.
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            return conn;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        LoadDriver db = new LoadDriver();
        Connection conn = db.getConnection();
        System.out.println(conn);

    }
		
}