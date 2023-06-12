/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Local;
import com.gerenciamentoViagens.model.repositorios.RepositorioLocal;
import java.util.List;
import java.io.IOException;
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
@WebServlet(name = "LocalServlet", urlPatterns = {"/LocalServlet"})
public class LocalServlet extends HttpServlet {
    
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("cod");
        String operacao = request.getParameter("op");
        
        if (codigo != null){
             Local loc = RepositorioLocal.getCurrentInstance().ler(Integer.parseInt(codigo));
             
             if(operacao!=null && operacao.equals("alterar")){
                 request.setAttribute("local", loc);
                 
                 getServletContext().getRequestDispatcher("/Cadastros/CadastroLocal.jsp").forward(request, response);
                 
                 return;
             } else if (operacao != null && operacao.equals("deletar")){
                 RepositorioLocal.getCurrentInstance().deletar(loc.getCodigo());
                 
                 request.getSession().setAttribute("msg", "O local foi deletado com sucesso.");
                 
                 response.sendRedirect("LocalServlet");
                 return;
             }
             
             request.setAttribute("local", loc);
             
             getServletContext().getRequestDispatcher("/detalheLocal.jsp").forward(request, response);
             return;
        }
        
        List <Local> locais = RepositorioLocal.getCurrentInstance().lerTudo();
        
        request.getSession().setAttribute("locais", locais);
        
        response.sendRedirect("Locais.jsp");        
       
    }


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");

        
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String pontoReferencia = request.getParameter("pontoReferencia");
        String descricao = request.getParameter("descricao");
               
        
        Local loc = new Local();  
                
        loc.setNome(nome);
        loc.setEndereco(endereco);
        loc.setCidade(cidade);
        loc.setEstado(estado);
        loc.setPontoReferencia(pontoReferencia);
        loc.setDescricao(descricao);
        
        HttpSession session = request.getSession();
        
        RepositorioLocal.getCurrentInstance().alterar(loc);

        if(op == null){
            RepositorioLocal.getCurrentInstance().inserir(loc);
            session.setAttribute("msg", "O local foi cadastrado com sucesso.");
        } else {
            RepositorioLocal.getCurrentInstance().alterar(loc);
            session.setAttribute("msg", "O local foi alterado com sucesso.");
        }
        
        response.sendRedirect("LocalServlet");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
