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
public class bill_get_set {
    
    int p_id;
    int case_c;
    int doctor_c;

    public bill_get_set(int p_id) {
        this.p_id = p_id;
    }

    public bill_get_set(int p_id, int case_c, int doctor_c) {
        this.p_id = p_id;
        this.case_c = case_c;
        this.doctor_c = doctor_c;
    }

    public bill_get_set(int case_c, int doctor_c) {
        this.case_c = case_c;
        this.doctor_c = doctor_c;
    }
    
    

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getCase_c() {
        return case_c;
    }

    public void setCase_c(int case_c) {
        this.case_c = case_c;
    }

    public int getDoctor_c() {
        return doctor_c;
    }

    public void setDoctor_c(int doctor_c) {
        this.doctor_c = doctor_c;
    }
    
    
    
}
