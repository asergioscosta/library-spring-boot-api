package org.libraryspringbootapi.model.repository;

import org.libraryspringbootapi.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
