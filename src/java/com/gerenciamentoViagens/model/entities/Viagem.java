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
public class Viagem {
    
    private int codigo;
    private String dataHoraInicio;
    private String dataHoraRetorno;
    private String motivo;
    private String valorCombustivel;
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getDataHoraRetorno() {
        return dataHoraRetorno;
    }

    public void setDataHoraRetorno(String dataHoraRetorno) {
        this.dataHoraRetorno = dataHoraRetorno;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getValorCombustivel() {
        return valorCombustivel;
    }

    public void setValorCombustivel(String valorCombustivel) {
        this.valorCombustivel = valorCombustivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
