package br.ifsp.demo.tarefas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaRepository extends JpaRepository<TarefaDAO, UUID> {
}
