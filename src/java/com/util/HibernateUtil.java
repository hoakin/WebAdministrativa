package com.util;

import org.hibernate.SessionFactory;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;  
public class HibernateUtil  
{  
    //Anotaciones base para la configuracion 
    private static SessionFactory sessionFactory;  
    private static SessionFactory buildSessionFactory()  
    {  
        try  
        {  
            // crear la SessionFactory de hibernate.cfg.xml  
            Configuration configuration = new Configuration();  
            configuration.configure("/hibernate.cfg.xml");  
            System.out.println("Hibernate Annotation Configuracion creada");  
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();  
            System.out.println("Hibernate Annotation Servicio de registro creado");  
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
            return sessionFactory;  
        }  
        catch (Throwable ex)  
        {  
            // Agregar una excepcion  
            System.err.println("Fallo la creacion de la sesion factory." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
    public static SessionFactory getSessionFactory()  
    {  
        if (sessionFactory == null) sessionFactory = buildSessionFactory();  
        return sessionFactory;  
    }  
    public static void shutdown()  
    {  
        // Close caches and connection pools  
        sessionFactory.close();  
    }  
}
