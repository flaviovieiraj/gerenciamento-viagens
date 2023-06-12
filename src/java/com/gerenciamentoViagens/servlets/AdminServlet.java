/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.Admin;
import com.gerenciamentoViagens.model.entities.Viagem;
import com.gerenciamentoViagens.model.repositorios.RepositorioAdmin;
import java.io.IOException;
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
        
        String op = request.getParameter("op");
        
        switch(op){
            case "logout":
                request.getSession().removeAttribute("adminLogado");
                response.sendRedirect("loginAdmin.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        switch(op){
            case "login":
                int login = Integer.parseInt(request.getParameter("cnh"));
                String senha = request.getParameter("senha");                      
                
                                               
                Admin a = RepositorioAdmin.getCurrentInstance().realizarLogin(login, senha);
                
                if(a == null){
                    request.setAttribute("msg", "Login inválido.");
                    getServletContext().getRequestDispatcher("/loginAdmin.jsp").forward(request, response);
                    return;
                }
                request.getSession().setAttribute("codigoAdmin", login);
                request.getSession().setAttribute("adminLogado", a);
                
                response.sendRedirect("Viagens.jsp");
                
                
                break;
                
            case "cadastro":
                int cnh = Integer.parseInt(request.getParameter("cnh"));
                String nome = request.getParameter("nome");
                String categoriaHabilitacao = request.getParameter("categoriaHabilitacao");
                String telefoneContato = request.getParameter("telefoneContato");
                String endereco =request.getParameter("endereco");
                String senhaMotorista = request.getParameter("senha");
                
                Admin m = new Admin();
                
                m.setCnh(cnh);
                m.setNome(nome);
                m.setCategoriaHabilitacao(categoriaHabilitacao);
                m.setEndereco(endereco);
                m.setSenha(senhaMotorista);
                m.setTelefoneContato(telefoneContato);
                
                RepositorioAdmin.getCurrentInstance().inserir(m);
                
                response.sendRedirect(("loginAdmin.jsp"));
                break;
                
                case "registroViagem":
                    
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String dataInicio = request.getParameter("dataInicio");
                String dataRetorno = request.getParameter("dataRetorno");
                String horaInicio = request.getParameter("horaInicio");
                String horaRetorno = request.getParameter("horaRetorno");
                String localDestino = request.getParameter("localDestino");
                String motivo = request.getParameter("motivo");
                String valorCombustivel = request.getParameter("valorCombustivel");
                String modeloVeiculo = request.getParameter("modeloVeiculo");
                String descricao = request.getParameter("descricao");
                
                
                Viagem vg = new Viagem();
                
                vg.setCodigo(codigo);
                vg.setDataInicio(dataInicio);
                vg.setDataRetorno(dataRetorno);
                vg.setDescricao(descricao);
                vg.setHoraInicio(horaInicio);
                vg.setHoraRetorno(horaRetorno);
                vg.setLocalDestino(localDestino);
                vg.setModeloVeiculo(modeloVeiculo);
                vg.setValorCombustivel(valorCombustivel);
                vg.setMotivo(motivo);
                
                Admin motoristaLogado = (Admin)request.getSession().getAttribute("adminLogado");
                
                motoristaLogado.getViagens().add(vg);
                
                RepositorioAdmin.getCurrentInstance().alterar(motoristaLogado);
                
                
                request.setAttribute("msg", "Viagem registrada com sucesso");
                
                getServletContext().getRequestDispatcher("/Viagens.jsp").forward(request, response);
                
                
                
                
                
                break;
                default:
            }
        }
            
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
