package br.com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.criandoapi.projeto.entidade.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findByLoginAndSenha(String login, String senha);
}
