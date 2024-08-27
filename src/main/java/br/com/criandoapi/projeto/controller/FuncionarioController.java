package br.com.criandoapi.projeto.controller;

import br.com.criandoapi.projeto.entidade.Funcionario;
import br.com.criandoapi.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository dao;

	@GetMapping
	public ResponseEntity<List<Funcionario>> listarFuncionarios() {
		List<Funcionario> lista = (List<Funcionario>) dao.findAll();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<Funcionario> criarFuncionario(@Validated @RequestBody Funcionario funcionario) {
		Funcionario funcionarioNovo = dao.save(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioNovo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> editarFuncionario(@PathVariable Long id, @Validated @RequestBody Funcionario funcionario) {
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(id);
		Funcionario funcionarioAtualizado = dao.save(funcionario);
		return ResponseEntity.ok(funcionarioAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dao.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
