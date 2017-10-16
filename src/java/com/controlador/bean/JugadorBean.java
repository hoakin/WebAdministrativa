/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador.bean;

import com.dao.JugadorDAO;
import com.modelo.Jugador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.context.RequestContext;

/**
 *By me
 */
@ManagedBean (name="jugadorBean")
@ViewScoped
public class JugadorBean implements Serializable{

    JugadorDAO jugadordao = new JugadorDAO();
    Jugador jugador = new Jugador();
    Jugador newjugador = new Jugador();
    Jugador validajugador= new Jugador();
    
    
    public void addJugador()
    {
        //para aumentar el codigo de 1 en 1
        /*Integer jugadorcod= 0;
        jugadorcod = jugadordao.getID();
        newjugador.setCodJugador(jugadorcod);*/
        int est= 1;
        newjugador.setEstado(est);
        jugadordao.Agregar(newjugador);
        System.out.println("Jugador agregado");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "Usuario Registrado.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        newjugador= new Jugador();
    }
    
    public void ModificarJugador(Jugador user)
    {
        String nombre = user.getNombre();
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "nombre",nombre);
        RequestContext.getCurrentInstance().showMessageInDialog(message1);
        jugadordao.modificar(user);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "Usuario Modificado.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        jugador= new Jugador(); 
    }
    
    public void BorrarJugador(Jugador user)
    {
        String nombre = user.getNombre();
        jugadordao.Borrar(user);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "Usuario borrado.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
   
    
    /*public void EditarFila(RowEditEvent event)
    {
        //FacesMessage msg= new FacesMessage("",((jugador) event.getObject().));
       // FacesContext.getCurrentInstance().addMessage(null, msg);
        Jugador editarjugador= (Jugador) event.getObject();
        jugadordao.modificar(editarjugador);
    }
    
    public void Cancelareditar()
    {
        FacesMessage msg = new FacesMessage("Edit Cancelled");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }*/
    
    public JugadorBean() {
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getNewjugador() {
        return newjugador;
    }

    public void setNewjugador(Jugador newjugador) {
        this.newjugador = newjugador;
    }

    public Jugador getValidajugador() {
        return validajugador;
    }

    public void setValidajugador(Jugador validajugador) {
        this.validajugador = validajugador;
    }
    
    
}
