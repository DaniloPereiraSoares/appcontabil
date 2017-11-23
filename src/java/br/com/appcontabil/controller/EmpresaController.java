/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.controller;

import br.com.appcontabil.empresa.Empresa;
import br.com.appcontabil.empresa.EmpresaRN;
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
public class EmpresaController{

    private List<Empresa> empresa;
    private Empresa novaEmpresa;
    private final EmpresaRN empresaRN = new EmpresaRN();
    
    @PostConstruct
    public void init(){
        
        novaEmpresa = new Empresa();
        empresa = empresaRN.preencherEmpresa();
        
    }

    public List<Empresa> getEmpresa() {
        return empresa;
    }

    public Empresa getNovaEmpresa() {
        return novaEmpresa;
    }

    public void setNovaEmpresa(Empresa novaEmpresa) {
        this.novaEmpresa = novaEmpresa;
    }
    
    public String inserirEmpresa(){
        
        String msg;
        msg = empresaRN.inserirEmpresa(novaEmpresa);
        
        if (msg.equals("Ok")) {
            
            return "empresa.jsf?faces-redirect=true";
            
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        
        return null;
        
    }
    
    public String editarEmpresa(int id_empresa){
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("" + id_empresa));
        return null;
    }
    
    public String excluirEmpresa(int id_empresa){
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("", new FacesMessage("Erro de credenciais!"));
        return null;
    }
   
}
