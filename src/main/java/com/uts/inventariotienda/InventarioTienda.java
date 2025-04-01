package com.uts.inventariotienda;

import static com.uts.inventariotienda.hibernate.HibernateUtil.getSessionFactory;
import static com.uts.inventariotienda.hibernate.HibernateUtil.shutDown;
import org.hibernate.Session;

public class InventarioTienda {
    public static void main(String[] args){
        System.out.println("Probando Hibernate");
        try(Session session = getSessionFactory().openSession()){
            System.out.println("Éxito");
        } catch (Exception e){
            System.err.println("Error" + e.getMessage());
        } finally{
            shutDown();
        }
    }
}