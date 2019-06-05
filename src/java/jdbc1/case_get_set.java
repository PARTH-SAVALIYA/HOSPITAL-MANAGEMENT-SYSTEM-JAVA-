/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

/**
 *
 * @author ankita
 */
public class case_get_set {
    
    int c_id;
    int p_id;
    String date;
    String time;
    String charge;

    public case_get_set(int c_id) {
        this.c_id = c_id;
    }

    public case_get_set(int c_id, int p_id, String date, String time, String charge) {
        this.c_id = c_id;
        this.p_id = p_id;
        this.date = date;
        this.time = time;
        this.charge = charge;
    }

    public case_get_set(int p_id, String date, String time, String charge) {
        this.p_id = p_id;
        this.date = date;
        this.time = time;
        this.charge = charge;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
    
    
    
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
    
    
    
}
