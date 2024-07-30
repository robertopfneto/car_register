package br.edu.ifms.Carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.Carros.modelo.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
