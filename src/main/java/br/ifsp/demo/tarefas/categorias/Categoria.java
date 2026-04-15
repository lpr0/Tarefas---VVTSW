package br.ifsp.demo.tarefas.categorias;

import lombok.Getter;

@Getter
public class Categoria {
    private int id;
    private String nome;
    private String descricao;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Categoria)) return false;
        return this.id == ((Categoria) obj).id;
    }

    public Categoria(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria(CategoriaDTO dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.descricao = dto.descricao();
    }
}
