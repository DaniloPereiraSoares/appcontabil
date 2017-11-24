/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.subgrupo;
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
public class SubgrupoRN {
    
    private final SubgrupoDAO subgrupoDAO = new SubgrupoDAO();
    
    public String inserirSubgrupo(Subgrupo subg){
        
        //Verifica se já existe a subgrupo
            List<Subgrupo> subgrupoAll = new ArrayList<>(); 
            subgrupoAll = subgrupoDAO.getAllSubgrupo();
            
            for(Subgrupo sb: subgrupoAll){

                //Verifica se ja existe subgrupo in empresa
                if (subg.getFk_empresa() == sb.getFk_empresa() &&
                    subg.getSubgrupo().toString().equals(sb.getSubgrupo().toString())) {
                    
                    return "Subgrupo já cadastrado nesta empresa";
                    
                }

            }
            
        //Inseri subgrupo
            String msg = subgrupoDAO.inserirSubgrupo(subg);            
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
    public String editarSubgrupo(Subgrupo subg){
        
        //Verifica se já existe a subgrupo
            List<Subgrupo> subgrupoAll = new ArrayList<>(); 
            subgrupoAll = subgrupoDAO.getAllSubgrupo();
            
            for(Subgrupo sb: subgrupoAll){

                //Verifica se ja existe subgrupo in empresa
                if (subg.getFk_empresa() == sb.getFk_empresa() &&
                    subg.getSubgrupo().toString().equals(sb.getSubgrupo().toString())) {
                    
                    if (subg.getId_subgrupo() != sb.getId_subgrupo()) {
                        
                        return "Subgrupo já cadastrado nesta empresa";
                        
                    }                    
                    
                }

            }
            
        //Inseri subgrupo
            String msg = subgrupoDAO.editarSubgrupo(subg);
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
    public List<Subgrupo> preencherSubgrupo(){
        
        return subgrupoDAO.getAllSubgrupo();
        
    }
    
    public String excluirSubgrupo(Subgrupo subg){
        
        //Exclui empresa
            String msg = subgrupoDAO.excluirSubgrupo(subg);
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
}
