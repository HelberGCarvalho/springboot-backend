package net.javaproject.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaproject.springboot.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
         //all crud database methods
}
