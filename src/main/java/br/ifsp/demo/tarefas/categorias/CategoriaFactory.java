package br.ifsp.demo.tarefas.categorias;

import jakarta.persistence.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CategoriaFactory {

    private static final Map<Integer, Categoria> categorias = new HashMap<Integer, Categoria>();

    public static Categoria getCategoria(int x, CategoriaRepository rep) {
        if (categorias.containsKey(x)) return categorias.get(x);

        Optional<CategoriaDAO> dao = rep.findById(x);
        if (dao.isEmpty()) throw new EntityNotFoundException();

        Categoria cat =  new Categoria(dao.get().toDTO());
        categorias.put(x, cat);

        return cat;
    }
}
