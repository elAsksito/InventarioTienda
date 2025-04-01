package com.uts.inventariotienda.dao.interfaces;

import com.uts.inventariotienda.dto.LoginDTO;
import com.uts.inventariotienda.model.Usuario;

public interface ILoginDAO {
    Usuario login(LoginDTO loginDTO);
}