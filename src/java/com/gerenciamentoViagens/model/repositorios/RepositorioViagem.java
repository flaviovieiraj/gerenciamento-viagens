/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Viagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioViagem {
    
    private static RepositorioViagem myself = null;
    
    private List<Viagem> viagens;
    
    
    private RepositorioViagem(){
        this.viagens = new ArrayList<>();
        
        
    }
    
    public static RepositorioViagem getCurrentInstance(){
        if (myself==null)
            RepositorioViagem.myself = new RepositorioViagem();
        return myself;
    }
    
    public void inserir(Viagem vg){
        
        this.viagens.add(vg);
    }
    
    public void alterar(Viagem vg){
        for(Viagem vgAux:this.viagens){
            if(vg.getCodigo() == vgAux.getCodigo()){
                vgAux.setDataInicio(vg.getDataInicio());
                vgAux.setDataRetorno(vg.getDataRetorno());
                vgAux.setDescricao(vg.getDescricao());
                vgAux.setHoraInicio(vg.getHoraInicio());
                vgAux.setHoraRetorno(vg.getHoraRetorno());
                vgAux.setLocalDestino(vg.getLocalDestino());
                vgAux.setModeloVeiculo(vg.getModeloVeiculo());
                vgAux.setMotivo(vg.getMotivo());
                vgAux.setMotorista(vg.getMotorista());
                vgAux.setValorCombustivel(vg.getValorCombustivel());
                
                return;
                
            }
        }
    }
    
    public Viagem ler(int codigo){
        for(Viagem vg:this.viagens){
            if(vg.getCodigo()==codigo){
                return vg;
            }
        }
        return null;
    }
    
    public void deletar(int codigo){
        Viagem aux = null;
        for(Viagem vg:this.viagens){
            if(vg.getCodigo()==codigo){
                aux = vg;
                break;
            }
        }
        if(aux!=null)
            this.viagens.remove(aux);
    }
    
    public List<Viagem>lerTudo(){
        return this.viagens;
    }
    
}
