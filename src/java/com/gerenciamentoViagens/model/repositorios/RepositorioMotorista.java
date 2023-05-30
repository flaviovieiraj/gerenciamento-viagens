/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Motorista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioMotorista {
    private static RepositorioMotorista myself = null;
    
    private List<Motorista> motoristas;
    
    
    private RepositorioMotorista(){
        this.motoristas = new ArrayList<>();
        
        Motorista motor1 = new Motorista();
        
        motor1.setNome("Joao");
        motor1.setCnh(12345678);
        motor1.setEndereco("Rua dois, numero 1");
        motor1.setCategoriaHabilitacao("A");
        motor1.setTelefoneContato("99998888");
        
        this.motoristas.add(motor1);
        
    }
    
    public static RepositorioMotorista getCurrentInstance(){
        if(myself==null)
            RepositorioMotorista.myself = new RepositorioMotorista();
        return myself;
    }
    
    public void inserir(Motorista m){
        this.motoristas.add(m);
    }
    
    public void alterar(Motorista m){
        for(Motorista eAux:this.motoristas){
            if(m.getCnh() == eAux.getCnh()){
                eAux.setCategoriaHabilitacao(m.getCategoriaHabilitacao());
                eAux.setEndereco(m.getEndereco());
                eAux.setNome(m.getNome());
                eAux.setTelefoneContato(m.getTelefoneContato());
                
                return;
                
            }
        }
    }
    
    public Motorista ler(int cnh){
        for(Motorista m:this.motoristas){
            if(m.getCnh()==cnh){
                return m;
            }
        }
        return null;
    }
    
    public void deletar(int cnh){
        Motorista aux = null;
        for(Motorista m:this.motoristas){
            if(m.getCnh()==cnh){
                aux = m;
                break;
            }
        }
        if(aux!=null)
            this.motoristas.remove(aux);
    }
    
    public List<Motorista> lerTudo(){
        return this.motoristas;
    }
}
