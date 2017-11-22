/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Coronel Mustang
 */
@ManagedBean
@RequestScoped
public class UsuarioRN {
    
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public Boolean validarUsuario(Usuario u){
        
        //Pega todos usuarios
            List<Usuario> allUsuario = new ArrayList<>();
            allUsuario = usuarioDAO.getAllUsuario();
        
        //Verifica se login e senha são validos
        for(Usuario us: allUsuario){
            
            if (u.getLogin().equals(us.getLogin()) && 
                u.getSenha().equals(us.getSenha())) {
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
}
