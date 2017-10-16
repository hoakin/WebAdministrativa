package com.modelo;
// Generated 13/10/2017 02:16:51 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * By me
 */
@Entity
@Table(name = "juego",  catalog= "webbd")
public class Juego  implements Serializable {


     private Integer codJuego;
     private int codJugador;
     private int codNivel;
     private int aciertos;
     private int fallos;
     private String tiempo;
     private String estado;

    public Juego() {
    }

    public Juego(int codJugador, int codNivel, int aciertos, int fallos, String tiempo, String estado) {
       this.codJugador = codJugador;
       this.codNivel = codNivel;
       this.aciertos = aciertos;
       this.fallos = fallos;
       this.tiempo = tiempo;
       this.estado = estado;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="cod_juego", unique=true, nullable=false)
    public Integer getCodJuego() {
        return this.codJuego;
    }
    
    public void setCodJuego(Integer codJuego) {
        this.codJuego = codJuego;
    }

    
    @Column(name="cod_jugador", nullable=false)
    public int getCodJugador() {
        return this.codJugador;
    }
    
    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    
    @Column(name="cod_nivel", nullable=false)
    public int getCodNivel() {
        return this.codNivel;
    }
    
    public void setCodNivel(int codNivel) {
        this.codNivel = codNivel;
    }

    
    @Column(name="aciertos", nullable=false)
    public int getAciertos() {
        return this.aciertos;
    }
    
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    
    @Column(name="fallos", nullable=false)
    public int getFallos() {
        return this.fallos;
    }
    
    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    
    @Column(name="tiempo", nullable=false, length=20)
    public String getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    
    @Column(name="estado", nullable=false, length=20)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Este metodo escribe el valor de los objetos con un System.out.println(juego.toString()) codig
    @Override
    public String toString() {
        return "Juego{" 
                + "codJuego=" + codJuego 
                + ", codJugador=" + codJugador 
                + ", codNivel=" + codNivel 
                + ", aciertos=" + aciertos 
                + ", fallos=" + fallos 
                + ", tiempo=" + tiempo 
                + ", estado=" + estado + '}';
    }




}


