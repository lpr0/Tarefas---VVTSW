package br.ifsp.demo.tarefas;

import br.ifsp.demo.tarefas.categorias.Categoria;

import java.time.LocalDate;
import java.util.UUID;

public class Tarefa {
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDate dataInsercao;
    private LocalDate dataLimite;
    private Categoria categoria;

    private Estado estado;

}
