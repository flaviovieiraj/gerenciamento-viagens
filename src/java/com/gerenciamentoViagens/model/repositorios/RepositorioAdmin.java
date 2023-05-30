/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioAdmin {
    
    private static RepositorioAdmin myself = null;
    
    private List<Admin> adms;

    private RepositorioAdmin() {
        this.adms = new ArrayList<>();
        
        Admin a = new Admin();
        
        a.setCodigo(123);
        a.setNome("Flávio");
        a.setSenha("1234");
        
        this.adms.add(a);
    }
    
    public static RepositorioAdmin getCurrentInstance(){
        if(myself==null)
            RepositorioAdmin.myself = new RepositorioAdmin();
        return myself;
    }
    
    public void inserir(Admin a){
        this.adms.add(a);
    }
    
    public void alterar(Admin a){
        for(Admin eAux:this.adms){
            if(a.getCodigo() == eAux.getCodigo()){
                eAux.setNome(a.getNome());
                eAux.setSenha(a.getSenha());
                
                return;
            }
        }
    }
    
    public Admin ler(int codigo){
        
        for(Admin a:this.adms){
            if(a.getCodigo()==codigo){
                return a;
            }
        }
        
        return null;
    }
    
    public Admin realizarLogin(int codigo, String senha){
        for(Admin a:this.adms){
            if(a.getCodigo()==codigo && a.getSenha().equals(senha)){
                return a;
            }
        }
        return null;
    }
    
    
    
}
