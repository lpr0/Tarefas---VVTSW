package br.ifsp.demo.tarefas.categorias;

import jakarta.persistence.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Categorias {

    private static final Map<Integer, Categoria> categorias = new HashMap<Integer, Categoria>();
    private CategoriaRepository rep;

    public Categorias(CategoriaRepository rep) {
        this.rep = rep;
    }

    public Categoria getCategoria(int x) {
        if (categorias.containsKey(x)) return categorias.get(x);

        Optional<CategoriaDAO> dao = rep.findById(x);
        if (dao.isEmpty()) throw new EntityNotFoundException();

        CategoriaDTO dto = dao.get().toDTO();

        Categoria cat =  new Categoria(dto.id(), dto.nome(), dto.descricao(), this);
        categorias.put(x, cat);

        return cat;
    }
}
