/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.subgrupo;

/**
 *
 * @author Coronel Mustang
 */
public class Subgrupo {
    
    private int id_subgrupo;
    private int fk_grupo;
    private String subgrupo;

    public int getId_subgrupo() {
        return id_subgrupo;
    }

    public void setId_subgrupo(int id_subgrupo) {
        this.id_subgrupo = id_subgrupo;
    }

    public int getFk_grupo() {
        return fk_grupo;
    }

    public void setFk_grupo(int fk_grupo) {
        this.fk_grupo = fk_grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }
    
}
