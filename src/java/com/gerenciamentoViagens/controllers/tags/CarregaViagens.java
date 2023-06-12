/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.controllers.tags;

import com.gerenciamentoViagens.model.entities.Admin;
import com.gerenciamentoViagens.model.entities.Viagem;
import com.gerenciamentoViagens.model.repositorios.RepositorioAdmin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author flaviovieira
 */
public class CarregaViagens extends SimpleTagSupport{
    
    @Override
    public void doTag() throws JspException, IOException{
        super.doTag();
        
        int cAdmin = (int)getJspContext().getAttribute("cnh", PageContext.SESSION_SCOPE);
        
        Admin a = (Admin)getJspContext().getAttribute("adminLogado",PageContext.SESSION_SCOPE);
        
        List<Viagem> viagens = new ArrayList<>();
        
        for(Viagem vAux: a.getViagens()){
            if(vAux.getMotorista().equals(a.getCnh())){
                viagens.add(vAux);
            }
        }
        
        getJspContext().setAttribute("viagens", viagens,PageContext.PAGE_SCOPE);
    
}
}
