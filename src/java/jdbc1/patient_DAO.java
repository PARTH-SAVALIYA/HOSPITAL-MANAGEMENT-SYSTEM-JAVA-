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
public class patient_DAO {

    Connection con;
    PreparedStatement stm;
    public ResultSet rs;
    String quarry;

    void connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
    }

    void disconnect() throws SQLException {
        con.close();
    }

    public void insertdata(patient_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "INSERT INTO tbl_patient (p_name, p_age, p_phone, p_email, p_weight, p_date, p_disease) VALUES (?,?,?,?,?,?,?)";

        connect();
        stm = con.prepareStatement(quarry);

        stm.setString(1, gs.getP_name());
        stm.setString(2, gs.getP_age());
        stm.setString(3, gs.getP_phone());
        stm.setString(4, gs.getP_email());
        stm.setString(5, gs.getP_weight());
        stm.setString(6, gs.getP_date());
        stm.setString(7, gs.getP_disease());
        
        stm.executeUpdate();
        disconnect();

    }

    public void update(patient_get_set gs) throws SQLException, ClassNotFoundException {

        quarry = "UPDATE `tbl_patient` SET `p_name` =? , `p_age` =  ?,`p_phone`=?,`p_email`=?,`p_weight`=?,`p_date`=?, `p_disease`=?  where `p_id` = ?";

        connect();
        stm = con.prepareStatement(quarry);

        stm.setString(1, gs.getP_name());
        stm.setString(2, gs.getP_age());
        stm.setString(3, gs.getP_phone());
        stm.setString(4, gs.getP_email());
        stm.setString(5, gs.getP_weight());
        stm.setString(6, gs.getP_date());
        stm.setString(7, gs.getP_disease());
        stm.setInt(8, gs.getP_id());
        
        System.out.println("update");

        stm.executeUpdate();
        disconnect();

    }

    public List<patient_get_set> select() throws SQLException, ClassNotFoundException {
        List<patient_get_set> listpatient = new ArrayList<>();

        String sql = "SELECT * from tbl_patient WHERE boolean = 1";
        connect();
        stm = con.prepareStatement(sql);
        rs = stm.executeQuery(sql);

        while (rs.next()) {
            int p_id = rs.getInt("p_id");
            String p_name = rs.getString("p_name");
            String p_age = rs.getString("p_age");
            String p_phone = rs.getString("p_phone");
            String p_email = rs.getString("p_email");
            String p_weight = rs.getString("p_weight");
            String p_date = rs.getString("p_date");
            String p_disease = rs.getString("p_disease");
            
            patient_get_set ps = new patient_get_set(p_id, p_name, p_age, p_phone, p_email, p_weight, p_date,p_disease);
            listpatient.add(ps);
        }
        disconnect();
        return listpatient;
    }

    public patient_get_set getpatient(int p_id) throws SQLException, ClassNotFoundException {
        connect();
        patient_get_set ps = null;
        String quarry = "SELECT * from tbl_patient WHERE p_id = ? ";
        stm = con.prepareStatement(quarry);
        stm.setInt(1, p_id);
        rs = stm.executeQuery();
        

        if (rs.next()) {
            String p_name = rs.getString("p_name");
            String p_age = rs.getString("p_age");
            String p_phone = rs.getString("p_phone");
            String p_email = rs.getString("p_email");
            String p_weight = rs.getString("p_weight");
            String p_date = rs.getString("p_date");
            String p_disease = rs.getString("p_disease");
            
            ps = new patient_get_set(p_id, p_name, p_age, p_phone, p_email, p_weight, p_date,p_disease);
        }
        disconnect();
        return ps;        
    }

    public void delete(patient_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "UPDATE `tbl_patient` SET boolean=0 WHERE p_id = ?";
        connect();
        stm = con.prepareStatement(quarry);
        stm.setInt(1, gs.getP_id());
        stm.executeUpdate();
        disconnect();
    }
    
    public void allpatient() throws ClassNotFoundException, SQLException{
        quarry = "UPDATE `tbl_patient` SET boolean=1";
        connect();
        stm = con.prepareStatement(quarry);
        stm.executeUpdate();
        disconnect();
    }

}
