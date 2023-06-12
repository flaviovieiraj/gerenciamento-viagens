/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Admin;
import com.gerenciamentoViagens.model.entities.Viagem;
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
        
        a.setCnh(12345678);
        a.setNome("Flávio");
        a.setSenha("1234");
        a.setCategoriaHabilitacao("A");
        a.setEndereco("rua 1");
        a.setTelefoneContato("88888888");
        
        
        
        Viagem v = new Viagem();
        
        v.setCodigo(3);
        v.setDataInicio("01/02");
        v.setLocalDestino("Olinda");
        v.setValorCombustivel("150");
        v.setModeloVeiculo("bosta");
        
        a.getViagens().add(v);
        
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
            if(a.getCnh()== eAux.getCnh()){
                eAux.setNome(a.getNome());
                eAux.setSenha(a.getSenha());
                eAux.setCategoriaHabilitacao(a.getCategoriaHabilitacao());
                eAux.setEndereco(a.getEndereco());
                eAux.setTelefoneContato(a.getTelefoneContato());
                eAux.setViagens(a.getViagens());
                
                return;
            }
        }
    }
    
    public Admin ler(int cnh){
        
        for(Admin a:this.adms){
            if(a.getCnh()==cnh){
                return a;
            }
        }
        
        return null;
    }
    
    public Admin realizarLogin(int cnh, String senha){
        for(Admin a:this.adms){
            if(a.getCnh()==cnh && a.getSenha().equals(senha)){
                return a;
            }
        }
        return null;
    }
    
    
    
}
