/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mascotafeliz;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Familia
 */
public class MascotaFeliz {

    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/mascotafeliz";
        
        Connection connection;
        
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url, user, password);
            if (connection != null){
                System.out.println("Conexion exitosa");
            }
        }catch(Exception e){
            System.out.println("Error en la conexion"+e.getMessage());
        }
    }
}
