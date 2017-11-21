/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.balanco;

/**
 *
 * @author Coronel Mustang
 */
public class Balanco {
    
    private int id_balanco;
    private int fk_empresa;
    private int ano;
    private int mes;

    public int getId_balanco() {
        return id_balanco;
    }

    public void setId_balanco(int id_balanco) {
        this.id_balanco = id_balanco;
    }

    public int getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(int fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
}
