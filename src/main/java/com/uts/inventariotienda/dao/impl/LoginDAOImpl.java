package com.uts.inventariotienda.dao.impl;

import com.uts.inventariotienda.dao.interfaces.ILoginDAO;
import com.uts.inventariotienda.dto.LoginDTO;
import com.uts.inventariotienda.hibernate.HibernateUtil;
import com.uts.inventariotienda.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginDAOImpl implements ILoginDAO{

    @Override
    public Usuario login(LoginDTO loginDTO) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        
        try {
            Query<Usuario> query = session.createQuery("FROM Usuario WHERE emailUsuario = :email", Usuario.class);
            query.setParameter("email", loginDTO.getEmail());
            usuario = query.uniqueResult();

            if (usuario != null && usuario.getPasswordUsuario().equals(loginDTO.getPassword())) {
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}