package br.ifsp.demo.tarefas;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Tarefas")
@NoArgsConstructor
public class TarefaDAO {
    @Id
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDate dataInsercao;
    private LocalDate dataLimite;
    private int categoria;
    private Estado estado;

    public TarefaDAO (UUID id, String titulo, String descricao,
                      LocalDate dataInsercao, LocalDate dataLimite, int categoria, Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInsercao = dataInsercao;
        this.dataLimite = dataLimite;
        this.categoria = categoria;
        this.estado = estado;
    }

    public TarefaDTO toDTO() {
        return new TarefaDTO(
                this.id, this.titulo, this.descricao, this.dataInsercao, this.dataLimite, this.categoria, this.estado
        );
    }
}
