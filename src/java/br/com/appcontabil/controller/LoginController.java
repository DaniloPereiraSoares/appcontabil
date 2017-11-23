/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.controller;

import br.com.appcontabil.usuario.Usuario;
import br.com.appcontabil.usuario.UsuarioRN;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Coronel Mustang
 */

@ManagedBean
@RequestScoped
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
        
        UsuarioRN usuarioRN = new UsuarioRN();
        
        if (usuarioRN.validarUsuario(usuario) == true) {
            
            return "inicio";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ok", new FacesMessage("Erro de credenciais!"));
            return null;
        
        }
        
    }

    
   
}
