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
public class d_p_DAO {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;
    String quarry;

    PreparedStatement ps, ps1, ps2, ps3;
    String quarry0, quarry1, quarry2, quarry3;
    ResultSet rs0, rs1, rs2, rs3;

    int doctor_c = 0;
    int d_charge = 0;
    int total = 0;

    void connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
    }

    void disconnect() throws SQLException {
        con.close();
    }

    public void insertdata(d_p_get_set gs) throws ClassNotFoundException, SQLException {
        connect();

        quarry = "INSERT INTO combine_d_p (p_id, d_id) VALUES (?,?)";
        stm = con.prepareStatement(quarry);
        stm.setInt(1, gs.getP_id());
        stm.setInt(2, gs.getD_id());
        stm.executeUpdate();

        quarry0 = "SELECT p_bill.doctor_c FROM p_bill WHERE p_id = ? ";
        ps = con.prepareStatement(quarry0);
        ps.setInt(1, gs.getP_id());
        System.out.println("p-id = " + gs.getP_id());
        rs0 = ps.executeQuery();
        if (rs0.next()) {
            doctor_c = rs0.getInt("doctor_c");
        }

        quarry1 = "SELECT d_charge FROM staf WHERE d_id = ?";
        ps1 = con.prepareStatement(quarry1);
        ps1.setInt(1, gs.getD_id());
        rs1 = ps1.executeQuery();
        if (rs1.next()) {
            d_charge = Integer.parseInt(rs1.getString("d_charge"));
        }

        total = doctor_c + d_charge;

        quarry2 = "UPDATE p_bill SET doctor_c = ? WHERE p_id = ?";
        ps2 = con.prepareStatement(quarry2);
        ps2.setInt(1, total);
        ps2.setInt(2, gs.getP_id());
        ps2.executeUpdate();

        disconnect();

    }

    public void update(d_p_get_set gs, int p_id, int d_id) throws SQLException, ClassNotFoundException {

        connect();

        quarry0 = "UPDATE p_bill SET p_bill.doctor_c = p_bill.doctor_c - (SELECT staf.d_charge FROM staf WHERE staf.d_id = ?) WHERE p_bill.p_id = ?";
        ps = con.prepareStatement(quarry0);
        ps.setInt(1, d_id);
        ps.setInt(2, p_id);
        ps.executeUpdate();

        quarry = "UPDATE combine_d_p set p_id = ? , d_id = ?  where d_id = ? ";
        stm = con.prepareStatement(quarry);
        stm.setInt(1, gs.getP_id());
        stm.setInt(2, gs.getD_id());
        stm.setInt(3, d_id);
        stm.executeUpdate();

        quarry1 = "SELECT p_bill.doctor_c FROM p_bill WHERE p_id = ? ";
        ps1 = con.prepareStatement(quarry1);
        ps1.setInt(1, gs.getP_id());
        rs1 = ps1.executeQuery();
        if (rs1.next()) {
            doctor_c = rs1.getInt("doctor_c");
        }

        quarry2 = "SELECT d_charge FROM staf WHERE d_id = ?";
        ps2 = con.prepareStatement(quarry2);
        ps2.setInt(1, gs.getD_id());
        rs2 = ps2.executeQuery();
        if (rs2.next()) {
            d_charge = Integer.parseInt(rs2.getString("d_charge"));
        }

        total = doctor_c + d_charge;

        quarry3 = "UPDATE p_bill SET doctor_c = ? WHERE p_id = ?";
        ps3 = con.prepareStatement(quarry3);
        ps3.setInt(1, total);
        ps3.setInt(2, gs.getP_id());
        ps3.executeUpdate();

        disconnect();

    }

    public List<d_p_get_set> select() throws SQLException, ClassNotFoundException {
        List<d_p_get_set> list = new ArrayList();

        d_p_get_set ds = null;
        quarry = "SELECT * from combine_d_p where boolean = 1";
        connect();
        stm = con.prepareStatement(quarry);
        rs = stm.executeQuery();

        while (rs.next()) {

            int p_id = rs.getInt("p_id");
            int d_id = rs.getInt("d_id");

            ds = new d_p_get_set(p_id, d_id);
            list.add(ds);
        }
        disconnect();
        return list;

    }

    public void delete(d_p_get_set gs) throws ClassNotFoundException, SQLException {
        quarry = "UPDATE `combine_d_p` SET boolean=0 WHERE p_id = ? AND d_id = ?";
        connect();
        stm = con.prepareStatement(quarry);
        stm.setInt(1, gs.getP_id());
        stm.setInt(2, gs.getD_id());
        stm.executeUpdate();

        quarry0 = "UPDATE p_bill SET p_bill.doctor_c = p_bill.doctor_c - (SELECT staf.d_charge FROM staf WHERE staf.d_id = ?) WHERE p_bill.p_id = ?";
        ps = con.prepareStatement(quarry0);
        ps.setInt(1, gs.getD_id());
        ps.setInt(2, gs.getP_id());
        ps.executeUpdate();

        disconnect();
    }
//    
//    public void alldoctor() throws ClassNotFoundException, SQLException{
//        quarry = "UPDATE `staf` SET boolean=1";
//        connect();
//        stm = con.prepareStatement(quarry);
//        stm.executeUpdate();
//        disconnect();
//    }
//    

    public d_p_get_set getd_p(d_p_get_set ts) throws SQLException, ClassNotFoundException {
        connect();
        d_p_get_set ds = null;
        String quarry = "SELECT p_id, d_id from combine_d_p where p_id = ? AND d_id = ? ";
        stm = con.prepareStatement(quarry);
        stm.setInt(1, ts.getP_id());
        stm.setInt(2, ts.getD_id());
        rs = stm.executeQuery();

        if (rs.next()) {
            int p_id = rs.getInt("p_id");
            int d_id = rs.getInt("d_id");

            ds = new d_p_get_set(p_id, d_id);
        }
        disconnect();
        return ds;
    }
    public List<d_p_get_set> findpatient(int id) throws SQLException, ClassNotFoundException {

        List<d_p_get_set> list = new ArrayList<>();
        d_p_get_set ds = null;

            quarry = "SELECT combine_d_p.p_id, combine_d_p.d_id, staf.d_name, staf.d_charge "
                    + "FROM combine_d_p "
                    + "INNER JOIN staf "
                    + "ON combine_d_p.d_id = staf.d_id "
                    + "WHERE combine_d_p.p_id = ?";
        connect();
        stm = con.prepareStatement(quarry);
        stm.setInt(1, id);
        rs = stm.executeQuery();

        while (rs.next()) {

            int p_id = rs.getInt("p_id");
            int d_id = rs.getInt("d_id");
            String d_name = rs.getString("d_name");
            String d_charge = rs.getString("d_charge");

//            ds = new d_p_get_set(p_id, d_id, d_name, d_charge); 
            list.add(ds);
        }
        disconnect();
        return list;
    }
}
