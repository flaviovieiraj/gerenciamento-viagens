
package com.gerenciamentoViagens.servlets;

import com.gerenciamentoViagens.model.entities.TipoVeiculo;
import com.gerenciamentoViagens.model.repositorios.RepositorioTipoVeiculo;
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
@WebServlet(name = "TipoVeiculoServlet", urlPatterns = {"/TipoVeiculoServlet"})
public class TipoVeiculoServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigo = request.getParameter("cod");
        String operacao = request.getParameter("op");
        
        if (codigo!=null) {
            TipoVeiculo tipov = RepositorioTipoVeiculo.getCurrentInstance().ler(Integer.parseInt(codigo));
             
            if (operacao!= null && operacao.equals("alterar")){
                request.setAttribute("tipoveiculo", tipov);
                
                getServletContext().getRequestDispatcher("/Cadastros/CadastroTipoVeiculo.jsp").forward(request, response);
                return;
            } else if (operacao != null && operacao.equals("deletar")){
                RepositorioTipoVeiculo.getCurrentInstance().deletar(tipov.getCodigo());
                request.getSession().setAttribute("msg", "O tipo de veículo foi deletado com sucesso.");
                response.sendRedirect("TipoVeiculoServlet");
return;
            }
            
            request.setAttribute("tipoveiculo", tipov);
            getServletContext().getRequestDispatcher("/detalheTipoVeiculo.jsp").forward(request, response);
            return;
        }
        
        List <TipoVeiculo> tiposveiculo = RepositorioTipoVeiculo.getCurrentInstance().lerTudo();
        request.getSession().setAttribute("tiposveiculo", tiposveiculo);
        response.sendRedirect("TiposVeiculo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");
        
        TipoVeiculo tipov = new TipoVeiculo();
        
        tipov.setTipo(tipo);
        tipov.setDescricao(descricao);
        
        HttpSession session = request.getSession();
        
        RepositorioTipoVeiculo.getCurrentInstance().alterar(tipov);

        if(op == null){
            RepositorioTipoVeiculo.getCurrentInstance().inserir(tipov);
            session.setAttribute("msg", "O tipo de veículo foi cadastrado com sucesso.");
        } else {
            RepositorioTipoVeiculo.getCurrentInstance().alterar(tipov);
            session.setAttribute("msg", "O tipo de veículo foi alterado com sucesso.");
        }
        
        response.sendRedirect("TipoVeiculoServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
