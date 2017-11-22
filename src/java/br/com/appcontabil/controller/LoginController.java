/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.controller;

import br.com.appcontabil.usuario.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Coronel Mustang
 */

@Named
@ViewScoped
public class LoginController{

    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String inicarSessao(){
        
        return "Ola";
    
    }

    
   
}
