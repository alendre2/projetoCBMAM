package br.com.criandoapi.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.entidade.Cliente;
import br.com.criandoapi.projeto.repository.ClienteRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository dao;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listaClientes () {
		List<Cliente> lista = (List<Cliente>) dao.findAll();
		return ResponseEntity.status(200).body(lista);
   }
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
		Cliente clienteNovo = dao.save(cliente);
		return ResponseEntity.status(201).body(clienteNovo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> editarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
	    if (!dao.existsById(id)) {
	        return ResponseEntity.notFound().build(); // Retorna 404 se o cliente não existir
	    }
	    cliente.setId(id); // Define o ID do cliente a ser atualizado
	    Cliente clienteAtualizado = dao.save(cliente);
	    return ResponseEntity.ok(clienteAtualizado); // Retorna 200 OK com o cliente atualizado
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirCliente (@PathVariable Integer id) {
		dao.deleteById(id);
		return ResponseEntity.status(204).build();
	}
	
	
}
