package com.uts.inventariotienda.dao.interfaces;

import com.uts.inventariotienda.model.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    void guardar(Usuario usuario);
    Usuario obtenerPorId(int id);
    List<Usuario> obtenerTodos();
    void actualizar(Usuario usuario);
    void eliminar(int id);
}