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
public class d_p_get_set {
    
    int p_id;
    int d_id;

    public d_p_get_set(int p_id, int d_id) {
        this.p_id = p_id;
        this.d_id = d_id;
    }

    public d_p_get_set(int p_id) {
        this.p_id = p_id;
    }
    
    

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "p_id=" + p_id + ", d_id=" + d_id ;
    }
   
    
    
    
}
