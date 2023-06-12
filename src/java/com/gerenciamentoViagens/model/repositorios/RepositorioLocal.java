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
        Local l2 = new Local();
        Local l3 = new Local();
        
        l1.setCidade("Ipojuca");
        l1.setCodigo(1);
        l1.setDescricao("Casa no litoral");
        l1.setEndereco("Rua 1");
        l1.setEstado("Pernambuco");
        l1.setPontoReferencia("Longe");
        l1.setNome("Casa de praia");        
        this.locais.add(l1);
        
        l2.setCidade("Caruaru");
        l2.setCodigo(2);
        l2.setEndereco("Rua 22");
        l2.setDescricao("Casa no interior");
        l2.setEstado("Pernamuco");
        l2.setNome("Casa da vo");
        l2.setPontoReferencia("fasdçsfdaksl");
        this.locais.add(l2);
        
        l3.setCidade("Sao Paulo");
        l3.setEstado("Sao Paulo");
        l3.setNome("Algum lugar");
        l3.setEndereco("Avenida paulista");
        l3.setDescricao("safdsafas");
        l3.setCodigo(3);
        l3.setPontoReferencia("fdsalçfsasf");
        this.locais.add(l3);
        
        ultimoIndice = 4;
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
    