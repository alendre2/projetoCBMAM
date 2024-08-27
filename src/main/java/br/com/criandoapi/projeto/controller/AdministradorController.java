package br.com.criandoapi.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.entidade.Administrador;
import br.com.criandoapi.projeto.repository.AdministradorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorRepository dao;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Administrador admin) {
        Administrador foundAdmin = dao.findByLoginAndSenha(admin.getLogin(), admin.getSenha());
        if (foundAdmin != null) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}
