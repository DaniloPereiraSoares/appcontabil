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
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;

/**
 *
 * @author Coronel Mustang
 */

@ManagedBean
@RequestScoped
public class EmpresaController{

    private Empresa empresa;
    private Empresa excluirEmpresa;
    private Empresa editarEmpresa;
    private final EmpresaRN empresaRN = new EmpresaRN();

    @PostConstruct
    public void init(){
        empresa = new Empresa();
        editarEmpresa = new Empresa();
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEditarEmpresa() {
        return editarEmpresa;
    }

    public void setEditarEmpresa(Empresa editarEmpresa) {
        this.editarEmpresa = editarEmpresa;
    }
    
    public List<Empresa> listarEmpresa(){
        
        return empresaRN.preencherEmpresa();
        
    }
    
    public String inserirEmpresa(){
        
        String msg;
        msg = empresaRN.inserirEmpresa(empresa);
        
        if (msg.equals("Ok")) {
            
            return "empresa.jsf?faces-redirect=true";
            
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        
        return null;
        
    }
    
    public String edtEmpresa(Empresa emp){
        
        editarEmpresa = emp;
        return "empresa_editar";
        
    }
    
    public String editarEmpresa(){
        
        String msg;
        msg = empresaRN.editarEmpresa(editarEmpresa);
        
        if (msg.equals("Ok")) {
            
            return "empresa.jsf?faces-redirect=true";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
    }
    
    public String excluirEmpresa(Empresa emp){
        
        String msg;
        msg = empresaRN.excluirEmpresa(emp);
        
        if (msg.equals("Ok")) {
            
            return "empresa.jsf?faces-redirect=true";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
    }
   
}
