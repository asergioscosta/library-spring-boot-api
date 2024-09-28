package org.libraryspringbootapi.service;

import org.libraryspringbootapi.model.entity.Livro;
import org.libraryspringbootapi.model.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    private LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) throws Exception {
        Optional<Livro> livro = livroRepository.findById(id);
        if (!livro.isPresent()) {
            throw new Exception("Livro não encontrado");
        }
        return livro.get();
    }

    public Livro save(Livro livro) throws Exception {
        if (livro.getTituloLivro() == null || livro.getTituloLivro().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (livro.getAutorLivro() == null) {
            throw new Exception("Autor inválido. Digite um nome válido.");
        }

        if (livro.getQuantidadePaginas() <= 0) {
            throw new Exception("Quantidade de páginas inválida. Deve ser um número positivo.");
        }

        if (livro.getDataPublicacao() == null) {
            throw new Exception("Data inválida. Digite uma data válida.");
        }

        return livroRepository.save(livro);
    }

    public Livro delete(Long id) throws Exception {
        Optional<Livro> livro = livroRepository.findById(id);
        if (!livro.isPresent()) {
            throw new Exception("Livro não encontrado");
        }
        livroRepository.delete(livro.get());
        return livro.get();
    }

    public Long count() {
        return livroRepository.count();
    }
}
