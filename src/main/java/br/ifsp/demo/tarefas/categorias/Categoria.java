package br.ifsp.demo.tarefas.categorias;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Categoria {
    private int id;
    private String nome;
    private String descricao;

    private Categorias cats = null;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Categoria)) return false;
        return this.id == ((Categoria) obj).id;
    }

    protected Categoria(int id, String nome, String descricao, Categorias cats) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cats = cats;
    }

    public CategoriaDTO toDTO() {
        return new CategoriaDTO(id, nome, descricao);
    }
}
