package org.libraryspringbootapi.model.repository;

import org.libraryspringbootapi.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
