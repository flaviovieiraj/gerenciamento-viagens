/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioModelo {
    
    private static RepositorioModelo myself = null;
    
    private List<Modelo> modelos;
    
    private RepositorioModelo(){
        this.modelos = new ArrayList<>();
        
        Modelo modelo1 = new Modelo();
        modelo1.setCodigo(1);
        modelo1.setMarca("Fiat");
        modelo1.setNome("Palio");
        modelo1.setTipoVeiculo("Passeio");
        
        this.modelos.add(modelo1);
        
    }
    
    public static RepositorioModelo getCurrentInstance(){
        if(myself==null)
            RepositorioModelo.myself = new RepositorioModelo();
         return myself;
    }
    
    public void inserir(Modelo mod){
        this.modelos.add(mod);
    }
    
    public void alterar(Modelo mod){
        for(Modelo eAux:this.modelos){
            if(mod.getCodigo() == eAux.getCodigo()){
                eAux.setNome(mod.getNome());
                eAux.setMarca(mod.getMarca());
                eAux.setTipoVeiculo(mod.getTipoVeiculo());
                
                return;
            }
        }
    }
    
    public Modelo ler(int codigo){
        for(Modelo mod:this.modelos){
            if(mod.getCodigo()==codigo){
                return mod;
            }
        }
        return null;
    }
    
    public void deletar(int codigo){
        Modelo aux = null;
        for(Modelo mod:this.modelos){
            if(mod.getCodigo()==codigo){
                aux = mod;
                break;
            }
        }
        if(aux!= null)
            this.modelos.remove(aux);
    }
    
    public List<Modelo> lerTudo(){
        return this.modelos;
    }
    
}
