/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.exemplos;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class tag2 extends SimpleTagSupport{
    
    private String var;
    public List attr3;

    public void setAttr3(List attr3) {
        this.attr3 = attr3;
    }
    
        public void setVar(String var) {
        this.var = var;
    }

    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        StringWriter tagBody = new StringWriter();
        
        getJspBody().invoke(tagBody);
        
        getJspContext().getOut().write("<h1>"+tagBody.toString()+" "+this.var+"!</h1>"+this.attr3.size());
    }
    
}
