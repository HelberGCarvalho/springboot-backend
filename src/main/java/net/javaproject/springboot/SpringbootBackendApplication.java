package net.javaproject.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaproject.springboot.model.Cliente;
import net.javaproject.springboot.repository.ClienteRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Cliente cliente = new Cliente();
//		cliente.setNome("Helber Carvalho");
//		cliente.setCpf("12345678974");
//		cliente.setEndereco("Rua João Augusto Paiva");
//		cliente.setEmail("helber@.com");
//		clienteRepository.save(cliente);
//		
//		Cliente cliente1 = new Cliente();
//		cliente1.setNome("Fabiana Carvalho");
//		cliente1.setCpf("11111111111");
//		cliente1.setEndereco("Rua João Augusto Paiva");
//		cliente1.setEmail("fabiana@.com");
//		clienteRepository.save(cliente1); 
		
	}

}
