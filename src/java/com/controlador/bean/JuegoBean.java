/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador.bean;

import com.dao.JuegoDAO;
import com.modelo.Juego;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *By me
 */
@ManagedBean (name="juegoBean")
@ViewScoped
public class JuegoBean implements Serializable
{
    private List < Juego > juegoLista;  
    private List < Juego > buscarLista;
    private List < Juego > buscarxCod;
    JuegoDAO juegodao= new JuegoDAO();
    private Juego juego = new Juego();
    
    public List < Juego > getJuego()
    {
        setJuegoLista(juegodao.Alljuegos());
        int count = getJuegoLista().size();
        return getJuegoLista();
    }
    
    public void buscaxCodigo()  
    {  
        buscarLista = juegodao.BuscarxCodigo(String.valueOf(juego.getCodJugador()));
        int count = buscarxCod.size();  
        FacesMessage mensaje= new FacesMessage(FacesMessage.SEVERITY_INFO, "Numero del codigo seleccionado:", Integer.toString(count));  
        RequestContext.getCurrentInstance().showMessageInDialog(mensaje);  
    } 
    
    public List < Juego > getJuegoLista() {
        return juegoLista;
    }

    public void setJuegoLista(List < Juego > juegoLista) {
        this.juegoLista = juegoLista;
    }

    public List < Juego > getBuscarLista() {
        return buscarLista;
    }

    public void setBuscarLista(List < Juego > buscarLista) {
        this.buscarLista = buscarLista;
    }

    public List < Juego > getBuscarxCodigo() {
        return buscarxCod;
    }

    public void setBuscarxCodigo(List < Juego > buscarxCod) {
        this.buscarxCod = buscarxCod;
    }
    
    public Juego getJuegos()
    {
        return juego;
    }
    
    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    
    
}
