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
public class patient_get_set {

    private int p_id;
    private String p_name;
    private String p_age;
    private String p_phone;
    private String p_email;
    private String p_weight;
    private String p_date;
    private String p_disease ;
    

    public patient_get_set(int p_id) {
        this.p_id = p_id;
    }

    public patient_get_set(int p_id, String p_name, String p_age, String p_phone, String p_email, String p_weight, String p_date, String p_disease ) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_age = p_age;
        this.p_phone = p_phone;
        this.p_email = p_email;
        this.p_weight = p_weight;
        this.p_date = p_date;
        this.p_disease = p_disease;
    }
    
    public patient_get_set(String p_name, String p_age, String p_phone ,  String p_email, String p_weight, String p_date, String p_disease) {
        this.p_name = p_name;
        this.p_age = p_age;
        this.p_phone = p_phone;
        this.p_email = p_email;
        this.p_weight = p_weight;
        this.p_date = p_date;
        this.p_disease = p_disease;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_weight() {
        return p_weight;
    }

    public void setP_weight(String p_weight) {
        this.p_weight = p_weight;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    public String getP_disease() {
        return p_disease;
    }

    public void setP_disease(String p_disease) {
        this.p_disease = p_disease;
    }

    
    
    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_age() {
        return p_age;
    }

    public void setP_age(String p_age) {
        this.p_age = p_age;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

}
