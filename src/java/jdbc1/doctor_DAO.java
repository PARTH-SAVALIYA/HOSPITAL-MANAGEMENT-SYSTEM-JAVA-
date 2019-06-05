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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ankita
 */
public class doctor_DAO {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    String quarry;

    void connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
    }

    void disconnect() throws SQLException {
        con.close();
    }

    public void insertdata(doctor_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "INSERT INTO staf (d_name, d_email, d_add, d_mobile, d_speciality, d_charge, d_dept) VALUES (?,?,?,?,?,?,?)";

        connect();
        stm = con.prepareStatement(quarry);

        stm.setString(1, gs.getD_name());
        stm.setString(2, gs.getD_email());
        stm.setString(3, gs.getD_add());
        stm.setString(4, gs.getD_mobile());
        stm.setString(5, gs.getD_speciality());
        stm.setString(6, gs.getD_charge());
        stm.setString(7, gs.getD_dept());

        stm.executeUpdate();
        disconnect();

    }

    public void update(doctor_get_set gs) throws SQLException, ClassNotFoundException {

        quarry = "UPDATE staf SET d_name =?, d_email =?, d_add =?, d_mobile =?, d_speciality =?, d_charge =?, d_dept =? WHERE d_id = ?;";

        connect();
        stm = con.prepareStatement(quarry);

        stm.setString(1, gs.getD_name());
        stm.setString(2, gs.getD_email());
        stm.setString(3, gs.getD_add());
        stm.setString(4, gs.getD_mobile());
        stm.setString(5, gs.getD_speciality());
        stm.setString(6, gs.getD_charge());
        stm.setString(7, gs.getD_dept());
        stm.setInt(8, gs.getD_id()); 

        stm.executeUpdate();
        disconnect();

    }
//
    public List<doctor_get_set> select() throws SQLException, ClassNotFoundException {
        List<doctor_get_set> list = new ArrayList();

        doctor_get_set ds = null;
        quarry = "SELECT * from staf WHERE boolean = 1";
        connect();
        stm = con.prepareStatement(quarry);
        rs = stm.executeQuery();

        while (rs.next()) {

            int d_id = rs.getInt("d_id");
            String d_name = rs.getString("d_name");
            String d_email = rs.getString("d_email");
            String d_add = rs.getString("d_add");
            String d_mobile = rs.getString("d_mobile");
            String d_speciality = rs.getString("d_speciality");
            String d_charge = rs.getString("d_charge");
            String d_dept = rs.getString("d_dept");

            ds = new doctor_get_set(d_id, d_name, d_email, d_add, d_mobile, d_speciality, d_charge, d_dept);
            list.add(ds);
        }
        disconnect();
        return list;

    }

    public void delete(doctor_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "UPDATE `staf` SET boolean=0 WHERE d_id = ?";
        connect();
        stm = con.prepareStatement(quarry);
        stm.setInt(1, gs.getD_id());
        stm.executeUpdate();
        disconnect(); 
    }
    
    public void alldoctor() throws ClassNotFoundException, SQLException{
        quarry = "UPDATE `staf` SET boolean=1";
        connect();
        stm = con.prepareStatement(quarry);
        stm.executeUpdate();
        disconnect();
    }
    
    public doctor_get_set getdoctor(int d_id) throws SQLException, ClassNotFoundException {
        connect();
        doctor_get_set ds = null;
        String quarry = "SELECT * from staf WHERE d_id = ? ";
        stm = con.prepareStatement(quarry);
        stm.setInt(1, d_id);
        rs = stm.executeQuery();
        

        if (rs.next()) {
            String d_name = rs.getString("d_name");
            String d_email = rs.getString("d_email");
            String d_add = rs.getString("d_add");
            String d_mobile = rs.getString("d_mobile");
            String d_speciality = rs.getString("d_speciality");
            String d_charge = rs.getString("d_charge");
            String d_dept = rs.getString("d_dept");
            
            ds = new doctor_get_set(d_id, d_name, d_email, d_add, d_mobile, d_speciality, d_charge, d_dept); 
        }
        disconnect();
        return ds;        
    }
}
