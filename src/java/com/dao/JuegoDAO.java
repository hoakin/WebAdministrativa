/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import com.modelo.Juego;
import java.util.List;  
import java.util.ArrayList;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import com.util.HibernateUtil; 
/**
 *By me
 */
public class JuegoDAO
{
    
    private Juego juego;
    private List < Juego > MostrarJuego;
    private List < Juego > Buscarjuego;
    
    //sesion
    
    public List < Juego > Alljuegos()
    {
        //iniciamos la sesion
        Session session =HibernateUtil.getSessionFactory().openSession(); 
        try {
                session.beginTransaction();
                MostrarJuego = session.createCriteria(Juego.class).list();
                int contar = MostrarJuego.size();
       
                session.getTransaction().commit();
                
        } catch (Exception e) 
        {
            e.printStackTrace();  
            session.getTransaction().rollback(); 
        }
        session.close();
        return MostrarJuego;
    }
    
    public Integer getCod()
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
      String sql = "select max(J.cod_juego) from juego J";
      Query query = session.createQuery(sql);  
        List < Integer > results = query.list();  
        Integer juegoId = 1;  
        if (results.get(0) != null)  
        {  
            juegoId = results.get(0) + 1;  
        }  
        session.flush();  
        session.close();  
        return juegoId;  
    }
    
    public List < Juego > BuscarxCodigo(String jugadorcod)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List < Juego > listabuscar = new ArrayList < > ();
        
        try {
            session.beginTransaction();
            Query q= session.createQuery("From juego J Where J.cod_jugador=:codjugador"); //Codigo de la base de dato
            q.setParameter("codjugador", Integer.parseInt(jugadorcod));  
            listabuscar = q.list();  
            int count = listabuscar.size();  
            session.getTransaction().commit(); 
            
        } catch (Exception e) 
        {
            e.printStackTrace();  
            session.getTransaction().rollback(); 
        }
        finally
        {
            session.close();
        }
        return listabuscar;
    }

}
