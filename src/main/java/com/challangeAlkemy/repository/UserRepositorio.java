package com.challangeAlkemy.repository;

import com.challangeAlkemy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositorio extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM app_users WHERE nombre =  :filtro" ,nativeQuery = true)
    Optional<User> findByUsername(@Param("filtro") String filtro);

    @Query(value = "SELECT nombre FROM app_users WHERE app_users.nombre = :filtro" ,nativeQuery = true)
    String existsByUsername(String filtro);

    @Query(value = "SELECT email FROM app_users WHERE app_users.email = :filtro" ,nativeQuery = true)
    String existEmail(String filtro);
}
