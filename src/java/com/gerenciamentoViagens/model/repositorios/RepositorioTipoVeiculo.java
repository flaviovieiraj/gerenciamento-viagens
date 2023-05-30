/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.TipoVeiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioTipoVeiculo {
    private static RepositorioTipoVeiculo myself = null;
    
    private List<TipoVeiculo> tiposVeiculo;
    
    private int ultimoIndice = 1;
    
    private RepositorioTipoVeiculo (){
        this.tiposVeiculo = new ArrayList<>();     
        
        TipoVeiculo tipo1 = new TipoVeiculo();
        
        tipo1.setTipo("Carro de passeio");
        tipo1.setDescricao("Veiculo com 5 lugares");
        tipo1.setCodigo(ultimoIndice);
        
        this.tiposVeiculo.add(tipo1);
        
    }
    
    public static RepositorioTipoVeiculo getCurrentInstance(){
    if(myself==null)
        RepositorioTipoVeiculo.myself = new RepositorioTipoVeiculo();
    return myself;
}
    
    public void inserir(TipoVeiculo e){
        e.setCodigo(this.ultimoIndice++);
        this.tiposVeiculo.add(e);
    }
    
    public void alterar(TipoVeiculo e){
        for(TipoVeiculo eAux:this.tiposVeiculo){
            if(e.getCodigo() == eAux.getCodigo()){
                eAux.setDescricao(e.getDescricao());
                eAux.setTipo(e.getTipo());
                
                return;
            }
        }
    }
    
    public TipoVeiculo ler (int codigo){
        for(TipoVeiculo e:this.tiposVeiculo){
            if(e.getCodigo()==codigo){
                return e;
            }
        }
        
        return null;
    }
    
    public void deletar(int codigo){
        
        TipoVeiculo aux = null;
        for(TipoVeiculo e:this.tiposVeiculo){
            if(e.getCodigo()==codigo){
                
                aux = e;
                break;
                
            }
        }
        if(aux!=null)
            this.tiposVeiculo.remove(aux);
    }
    
    public List<TipoVeiculo> lerTudo(){
        return this.tiposVeiculo;
    }
}
