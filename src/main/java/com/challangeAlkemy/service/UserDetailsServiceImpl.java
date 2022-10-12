package com.challangeAlkemy.service;
import com.challangeAlkemy.excepciones.UsuarioNoExiste;
import com.challangeAlkemy.repository.UserRepositorio;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Autentica un usuario de la base de datos
 *
 * Authentication Manager llama al método loadUserByUsername de esta clase
 * para obtener los detalles del usuario de la base de datos cuando
 * se intente autenticar un usuario
 */
@Service
@ApiModel("UserServiceImple clase tipo servicio donde se implemanta toda la logica de users ")

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositorio userRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        com.challangeAlkemy.entities.User user = userRepositorio.findByUsername(nombre)
                .orElseThrow(() -> new UsuarioNoExiste(HttpStatus.NOT_FOUND, " El usuario no existe!!!"));

        return new org.springframework.security.core.userdetails.User(
                user.getNombre(), user.getPassword(),new ArrayList<>());
    }

}
