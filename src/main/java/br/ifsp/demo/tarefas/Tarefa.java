package br.ifsp.demo.tarefas;

import br.ifsp.demo.tarefas.categorias.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Tarefa {
    private final UUID id;
    private String titulo;
    private String descricao;
    private final LocalDate dataInsercao;
    private LocalDate dataLimite;
    private Categoria categoria;

    private Estado estado;

    public Tarefa(String titulo, String descricao, Categoria categoria, LocalDate dataLimite) {
        if (titulo == null || descricao == null || dataLimite == null || categoria == null) throw new IllegalArgumentException();
        if (titulo.isBlank() || descricao.isBlank()) throw new IllegalArgumentException();
        if (dataLimite.isBefore(LocalDate.now())) throw new IllegalArgumentException();

        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataInsercao = LocalDate.now();
        this.dataLimite = dataLimite;
        this.estado = Estado.PENDENTE;
        this.id = UUID.randomUUID();
    }

    public TarefaDTO toDTO() {
        return new TarefaDTO(
                this.id, this.titulo, this.descricao, this.dataInsercao, this.dataLimite, this.categoria.getId(), this.estado
        );
    }
}
