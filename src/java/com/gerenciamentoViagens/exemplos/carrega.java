/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.exemplos;

import com.gerenciamentoViagens.model.entities.Motorista;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author flaviovieira
 */
public class carrega extends SimpleTagSupport{
    
    private List<Motorista> motoristas;
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }



    
    

    @Override
    public void doTag() throws JspException, IOException {
        //super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        
         StringWriter tagBody = new StringWriter();
        
        getJspBody().invoke(tagBody);
        
        getJspContext().getOut().write("<h1>"+tagBody.toString()+"</h1>");
        
        if(motoristas!= null){
            for(Motorista motorista : motoristas){
                getJspContext().getOut().write(" <h1>"+motorista.getNome()+"</h1>");
            }
        }
        
        
        
        getJspContext().getOut().write("tamanho da lista: "+this.motoristas.size());
    }
    
    


    
    
    
    }
