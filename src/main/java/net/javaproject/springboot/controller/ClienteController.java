package net.javaproject.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
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

import net.javaproject.springboot.exception.ResourceNotFoundException;
import net.javaproject.springboot.model.Cliente;
import net.javaproject.springboot.repository.ClienteRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> getALLClientes() {
		return clienteRepository.findAll();
	}
	
	//build create cliente REST API
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//build get cliente by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não existe com esse id: " + id));
		return ResponseEntity.ok(cliente);
	}
	
	//build update cliente REST API
	@PutMapping("{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable long id, @RequestBody Cliente clienteDetails) {
		Cliente updateCliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não exite com esse id: " + id));
		
		updateCliente.setNome(clienteDetails.getNome());
		updateCliente.setCpf(clienteDetails.getCpf());
		updateCliente.setEndereco(clienteDetails.getEndereco());
		updateCliente.setEmail(clienteDetails.getEmail());
		
		
		clienteRepository.save(updateCliente);
		
		return ResponseEntity.ok(updateCliente);
		
	}
	
	//build delete cliente REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente com esse ip não existe: " + id));
		
		clienteRepository.delete(cliente);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
}
