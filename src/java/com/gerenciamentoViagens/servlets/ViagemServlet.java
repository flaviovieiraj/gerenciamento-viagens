/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Admin;
import com.gerenciamentoViagens.model.entities.Viagem;
import com.gerenciamentoViagens.model.repositorios.RepositorioAdmin;
import com.gerenciamentoViagens.model.repositorios.RepositorioViagem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author flaviovieira
 */
@WebServlet(name = "ViagemServlet", urlPatterns = {"/ViagemServlet"})
public class ViagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("cod");
        String operacao = request.getParameter("op");
        
        if(codigo!= null){
            Viagem vg = RepositorioViagem.getCurrentInstance().ler(Integer.parseInt(codigo));
            
            if(operacao!=null && operacao.equals("alterar")){
                request.setAttribute("viagem", vg);
                
                getServletContext().getRequestDispatcher("/RegistroViagem.jsp").forward(request, response);
                return;
                
            }
            
            request.getSession().setAttribute("viagem", vg);
            
            getServletContext().getRequestDispatcher("/detalheViagem.jsp").forward(request, response);
            return;
        }
        
        List <Viagem> viagens = RepositorioViagem.getCurrentInstance().lerTudo();
        
        request.getSession().setAttribute("viagens", viagens);
        
        response.sendRedirect("Viagens.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
