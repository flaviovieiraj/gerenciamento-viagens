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
        
        Marca m1 = new Marca();
        Marca m2 = new Marca();
        Marca m3 = new Marca();
        Marca m4 = new Marca();
        Marca m5 = new Marca();
        
        m1.setCodigo(ultimoIndice);
        m1.setNome("Honda");
        m1.setNacionalidade("Japão");
        m1.setDescricao("blablabla");
        
        this.marcas.add(m1);
        
        m2.setCodigo(ultimoIndice);
       m2.setNome("Fiat");
       m2.setNacionalidade("Italia");
       m2.setDescricao("dsfafdafds");
       
       this.marcas.add(m2);
       
       m3.setCodigo(ultimoIndice);
       m3.setNome("Volkswagen");
       m3.setNacionalidade("Alemanha");
       m3.setDescricao("sfdlkakljfsa");
       
       this.marcas.add(m3);
       
       m4.setCodigo(ultimoIndice);
       m4.setNome("Chevrolet");
       m4.setNacionalidade("EUA");
       m4.setDescricao("cxvkzlcxvkl");
       
       this.marcas.add(m4);
       
       m5.setCodigo(ultimoIndice);
       m5.setNome("Renault");
       m5.setNacionalidade("França");
       m5.setDescricao("xcvzcvxkm");
       
       this.marcas.add(m5);
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
