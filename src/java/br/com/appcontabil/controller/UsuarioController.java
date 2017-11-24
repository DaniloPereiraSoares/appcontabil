/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.controller;

import br.com.appcontabil.usuario.Usuario;
import br.com.appcontabil.usuario.UsuarioRN;
import java.util.List;
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
public class UsuarioController {
    
    private final UsuarioRN usuarioRN = new UsuarioRN();
    private Usuario usuario;
    private Usuario editarUsuario;
    
    @PostConstruct
    public void init(){        
        usuario = new Usuario();
        editarUsuario = new Usuario();        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getEditarUsuario() {
        return editarUsuario;
    }

    public void setEditarUsuario(Usuario editarUsuario) {
        this.editarUsuario = editarUsuario;
    }
    
    public List<Usuario> listarUsuario(){
        
        return usuarioRN.preencherUsuario();
        
    }
    
    public String inserirEmpresa(){
        
        String msg;
        msg = usuarioRN.inserirUsuario(usuario);
        
        if (msg.equals("Ok")) {
            
            return "usuario.jsf?faces-redirect=true";
            
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
        
    }
    
    public String edtUsuario(Usuario usu){
        
        editarUsuario = usu;
        return "usuario_editar";
        
    }
    
    public String editarUsuario(){
        
        String msg;
        msg = usuarioRN.editarUsuario(editarUsuario);
        
        if (msg.equals("Ok")) {
            
            return "usuario.jsf?faces-redirect=true";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
    }
    
    public String excluirUsuario(Usuario usu){
        
        String msg;
        msg = usuarioRN.excluirUsuario(usu);
        
        if (msg.equals("Ok")) {
            
            return "usuario.jsf?faces-redirect=true";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
    }
    
}
