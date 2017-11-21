/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.grupo;
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
public class GrupoDAO {
    
    public List<Grupo> getAllGrupos() {
       
       Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("select * from tb_grupo");
           ResultSet rs = stmt.executeQuery();
           List<Grupo> data = new ArrayList<>();
           
           while (rs.next()){
               
                Grupo g = new Grupo();
                
                g.setId_grupo(rs.getInt("id_grupo"));
                g.setGrupo(rs.getString("grupo"));                
                data.add(g);
           
           }
           
            return data;
            
       }catch(SQLException e ){
       
           
       }
       
        return null;
    
    }
    
    public String inserirGrupo(Grupo g){
        
        Connection conn = Conexao.getConexao();
        
        try{
           
           String sql = new String("INSERT INTO `tb_usuario` (`id_grupo`, `grupo`) VALUES (NULL, ?)");           
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, g.getGrupo());     
           stmt.execute();
           stmt.close();
           
           return "";
            
       }catch(SQLException e ){
       
           
       }
       
        return "Algo de errado ocorreu";
        
    }
    
    public String alterarGrupo(Grupo g){
        
        Connection conn = Conexao.getConexao();
        
        try{
           
           String sql = new String("UPDATE `tb_grupo` SET `grupo`=? WHERE `id_grupo`=?");           
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString(1, g.getGrupo()); 
           stmt.setInt(2, g.getId_grupo()); 
           stmt.execute();
           stmt.close();
           
           return "";
            
       }catch(SQLException e ){
       
           
       }
       
        return "Algo de errado ocorreu";
        
    }
    
    public void deleteGrupo(Grupo g) {

        Connection conn = Conexao.getConexao();
        String Sql = "DELETE FROM `tb_grupo` where `id_grupo` = ? ";

        try {
            PreparedStatement stmt = conn.prepareStatement(Sql);
            stmt.setInt(1, g.getId_grupo());
            stmt.execute();
            stmt.close();

        } catch  (SQLException e)  {
                e.printStackTrace();

            }
    }
    
}
