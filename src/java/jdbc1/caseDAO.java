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

public class caseDAO {

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

    public void insertdata(case_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "INSERT INTO p_case (p_id ,date, time, charge) VALUES (?,?,?,?)";

        connect();
        stm = con.prepareStatement(quarry);

        String quarry;
        PreparedStatement ps;

        stm.setInt(1, gs.getP_id());
        stm.setString(2, gs.getDate());
        stm.setString(3, gs.getTime());
        stm.setString(4, gs.getCharge());
        
        int p_id = gs.getP_id();
        int charge = Integer.parseInt(gs.getCharge());

        quarry = "INSERT INTO p_bill (p_id, case_c) VALUES (?, ?)";
        ps = con.prepareStatement(quarry);
        ps.setInt(1, p_id);
        ps.setInt(2, charge);
        ps.executeUpdate();

        stm.executeUpdate();
        disconnect();
    }

    public void update(case_get_set gs) throws SQLException, ClassNotFoundException {

        quarry = "UPDATE p_case SET p_id=?, date =?, time =?, charge =? WHERE c_id = ?;";

        connect();
        stm = con.prepareStatement(quarry);

        stm.setInt(1, gs.getP_id());
        stm.setString(2, gs.getDate());
        stm.setString(3, gs.getTime());
        stm.setString(4, gs.getCharge());
        stm.setInt(5, gs.getC_id());

        stm.executeUpdate();
        disconnect();

    }

    public List<case_get_set> select() throws SQLException, ClassNotFoundException {
        List<case_get_set> list = new ArrayList();

        case_get_set cs = null;
        quarry = "SELECT * from p_case WHERE boolean = 1";
        connect();
        stm = con.prepareStatement(quarry);
        rs = stm.executeQuery();

        while (rs.next()) {

            int c_id = rs.getInt("c_id");
            int p_id = rs.getInt("p_id");
            String date = rs.getString("date");
            String time = rs.getString("time");
            String charge = rs.getString("charge");
            int p_charge = Integer.parseInt(rs.getString("charge"));

//            quarry = "INSERT INTO p_bill (p_id, case_c) VALUES (4, ?)";            
//            ps = con.prepareStatement(quarry);
//            ps.setInt(1, p_charge);
//            ps.executeUpdate();
            System.out.println("SELECT");
            cs = new case_get_set(c_id, p_id, date, time, charge);
            System.out.println("END");
            list.add(cs);
        }
        disconnect();
        return list;

    }

    public void delete(case_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "UPDATE p_case SET boolean=0 WHERE c_id = ?";
        connect();
        stm = con.prepareStatement(quarry);
        stm.setInt(1, gs.getC_id());
        stm.executeUpdate();
        disconnect();
    }

    public void allcase() throws ClassNotFoundException, SQLException {
        quarry = "UPDATE `p_case` SET boolean=1";
        connect();
        stm = con.prepareStatement(quarry);
        stm.executeUpdate();
        disconnect();
    }

    public case_get_set getcase(int c_id) throws SQLException, ClassNotFoundException {
        connect();
        case_get_set cs = null;
        String quarry = "SELECT * from p_case WHERE c_id = ? ";
        stm = con.prepareStatement(quarry);
        stm.setInt(1, c_id);
        rs = stm.executeQuery();

        if (rs.next()) {
            int p_id = rs.getInt("p_id");
            String date = rs.getString("date");
            String time = rs.getString("time");
            String charge = rs.getString("charge");

            cs = new case_get_set(c_id, p_id, date, time, charge);
        }
        disconnect();
        return cs;
    }
}
