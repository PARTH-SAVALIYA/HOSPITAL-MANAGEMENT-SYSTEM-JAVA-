/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ankita
 */
public class user_crud {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    String quarry;
    String url;
    String username;
    String password;

    public user_crud() {
    }

    public void connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
    }

    public void disconnect() throws SQLException {
        con.close();
    }

    public boolean select(user_get_set gs) throws SQLException, ClassNotFoundException {
        connect();

        quarry = "SELECT * FROM `admin` WHERE email = ? AND password= ? ";
        stm = con.prepareStatement(quarry);
        stm.setString(1, gs.getEmail());
        stm.setString(2, gs.getPassword());
        
        rs = stm.executeQuery();

        return rs.next();

    }

}
