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
@Table(name="jugador"    ,catalog="webbd")
public class Jugador  implements Serializable {


     private Integer codJugador;
     private String nombre;
     private String apellido;
     private String email;
     private String login;
     private String password;
     private int estado;

    public Jugador() {
    }

    public Jugador(String nombre, String apellido, String email, String login, String password, int estado) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.email = email;
       this.login = login;
       this.password = password;
       this.estado = estado;
    }
   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="cod_jugador", unique=true, nullable=false)
    public Integer getCodJugador() {
        return this.codJugador;
    }
    
    public void setCodJugador(Integer codJugador) {
        this.codJugador = codJugador;
    }

    
    @Column(name="nombre", nullable=false, length=40)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false, length=40)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="email", nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="login", nullable=false, length=30)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="password", nullable=false, length=30)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="estado", nullable=false)
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    //Este metodo escribe el valor de los objetos con un System.out.println(jugador.toString()) codigo
    @Override
    public String toString() {
        return "Jugador{" 
                + "codJugador=" + codJugador 
                + ", nombre=" + nombre 
                + ", apellido=" + apellido 
                + ", email=" + email 
                + ", login=" + login 
                + ", password=" + password 
                + ", estado=" + estado + '}';
    }

}


