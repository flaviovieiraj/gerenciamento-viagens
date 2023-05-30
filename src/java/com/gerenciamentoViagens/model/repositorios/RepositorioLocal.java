/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Local;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioLocal {
    private static RepositorioLocal myself = null;
    
    private List<Local> locais;
    
    private int ultimoIndice = 1;
    
    private RepositorioLocal(){
        this.locais = new ArrayList<>();
        
        Local l1 = new Local();
        
        l1.setCidade("Recife");
        l1.setCodigo(ultimoIndice);
        l1.setDescricao("Minha casa");
        l1.setEndereco("Rua dos Bobos, 0");
        l1.setEstado("Pernambuco");
        l1.setPontoReferencia("Depois da PQP");
        l1.setNome("Casa");
        
        this.locais.add(l1);
    }
    
    public static RepositorioLocal getCurrentInstance(){
        if(myself==null)
            RepositorioLocal.myself = new RepositorioLocal();
        return myself;
    }
    
    public void inserir(Local x){
        x.setCodigo(this.ultimoIndice++);
        this.locais.add(x);
    }
    
    public void alterar(Local x){
        for(Local eAux:this.locais){
            if(x.getCodigo() == eAux.getCodigo()){
                eAux.setCidade(x.getCidade());
                eAux.setDescricao(x.getDescricao());
                eAux.setEndereco(x.getEndereco());
                eAux.setEstado(x.getEstado());
                eAux.setNome(x.getNome());
                eAux.setPontoReferencia(x.getPontoReferencia());
                
                return;
            }
        }
    }
    
    public Local ler(int codigo){
        for(Local x:this.locais){
            if(x.getCodigo()==codigo){
                return x;
            }
        }
        return null;
    }
    
    public void deletar(int codigo){
        Local aux = null;
        for(Local x:this.locais){
            if(x.getCodigo()==codigo){
                aux = x;
                break;
            }
        }
        if(aux!=null)
            this.locais.remove(aux);
    }
    
    public List<Local> lerTudo(){
        return this.locais;
    }
}
