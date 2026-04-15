package br.ifsp.demo.tarefas.categorias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categorias")
public class CategoriaDAO {
    @Id
    private int id;
    private String nome;
    private String descricao;
}
