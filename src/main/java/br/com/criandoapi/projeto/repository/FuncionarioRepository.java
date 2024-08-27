package br.com.criandoapi.projeto.repository;

import br.com.criandoapi.projeto.entidade.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
