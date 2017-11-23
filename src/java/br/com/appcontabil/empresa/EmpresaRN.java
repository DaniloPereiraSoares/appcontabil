/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.empresa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Coronel Mustang
 */
public class EmpresaRN {
    
    private final EmpresaDAO empresaDAO = new EmpresaDAO();
    
    public List<Empresa> preencherEmpresa(){
        
        return empresaDAO.getAllEmpresa();
                
    }
    
    public String inserirEmpresa(Empresa e){
        
        //Verifica se já existe a empresa
            List<Empresa> empresaAll = new ArrayList<>(); 
            empresaAll = empresaDAO.getAllEmpresa();
            
            for(Empresa emp: empresaAll){

                if (emp.getEmpresa().toString().equals(e.getEmpresa().toString()) ||
                    emp.getCnpj().toString().equals(e.getCnpj().toString())) {

                    return "Empresa ou CNPJ já cadastrados";

                }

            }
            
        //Inseri empresa
            String msg = empresaDAO.inserirEmpresa(e);            
            
            if(msg.equals("ok")){  
                
                return "Ok";
                
            }else {
                
                return msg;  
                
            }
        
    }
    
}
