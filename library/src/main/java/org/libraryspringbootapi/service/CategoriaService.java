package org.libraryspringbootapi.service;

import org.libraryspringbootapi.model.entity.Categoria;
import org.libraryspringbootapi.model.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) throws Exception {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (!categoria.isPresent()) {
            throw new Exception("Categoria não encontrada");
        }
        return categoria.get();
    }

    public Categoria save(Categoria categoria) throws Exception {
        if (categoria.getNomeCategoria() == null || categoria.getNomeCategoria().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (categoria.getDescricaoCategoria() == null) {
            throw new Exception("Descrição inválida. Digite uma descrição válida.");
        }
        return categoriaRepository.save(categoria);
    }

    public Categoria delete(Long id) throws Exception {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (!categoria.isPresent()) {
            throw new Exception("Categoria não encontrada");
        }
        categoriaRepository.delete(categoria.get());
        return categoria.get();
    }

    public Long count() {
        return categoriaRepository.count();
    }
}
