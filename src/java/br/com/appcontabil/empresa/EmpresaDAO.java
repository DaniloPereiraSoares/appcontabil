/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.empresa;

import br.com.appcontabil.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @aethor Coronel Mestang
 */

public class EmpresaDAO {
    
    public List<Empresa> getAllEmpresa() {
       
       Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tb_empresa");
           ResultSet rs = stmt.executeQuery();
           List<Empresa> data = new ArrayList<>();
           
           while (rs.next()){
               
                Empresa e = new Empresa();
                
                e.setId_empresa(rs.getInt("id_empresa"));
                e.setEmpresa(rs.getString("empresa"));
                e.setCnpj(rs.getString("cnpj"));
                                
                data.add(e);
           
           }
           
            return data;
            
       }catch(SQLException e ){
       
           
       }
       
        return null;
    
    }
    
    public String inserirEmpresa(Empresa emp){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("INSERT INTO tb_empresa (empresa, cnpj) VALUES (?,?)");
           stmt.setString(1, emp.getEmpresa());
           stmt.setString(2, emp.getCnpj());           
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
    public String editarEmpresa(Empresa emp){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("UPDATE tb_empresa SET empresa=?, cnpj=? WHERE id_empresa=?");
           stmt.setString(1, emp.getEmpresa());
           stmt.setString(2, emp.getCnpj());
           stmt.setInt(3, emp.getId_empresa());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
    public String excluirEmpresa(Empresa emp){
        
        Connection conn = Conexao.getConexao();
       
       try{
           
           PreparedStatement stmt = conn.prepareStatement("DELETE FROM tb_empresa where id_empresa = ? ");
           stmt.setInt(1, emp.getId_empresa());
           stmt.execute();    
           
           return "ok";
            
       }catch(SQLException e ){
       
           return "" + e.getMessage();
           
       }
        
    }
    
}
