package br.ifsp.demo.controller;

import br.ifsp.demo.security.auth.AuthenticationInfoService;
import br.ifsp.demo.tarefas.Tarefa;
import br.ifsp.demo.tarefas.TarefaDAO;
import br.ifsp.demo.tarefas.TarefaDTO;
import br.ifsp.demo.tarefas.TarefaRepository;
import br.ifsp.demo.tarefas.categorias.CategoriaRepository;
import br.ifsp.demo.tarefas.categorias.Categorias;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tarefas")
@CrossOrigin
@Tag(name = "Tarefas")
public class TransactionController {

    private final AuthenticationInfoService authService;
    private final CategoriaRepository categoriaRepository;
    private final TarefaRepository tarefaRepository;
    private final Categorias categorias;

    public TransactionController(
            AuthenticationInfoService authService, CategoriaRepository categoriaRepository,
            TarefaRepository tarefaRepository
    ) {
        this.authService = authService;
        this.categoriaRepository = categoriaRepository;
        this.tarefaRepository = tarefaRepository;
        categorias = new Categorias(categoriaRepository);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listarTarefas() {
        return ResponseEntity.ok(tarefaRepository.findAll().stream().map(TarefaDAO::toDTO).toList());
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody final CriarTarefaDTO dto) {
        final Tarefa tarefa = new Tarefa (
                dto.titulo(), dto.descricao(), categorias.getCategoria(dto.categoriaID()), dto.dataLimite());

        tarefaRepository.save(new TarefaDAO(
                tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataInsercao(),
                tarefa.getDataLimite(), tarefa.getCategoria().getId(), tarefa.getEstado()));

        return ResponseEntity.ok(tarefa.toDTO());
    }
}
