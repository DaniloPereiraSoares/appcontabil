/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.grupo;

import java.util.List;

/**
 *
 * @author Coronel Mustang
 */
public class GrupoRN {
    
    private final GrupoDAO grupoDAO = new GrupoDAO();
    
    public List<Grupo> preencherGrupo(){
        
        return grupoDAO.getAllGrupos();
        
    }
    
}
