package br.ifsp.demo.tarefas.categorias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaDAO, Integer> {
}
