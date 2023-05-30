/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Marca;
import com.gerenciamentoViagens.model.repositorios.RepositorioMarca;
import java.io.IOException;
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
@WebServlet(name = "MarcaServlet", urlPatterns = {"/MarcaServlet"})
public class MarcaServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("cod");
        String operacao = request.getParameter("op");
        
        if(codigo!=null){
            Marca mar = RepositorioMarca.getCurrentInstance().ler(Integer.parseInt(codigo));
            if(operacao!=null && operacao.equals("alterar")){
                request.setAttribute("marca", mar);
                
                getServletContext().getRequestDispatcher("/CadastroMarca.jsp").forward(request, response);
                
                return;
            } else if (operacao != null && operacao.equals("deletar")){
                RepositorioMarca.getCurrentInstance().deletar(mar.getCodigo());
                
                request.getSession().setAttribute("msg", "A marca foi deletada com sucesso.");
                response.sendRedirect("MarcaServlet");
                return;
            }
            
            request.setAttribute("marca", mar);
            getServletContext().getRequestDispatcher("/detalheMarca.jsp").forward(request, response);
            return;
        }
        
        List <Marca> marcas = RepositorioMarca.getCurrentInstance().lerTudo();
        request.getSession().setAttribute("marcas", marcas);
        response.sendRedirect("Marcas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        int cod = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String nacionalidade = request.getParameter("nacionalidade");
        String descricao = request.getParameter("descricao");
        
        Marca mar = new Marca();
        
        mar.setCodigo(cod);
        mar.setNome(nome);
        mar.setNacionalidade(nacionalidade);
        mar.setDescricao(descricao);
        
        HttpSession session = request.getSession();
        
        RepositorioMarca.getCurrentInstance().alterar(mar);

        if(op == null){
            RepositorioMarca.getCurrentInstance().inserir(mar);
            session.setAttribute("msg", "A marca foi cadastrada com sucesso.");
        } else {
            RepositorioMarca.getCurrentInstance().alterar(mar);
            session.setAttribute("msg", "A marca foi alterada com sucesso.");
        }
        
        response.sendRedirect("MarcaServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
