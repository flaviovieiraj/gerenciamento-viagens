/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Admin;
import com.gerenciamentoViagens.model.repositorios.RepositorioAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author flaviovieira
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operacao = request.getParameter("operacao");
        
        switch(operacao){
            case "logout":
                request.getSession().removeAttribute("adminLogado");
                response.sendRedirect("loginAdmin.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operacao = request.getParameter("operacao");
        
        switch(operacao){
            case "login":
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String senha = request.getParameter("senha");
                
                Admin a = RepositorioAdmin.getCurrentInstance().realizarLogin(codigo, senha);
                
                if(a == null){
                    request.setAttribute("msg", "Login inválido.");
                    getServletContext().getRequestDispatcher("/loginAdmin.jsp").forward(request, response);
                    return;
                }
                
                request.getSession().setAttribute("adminLogado", a);
                
                response.sendRedirect("indexGerenciamento.jsp");
                
                break;
                
            default:
            }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
