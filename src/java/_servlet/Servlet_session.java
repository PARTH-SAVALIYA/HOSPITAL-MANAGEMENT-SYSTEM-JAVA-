/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc1.user_crud;
import jdbc1.user_get_set;

/**
 *
 * @author ankita
 */
public class Servlet_session extends HttpServlet {

    user_crud uc = new user_crud();

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String email = request.getParameter("email");
        String password =request.getParameter("password");

        try {
            user_get_set gs = new user_get_set(email, password);  
            if (uc.select(gs)) {
                System.out.println("ans" +uc.select(gs));
                HttpSession session = request.getSession(true);
                session.setAttribute("email", gs.getEmail()); 
                System.out.println("DONE");
                response.sendRedirect("dp_list"); 
            } else {
                request.getRequestDispatcher("index2.jsp").include(request, response);
            }

        } catch (Exception e) {
            response.sendRedirect("http://localhost:8080/hospital_manage/index.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
