package br.com.ada.Industria.eolica.controller;

import br.com.ada.Industria.eolica.dto.UsuarioLogin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthController {
    @PostMapping
    public String login(@RequestBody UsuarioLogin login){
        return "";
    }
}
