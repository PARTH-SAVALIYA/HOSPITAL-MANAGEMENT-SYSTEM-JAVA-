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
import jdbc1.caseDAO;
import jdbc1.case_get_set;
import jdbc1.doctor_DAO;
import jdbc1.doctor_get_set;
import jdbc1.patient_get_set;

/**
 *
 * @author ankita
 */
public class case_servlet extends HttpServlet {

    caseDAO cd = new caseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/c_insert":
                insert(request, response);
                break;
            case "/c_edit":
                edit(request, response);
                break;
            case "/c_update":
                update(request, response);
                break;
            case "/c_delete":
                delete(request, response);
                break;
            case "/c_all":
                allcase(request, response);
                break;
            default:
                select(request, response);
                break;
        }

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int p_id = Integer.parseInt(request.getParameter("p_id"));
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String charge = request.getParameter("charge");
          
            case_get_set cg = new case_get_set(p_id,date, time, charge);
            cd.insertdata(cg);
            response.sendRedirect("c_list");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int c_id = Integer.parseInt(request.getParameter("c_id"));
            case_get_set ds = cd.getcase(c_id);
            request.setAttribute("ds", ds);
            request.getRequestDispatcher("edit_case.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int c_id = Integer.parseInt(request.getParameter("caseid"));
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            String charge = request.getParameter("charge");
            
            case_get_set ds = new case_get_set(c_id, date, time, charge);
            cd.update(ds);
            response.sendRedirect("c_list");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int c_id = Integer.parseInt(request.getParameter("c_id"));
            case_get_set cs = new case_get_set(c_id);  
            cd.delete(cs);
            response.sendRedirect("c_list");
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<case_get_set> list = cd.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("case.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("message = " + ex.getMessage());
        }
    }

    void allcase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            cd.allcase();
            response.sendRedirect("c_list");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("message = " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
