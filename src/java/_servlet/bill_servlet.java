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
import jdbc1.bill_DAO;
import jdbc1.doctor_DAO;
import jdbc1.doctor_get_set;
import jdbc1.patient_get_set;

/**
 *
 * @author ankita
 */
public class bill_servlet extends HttpServlet {

    bill_DAO dd = new bill_DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
//            case "/b_insert":
//                insert(request, response);
//                break;
//            case "/b_edit":
//                edit(request, response);
//                break;
//            case "/b_update":
//                update(request, response);
//                break;
//            case "/b_delete":
//                delete(request, response);
//                break;
//            case "/b_all":
//                alldoctor(request, response);
//                break;
//            default:
//                select(request, response);
//                break;
        }

    }

//    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            String d_name = request.getParameter("doctorname");
//            
//            doctor_get_set ds = new doctor_get_set(d_name, d_email, d_add, d_mobile, d_speciality, d_charge, d_dept);
//            dd.insertdata(ds);
//            response.sendRedirect("d_list");
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int d_id = Integer.parseInt(request.getParameter("d_id"));
//            doctor_get_set ds = dd.getdoctor(d_id); 
//            request.setAttribute("ds", ds);
//            request.getRequestDispatcher("edit_doctor.jsp").forward(request, response);
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            int d_id = Integer.parseInt(request.getParameter("doctorid"));
//            String d_name = request.getParameter("doctorname");
//            String d_email = request.getParameter("email");
//            String d_add = request.getParameter("add");
//            String d_mobile = request.getParameter("mobile");
//            String d_speciality = request.getParameter("speciality");
//            String d_charge = request.getParameter("charge");
//            String d_dept = request.getParameter("dept");
//
//            doctor_get_set ds = new doctor_get_set(d_id, d_name, d_email, d_add, d_mobile, d_speciality, d_charge, d_dept); 
//            dd.update(ds);
//            response.sendRedirect("d_list");
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int d_id = Integer.parseInt(request.getParameter("d_id"));
//            doctor_get_set ds = new doctor_get_set(d_id); 
//            dd.delete(ds);
//            response.sendRedirect("d_list");
//        } catch (IOException | ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//
//    void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            List<doctor_get_set> list = dd.select();
//            request.setAttribute("list", list);
//            request.getRequestDispatcher("doctor.jsp").forward(request, response);
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println("message = " + ex.getMessage());
//        }
//    }
//
//    void alldoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            dd.alldoctor();
//            response.sendRedirect("d_list");
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println("message = " + ex.getMessage());
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
