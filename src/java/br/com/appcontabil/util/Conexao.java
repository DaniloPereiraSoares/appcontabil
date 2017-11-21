/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author Coronel Mustang
 */
public class Conexao {
    
    public static final String USER = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/bdcontabil";
    public static final String PASSWORD = "root";
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConexao() {
        try {
            Class.forName(DRIVER);
            try {

                return DriverManager.getConnection(URL, USER, PASSWORD);

            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    
}
