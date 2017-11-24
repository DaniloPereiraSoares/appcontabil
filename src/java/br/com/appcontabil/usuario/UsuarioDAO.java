/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.usuario;
import br.com.appcontabil.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Coronel Mustang
 */
public class UsuarioDAO {
    
    public List<Usuario> getAllUsuario() {
       
       Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tb_usuario");
           ResultSet rs = stmt.executeQuery();
           List<Usuario> data = new ArrayList<>();
           
           while (rs.next()){
               
                Usuario u = new Usuario();
                
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                                
                data.add(u);
           
           }
           
            return data;
            
       }catch(SQLException e ){
       
           
       }
       
        return null;
    
    }
    
    public String inserirUsuario(Usuario usu){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("INSERT INTO tb_usuario (usuario, login, senha) VALUES (?,?,?)");
           stmt.setString(1, usu.getUsuario());
           stmt.setString(2, usu.getLogin());
           stmt.setString(3, usu.getSenha());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
    public String editarUsuario(Usuario usu){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("UPDATE tb_usuario SET usuario=?, login=?, senha=? WHERE id_usuario=?");
           stmt.setString(1, usu.getUsuario());
           stmt.setString(2, usu.getLogin());
           stmt.setString(3, usu.getSenha());
           stmt.setInt(4, usu.getId_usuario());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
    public String excluirUsuario(Usuario usu){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("DELETE FROM tb_usuario WHERE id_usuario=?");
           stmt.setInt(1, usu.getId_usuario());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
       
    }
    
}
