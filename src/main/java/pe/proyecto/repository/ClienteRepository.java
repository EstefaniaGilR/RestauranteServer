package pe.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.proyecto.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
