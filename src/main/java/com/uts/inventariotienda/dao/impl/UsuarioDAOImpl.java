package com.uts.inventariotienda.dao.impl;

import com.uts.inventariotienda.dao.interfaces.IUsuarioDAO;
import com.uts.inventariotienda.hibernate.HibernateUtil;
import com.uts.inventariotienda.model.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAOImpl implements IUsuarioDAO{

    @Override
    public void guardar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Usuario obtenerPorId(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;

        try {
            usuario = session.get(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> usuarios = null;

        try {
            usuarios = session.createQuery("from Usuario", Usuario.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void eliminar(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
