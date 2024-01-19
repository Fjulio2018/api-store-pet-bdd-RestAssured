package bdd.automation.api.support.mapper;
import bdd.automation.api.support.dominio.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioMapper {

    public static Map<String, String> mapToUsuario(Usuario usuario) {
        Map<String, String> userData = new HashMap<>();
        userData.put("username", usuario.getUsername());
        userData.put("password", usuario.getPassword());
        userData.put("firstName", usuario.getFirstName());
        userData.put("lastName", usuario.getLastName());
        userData.put("email", usuario.getEmail());
        userData.put("phone", usuario.getPhone());
        userData.put("status", String.valueOf(usuario.getUserStatus()));
        userData.put("HttpStatus", "200");
        return userData;
    }
}

