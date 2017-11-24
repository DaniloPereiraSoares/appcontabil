/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.appcontabil.controller;

import br.com.appcontabil.subgrupo.Subgrupo;
import br.com.appcontabil.subgrupo.SubgrupoRN;
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
public class SubgrupoController {
    
    private final SubgrupoRN subgrupoRN = new SubgrupoRN();
    private Subgrupo subgrupo;
    private Subgrupo editarSubgrupo;
    
    @PostConstruct
    public void init(){        
        subgrupo = new Subgrupo();
        editarSubgrupo = new Subgrupo();        
    }

    public Subgrupo getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(Subgrupo subgrupo) {
        this.subgrupo = subgrupo;
    }

    public Subgrupo getEditarSubgrupo() {
        return editarSubgrupo;
    }

    public void setEditarSubgrupo(Subgrupo editarSubgrupo) {
        this.editarSubgrupo = editarSubgrupo;
    }
    
    public List<Subgrupo> listarSubgrupo(){
        
        return subgrupoRN.preencherSubgrupo();
        
    }
    
    public String inserirSubgrupo(){
        
        String msg;
        msg = subgrupoRN.inserirSubgrupo(subgrupo);
        
        if (msg.equals("Ok")) {
            
            return "subgrupo.jsf?faces-redirect=true";
            
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
        
    }
    
    public String edtSubgrupo(Subgrupo usu){
        
        editarSubgrupo = usu;
        return "subgrupo_editar";
        
    }
    
    public String editarSubgrupo(){
        
        String msg;
        msg = subgrupoRN.editarSubgrupo(editarSubgrupo);
        
        if (msg.equals("Ok")) {
            
            return "subgrupo.jsf?faces-redirect=true";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
    }
    
    public String excluirSubgrupo(Subgrupo usu){
        
        String msg;
        msg = subgrupoRN.excluirSubgrupo(usu);
        
        if (msg.equals("Ok")) {
            
            return "subgrupo.jsf?faces-redirect=true";
            
        } else {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage(msg));
            
        }
        
        return null;
    }
    
}
