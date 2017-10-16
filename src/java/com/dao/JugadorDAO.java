package com.dao;
import com.modelo.Jugador;
import java.util.List;   
import org.hibernate.Query;  
import org.hibernate.Session;  
import com.util.HibernateUtil; 
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
/**
 *By me
 */
public class JugadorDAO 
{
    private Jugador jugador;
    private Jugador nuevojugador;
    
    public Integer getID()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();  
        String hql = "select max(J.cod_jugador) from jugador J";  
        Query query = session.createQuery(hql);  
        List < Integer > results = query.list();  
        Integer jugadorId = 1;  
        if (results.get(0) != null)  
        {  
            jugadorId = results.get(0) + 1;  
        }  
        session.flush();  
        session.close();  
        return jugadorId;
    }

    //se agrega a la base de datos
    public void Agregar(Jugador newjugador)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            
            //String Id = Integer.toString(newjugador.getEstado());
            //comenzamos la transaccion
            session.beginTransaction();
            session.merge(newjugador);
            session.flush();
            /*System.out.println("Jugador agregado, cod:"+
                       newjugador.getCodJugador());*/
            session.getTransaction().commit();
            } 
        catch (Exception e) 
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void Borrar(Jugador jugador)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String name = jugador.getNombre();
            session.beginTransaction();
            session.delete(name);
            session.getTransaction().commit();  
            } 
        catch (Exception e) 
        {   e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void modificar(Jugador jugador)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            session.update(jugador);
            session.flush();
            session.getTransaction().commit();
            
            } 
        catch (Exception e) 
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
   /* public void validar(String login, String password)
    {
      Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q =session.createQuery("from jugador where login=:login and password=:password");
            q.setParameter("login", login);
            q.setParameter("password", password);
            List listar=q.list();
            int count = listar.size();
            
            FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "nombre",login);
            RequestContext.getCurrentInstance().showMessageInDialog(message1);
        } catch (Exception e) {
        }
      
    }*/
}
