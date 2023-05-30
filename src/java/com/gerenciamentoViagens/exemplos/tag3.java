/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.exemplos;

import com.gerenciamentoViagens.model.entities.Local;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class tag3 extends SimpleTagSupport{
    
    private String attr1;
    private int attr2;
    private Local attr3;

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        getJspContext().getOut().write("O valor do atributo 1 é:"+this.attr1);
        getJspContext().getOut().append("</br>O valor do atributo 2 é :"+this.attr2);
        getJspContext().getOut().append("</br>O nome do local é:"+this.attr3.getNome());
        
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public int getAttr2() {
        return attr2;
    }

    public void setAttr2(int attr2) {
        this.attr2 = attr2;
    }

    public Local getAttr3() {
        return attr3;
    }

    public void setAttr3(Local attr3) {
        this.attr3 = attr3;
    }
    
    
    
    
    
    
    
    
}
