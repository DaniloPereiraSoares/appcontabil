/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.conta;

/**
 *
 * @author Coronel Mustang
 */
public class Conta {
    
    private int id_conta;
    private int fk_subgrupo;
    private int fk_empresa;
    private String conta;
    private String subgrupo;
    private String empresa;
    private Double valor;

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    public int getFk_subgrupo() {
        return fk_subgrupo;
    }

    public void setFk_subgrupo(int fk_subgrupo) {
        this.fk_subgrupo = fk_subgrupo;
    }

    public int getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(int fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
 
}
