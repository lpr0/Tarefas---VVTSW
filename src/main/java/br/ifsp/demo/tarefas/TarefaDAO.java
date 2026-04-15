package br.ifsp.demo.tarefas;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Tarefas")
public class TarefaDAO {
    @Id
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDate dataInsercao;
    private LocalDate dataLimite;
    private int categoria;
    private Estado estado;
}
