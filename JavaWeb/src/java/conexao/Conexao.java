/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Senai
 */
public class Conexao {

    private final static String url = "jdbc:mysql://localhost:3306/mercadoWeb?useSSL=false";
    private final static String user = "root";
    private final static String password = "";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

//Victor
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
//Victor
}
