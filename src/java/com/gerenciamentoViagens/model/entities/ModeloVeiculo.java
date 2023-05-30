/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenciamentoViagens.model.entities;

/**
 *
 * @author flaviovieira
 */
public class ModeloVeiculo {
    
    private int codigo;
    private String nome;
    private int quantidadeLugares;
    private double pesoMaximo;
    private String tipoCombustivel;
    private String informacoesAdicionais;
    private String habilitacaoExigida;
    
    // informações de outras classes
    private Marca marca;
    private String tipo;
    
    public String getMarca(){
        return marca.getNome();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public String getHabilitacaoExigida() {
        return habilitacaoExigida;
    }

    public void setHabilitacaoExigida(String habilitacaoExigida) {
        this.habilitacaoExigida = habilitacaoExigida;
    }
    
    
}
