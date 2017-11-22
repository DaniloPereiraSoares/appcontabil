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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Coronel Mustang
 */
@ManagedBean
@RequestScoped
public class UsuarioDAO {
    
    public List<Usuario> getAllUsuario() {
       
       Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `tb_usuario`");
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
    
}
