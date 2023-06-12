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
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author flaviovieira
 */
public class CarregaViagem extends SimpleTagSupport{
    
    private String codigo;
    
    @Override
    public void doTag() throws JspException, IOException {
        
        super.doTag();
        
        int codigoAdmin = (int) getJspContext().getAttribute("codigoAdmin",PageContext.SESSION_SCOPE);
        
        Admin admin = RepositorioAdmin.getCurrentInstance().ler(codigoAdmin);
        
        if (codigo != null && !codigo.isEmpty()) {
    getJspContext().setAttribute("codigo", Integer.parseInt(codigo));
} 
        
        for(Viagem vg : admin.getViagens()){
            if(vg.getCodigo() == Integer.parseInt(codigo)){
                getJspContext().setAttribute("viagem", vg, PageContext.PAGE_SCOPE);
                return;
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}
