package br.ifsp.demo.tarefas.categorias;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categorias")
@NoArgsConstructor
public class CategoriaDAO {
    @Id
    private int id;
    private String nome;
    private String descricao;

    public CategoriaDAO(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
