package br.com.criandoapi.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoapi.projeto.entidade.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
