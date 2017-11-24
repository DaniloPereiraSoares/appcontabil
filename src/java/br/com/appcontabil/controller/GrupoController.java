/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.controller;

import br.com.appcontabil.grupo.Grupo;
import br.com.appcontabil.grupo.GrupoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Coronel Mustang
 */
@ManagedBean
@RequestScoped
public class GrupoController {
    
    private final GrupoRN grupoRN = new GrupoRN();
    
    public List<Grupo> listarGrupo(){
        
        return grupoRN.preencherGrupo();
        
    }
    
}
