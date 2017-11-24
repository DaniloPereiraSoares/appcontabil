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
    
    public String inserirUsuario(Usuario usu){
        
        //Verifica se já existe a usuario
            List<Usuario> usuarioAll = new ArrayList<>(); 
            usuarioAll = usuarioDAO.getAllUsuario();
            
            for(Usuario u: usuarioAll){

                //Verifica se já existe nome ou login
                if (usu.getUsuario().toString().equals(u.getUsuario()) ||
                    usu.getLogin().toString().equals(u.getLogin())) {
                    
                    return "Usuário ou Login já cadastrados";
                    
                }

            }
            
        //Inseri usuario
            String msg = usuarioDAO.inserirUsuario(usu);            
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
    public String editarUsuario(Usuario usu){
        
        //Verifica se já existe a usuario
            List<Usuario> usuarioAll = new ArrayList<>(); 
            usuarioAll = usuarioDAO.getAllUsuario();
            
            for(Usuario u: usuarioAll){

                //Verifica se já existe nome ou login
                if (usu.getUsuario().toString().equals(u.getUsuario()) ||
                    usu.getLogin().toString().equals(u.getLogin())) {
                    
                    if (usu.getId_usuario() != u.getId_usuario()) {
                        
                        return "Usuário ou Login já cadastrados";
                        
                    }
                    
                }

            }
            
        //Inseri usuario
            String msg = usuarioDAO.editarUsuario(usu);
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
    public List<Usuario> preencherUsuario(){
        
        return usuarioDAO.getAllUsuario();
        
    }
    
    public String excluirUsuario(Usuario usu){
        
        //Exclui empresa
            String msg = usuarioDAO.excluirUsuario(usu);
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
}
