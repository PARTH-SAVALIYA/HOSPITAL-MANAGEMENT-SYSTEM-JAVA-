/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc1.*;
import jdbc1.patient_get_set;

/**
 *
 * @author ankita
 */
public class patient_servlet extends HttpServlet {

    patient_DAO pd = new patient_DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/insert":
                insert(request, response);
                break;
            case "/edit":
                edit(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/all":
                allpatient(request, response);
                break;
            default:
                select(request, response);
                break;
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String p_name = request.getParameter("patientname");
            String p_age = request.getParameter("age");
            String p_phone = request.getParameter("phone");
            String p_email = request.getParameter("email");
            String p_weight = request.getParameter("weight");
            String p_date = request.getParameter("date");
            String p_disease  = request.getParameter("disease");
            
            patient_get_set gs = new patient_get_set(p_name, p_age, p_phone, p_email, p_weight, p_date, p_disease);
            pd.insertdata(gs);
            response.sendRedirect("list");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int p_id = Integer.parseInt(request.getParameter("p_id"));
            patient_get_set ps = pd.getpatient(p_id);
            request.setAttribute("ps", ps);
            request.getRequestDispatcher("edit_patient.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int p_id = Integer.parseInt(request.getParameter("patientid"));
            String p_name = request.getParameter("patientname");
            String p_age = request.getParameter("age");
            String p_phone = request.getParameter("phone");
            String p_email = request.getParameter("email");
            String p_weight = request.getParameter("weight");
            String p_date = request.getParameter("date");
            String p_disease = request.getParameter("disease");

            patient_get_set gs = new patient_get_set(p_id, p_name, p_age, p_phone, p_email, p_weight, p_date,p_disease);
            pd.update(gs);
            response.sendRedirect("list");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int p_id = Integer.parseInt(request.getParameter("p_id"));
            patient_get_set gs = new patient_get_set(p_id);
            pd.delete(gs);
            response.sendRedirect("list");
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<patient_get_set> list = pd.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("patient.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("message = " + ex.getMessage());
        }
    }

    void allpatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            pd.allpatient();
            response.sendRedirect("list");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("message = " + ex.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
