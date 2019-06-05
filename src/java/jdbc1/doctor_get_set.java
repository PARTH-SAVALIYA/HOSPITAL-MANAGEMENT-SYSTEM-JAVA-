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
public class doctor_get_set {

    int d_id;
    String d_name;
    String d_email;
    String d_add;
    String d_mobile;
    String d_speciality;
    String d_charge;
    String d_dept;
    
    public doctor_get_set(int d_id) {
        this.d_id = d_id;
    }

    public doctor_get_set(int d_id, String d_name, String d_email, String d_add, String d_mobile, String d_speciality, String d_charge, String d_dept) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_email = d_email;
        this.d_add = d_add;
        this.d_mobile = d_mobile;
        this.d_speciality = d_speciality;
        this.d_charge = d_charge;
        this.d_dept = d_dept;
    }

    public doctor_get_set(String d_name, String d_email, String d_add, String d_mobile, String d_speciality, String d_charge, String d_dept) {
        this.d_name = d_name;
        this.d_email = d_email;
        this.d_add = d_add;
        this.d_mobile = d_mobile;
        this.d_speciality = d_speciality;
        this.d_charge = d_charge;
        this.d_dept = d_dept;
    }
    
    
    
    

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_email() {
        return d_email;
    }

    public void setD_email(String d_email) {
        this.d_email = d_email;
    }

    public String getD_add() {
        return d_add;
    }

    public void setD_add(String d_add) {
        this.d_add = d_add;
    }

    public String getD_mobile() {
        return d_mobile;
    }

    public void setD_mobile(String d_mobile) {
        this.d_mobile = d_mobile;
    }

    public String getD_speciality() {
        return d_speciality;
    }

    public void setD_speciality(String d_speciality) {
        this.d_speciality = d_speciality;
    }

    public String getD_charge() {
        return d_charge;
    }

    public void setD_charge(String d_charge) {
        this.d_charge = d_charge;
    }

    public String getD_dept() {
        return d_dept;
    }

    public void setD_dept(String d_dept) {
        this.d_dept = d_dept;
    }

    
}
