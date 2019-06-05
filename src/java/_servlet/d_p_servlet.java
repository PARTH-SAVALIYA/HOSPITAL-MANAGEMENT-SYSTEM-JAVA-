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
import javax.servlet.http.HttpSession;
import jdbc1.d_p_DAO;
import jdbc1.d_p_get_set;

/**
 *
 * @author ankita
 */
public class d_p_servlet extends HttpServlet {

    d_p_DAO dd = new d_p_DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/dp_insert":
                insert(request, response);
                break;
            case "/dp_edit":
                edit(request, response);
                break;
            case "/dp_update":
                update(request, response);
                break;
            case "/dp_delete":
                delete(request, response);
                break;
//            case "/d_all":
//                alldoctor(request, response);
//                break;
//            case "/dp_f_p":
//                findpatient(request, response);
//                break;
            case "/dp_logout":
                logout(request, response);
                break;
            default:
                select(request, response);
                break;
        }

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int p_id = Integer.parseInt(request.getParameter("patientid"));
            int d_id = Integer.parseInt(request.getParameter("doctorid"));

            d_p_get_set gs = new d_p_get_set(p_id, d_id);
            dd.insertdata(gs);
            response.sendRedirect("dp_list");

        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("dp_list");
        }
    }

    int d_id;
    int p_id;

    void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            d_id = Integer.parseInt(request.getParameter("d_id"));
            p_id = Integer.parseInt(request.getParameter("p_id"));

            d_p_get_set ps = new d_p_get_set(p_id, d_id);
            d_p_get_set ds = dd.getd_p(ps);

            request.setAttribute("ds", ds);
            request.getRequestDispatcher("edit_d_p.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int d_id = Integer.parseInt(request.getParameter("doctorid"));
            int p_id = Integer.parseInt(request.getParameter("patientid"));

            d_p_get_set ds = new d_p_get_set(p_id, d_id);
            dd.update(ds, this.p_id, this.d_id);
            response.sendRedirect("dp_list");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session.getAttribute("email") == null) {
                int p_id = Integer.parseInt(request.getParameter("p_id"));
                int d_id = Integer.parseInt(request.getParameter("d_id"));
                d_p_get_set ds = new d_p_get_set(p_id, d_id);
                dd.delete(ds);
                response.sendRedirect("dp_list");
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(patient_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            HttpSession session = request.getSession(false);
//            if (session.getAttribute("email") == null) {
            List<d_p_get_set> list = dd.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("d_p.jsp").forward(request, response);
//            }else{
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("message = " + ex.getMessage());
        }

    }

    void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        response.setHeader("Refresh", "0; URL=http://localhost:8080/hospital_manage/index.jsp");
        session.removeAttribute("email");
        session.invalidate();
        response.sendRedirect("index.jsp"); 
    }

//    void findpatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            int total = 0;
//            int id = Integer.parseInt(request.getParameter("id"));
//            List<d_p_get_set> list = dd.findpatient(id);
//            for (d_p_get_set a : list) {
//                total = total + Integer.parseInt(a.getD_charge());
//            }
//            request.setAttribute("total", total);
//            request.setAttribute("list", list);
//            request.getRequestDispatcher("d_p.jsp").forward(request, response);
//        } catch (SQLException | ClassNotFoundException ex) {
//            System.out.println("message = " + ex.getMessage());
//        }
//    }
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
