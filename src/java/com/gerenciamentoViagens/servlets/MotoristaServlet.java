/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Motorista;
import com.gerenciamentoViagens.model.entities.Viagem;
import com.gerenciamentoViagens.model.repositorios.RepositorioMotorista;
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
@WebServlet(name = "MotoristaServlet", urlPatterns = {"/MotoristaServlet"})
public class MotoristaServlet extends HttpServlet {

 
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cnh = request.getParameter("cnh");
        String operacao = request.getParameter("op");
        
        if (cnh!=null){
            Motorista mot = RepositorioMotorista.getCurrentInstance().ler(Integer.parseInt(cnh));
            
            if(operacao!=null && operacao.equals("alterar")){
                request.setAttribute("motorista", mot);
                
                getServletContext().getRequestDispatcher("/CadastroMotorista.jsp").forward(request, response);
                
                return;
            } else if (operacao!=null && operacao.equals("deletar")){
                RepositorioMotorista.getCurrentInstance().deletar(mot.getCnh());
                
                request.getSession().setAttribute("msg", "O Motorista foi deletado com sucesso.");
                
                response.sendRedirect("MotoristaServlet");
                return;
            }
            
            request.setAttribute("motorista", mot);
            
            getServletContext().getRequestDispatcher("/detalheMotorista.jsp").forward(request, response);
            return;
        }
        
        List <Motorista> motoristas = RepositorioMotorista.getCurrentInstance().lerTudo();
        
        request.getSession().setAttribute("motoristas", motoristas);
        
        response.sendRedirect("Motoristas.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        int cnh = Integer.parseInt(request.getParameter("cnh"));
        String nome = request.getParameter("nome");
        String categoriaHabilitacao = request.getParameter("categoriaHabilitacao");
        String telefoneContato = request.getParameter("telefoneContato");
        String endereco =request.getParameter("endereco");
        
        Motorista mot = new Motorista();
        
        
        mot.setCnh(cnh);
        mot.setNome(nome);
        mot.setEndereco(endereco);
        mot.setCategoriaHabilitacao(categoriaHabilitacao);
        mot.setTelefoneContato(telefoneContato);
        mot.setEndereco(endereco);
        
        HttpSession session = request.getSession();
        
        RepositorioMotorista.getCurrentInstance().alterar(mot);
        
        if(op == null){
            RepositorioMotorista.getCurrentInstance().inserir(mot);
            session.setAttribute("msg", "O motorista foi cadastrado com sucesso.");
        } else {
            RepositorioMotorista.getCurrentInstance().alterar(mot);
            session.setAttribute("msg", "O motorista foi alterado com sucesso.");
        }
        
        
        response.sendRedirect("MotoristaServlet");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
