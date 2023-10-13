package br.net.galdino.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.galdino.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
