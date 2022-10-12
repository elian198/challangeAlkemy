package com.challangeAlkemy.repository;

import com.challangeAlkemy.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneroRepositorio extends CrudRepository<Genero, Long> {
}
