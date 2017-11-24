/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.subgrupo;
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
public class SubgrupoDAO {
    
    public List<Subgrupo> getAllSubgrupo() {
       
       Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("SELECT id_subgrupo, subgrupo, fk_grupo, fk_empresa, b.grupo, c.empresa FROM tb_subgrupo INNER JOIN tb_grupo b ON fk_grupo = b.id_grupo INNER JOIN tb_empresa c ON fk_empresa = c.id_empresa");
           ResultSet rs = stmt.executeQuery();
           List<Subgrupo> data = new ArrayList<>();
           
           while (rs.next()){
               
                Subgrupo subg = new Subgrupo();
                
                subg.setId_subgrupo(rs.getInt("id_subgrupo"));
                subg.setSubgrupo(rs.getString("subgrupo"));
                subg.setFk_grupo(rs.getInt("fk_grupo"));
                subg.setFk_empresa(rs.getInt("fk_empresa"));
                subg.setGrupo(rs.getString("grupo"));
                subg.setEmpresa(rs.getString("empresa"));
                data.add(subg);
           
           }
           
            return data;
            
       }catch(SQLException e ){
       
           
       }
       
        return null;
    
    }
    
    public String inserirSubgrupo(Subgrupo subg){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("INSERT INTO tb_subgrupo (subgrupo, fk_grupo, fk_empresa) VALUES (?,?,?)");
           stmt.setString(1, subg.getSubgrupo());
           stmt.setInt(2, subg.getFk_grupo());
           stmt.setInt(3, subg.getFk_empresa());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
    public String editarSubgrupo(Subgrupo subg){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("UPDATE tb_subgrupo SET subgrupo=?, fk_grupo=?, fk_empresa=? WHERE id_subgrupo=?");
           stmt.setString(1, subg.getSubgrupo());
           stmt.setInt(2, subg.getFk_grupo());
           stmt.setInt(3, subg.getFk_empresa());
           stmt.setInt(4, subg.getId_subgrupo());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
    public String excluirSubgrupo(Subgrupo subg){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("DELETE FROM tb_subgrupo WHERE id_subgrupo=?");
           stmt.setInt(1, subg.getId_subgrupo());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
       
    }
    
}
