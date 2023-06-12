/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Modelo;
import com.gerenciamentoViagens.model.repositorios.RepositorioModelo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ModeloServlet", urlPatterns = {"/ModeloServlet"})
public class ModeloServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("cod");
        String operacao = request.getParameter("op");
        
        if (codigo != null){
            Modelo mod = RepositorioModelo.getCurrentInstance().ler(Integer.parseInt(codigo));
            
            if(operacao!=null && operacao.equals("alterar")){
            request.setAttribute("modelo", mod);
            
            getServletContext().getRequestDispatcher("/Cadastros/CadastroModelo.jsp").forward(request, response);
            
            return;
        } else if (operacao != null && operacao.equals("deletar")){
            RepositorioModelo.getCurrentInstance().deletar(mod.getCodigo());
            
            request.getSession().setAttribute("msg", "O modelo foi deletado com sucesso.");
            response.sendRedirect("ModeloServlet");
            return;
        }
            
            request.setAttribute("modelo", mod);
            getServletContext().getRequestDispatcher("/detalheModelo.jsp").forward(request, response);
            return;
        }
        
        List <Modelo> modelos = RepositorioModelo.getCurrentInstance().lerTudo();
        
        request.getSession().setAttribute("modelos", modelos);
        
        response.sendRedirect("Modelos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        int cod = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String tipoVeiculo = request.getParameter("tipoVeiculo");
        
        Modelo mod = new Modelo();
        
        mod.setCodigo(cod);
        mod.setNome(nome);
        mod.setMarca(marca);
        mod.setTipoVeiculo(tipoVeiculo);
        
        HttpSession session = request.getSession();
        
        RepositorioModelo.getCurrentInstance().alterar(mod);
        
        if(op == null){
            RepositorioModelo.getCurrentInstance().inserir(mod);
            session.setAttribute("msg", "O modelo foi cadastrado com sucesso.");
        } else {
            RepositorioModelo.getCurrentInstance().alterar(mod);
            session.setAttribute("msg", "O modelo foi alterado com sucesso.");
        }
        
        response.sendRedirect("ModeloServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
