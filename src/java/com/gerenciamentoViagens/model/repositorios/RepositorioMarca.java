/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.repositorios;

import com.gerenciamentoViagens.model.entities.Marca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flaviovieira
 */
public class RepositorioMarca {
    private static RepositorioMarca myself =null;
    
    private List<Marca> marcas;
    
    private int ultimoIndice = 1;
    
    private RepositorioMarca(){
        this.marcas = new ArrayList<>();
        
        Marca marca1 = new Marca();
        
        marca1.setCodigo(ultimoIndice);
        marca1.setNome("Honda");
        marca1.setNacionalidade("Japão");
        marca1.setDescricao("blablabla");
        
        this.marcas.add(marca1);
    }
    
    public static RepositorioMarca getCurrentInstance(){
        if(myself==null)
            RepositorioMarca.myself = new RepositorioMarca();
        return myself;
    }
    
    public void inserir(Marca m){
        m.setCodigo(this.ultimoIndice++);
        this.marcas.add(m);
    }
    
    public void alterar(Marca m){
        for(Marca eAux:this.marcas){
            if(m.getCodigo() == eAux.getCodigo()){
                eAux.setDescricao(m.getDescricao());
                eAux.setNacionalidade(m.getNacionalidade());
                eAux.setNome(m.getNome());
                
                return;
            }
        }
    }
    
    public Marca ler (int codigo){
        for(Marca m:this.marcas){
            if(m.getCodigo()==codigo){
                return m;
            }
        }
        return null;
    }
    
    public void deletar(int codigo){
        Marca aux = null;
        for(Marca m:this.marcas){
            if(m.getCodigo()==codigo){
                aux = m;
                break;
            }
        }
        if(aux!=null)
            this.marcas.remove(aux);
    }
    
    public List<Marca> lerTudo(){
        return this.marcas;
    }
}
