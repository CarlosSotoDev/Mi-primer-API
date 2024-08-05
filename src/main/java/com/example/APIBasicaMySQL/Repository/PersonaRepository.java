package com.example.APIBasicaMySQL.Repository;
// Define el paquete donde se encuentra la interfaz PersonaRepository

import com.example.APIBasicaMySQL.Model.Persona;
// Importa la clase Persona desde el paquete Model

import org.springframework.data.jpa.repository.JpaRepository;
// Importa JpaRepository, que proporciona métodos CRUD y operaciones básicas de consulta

import org.springframework.data.repository.query.Param;
// Importa la anotación Param, que se utiliza para nombrar parámetros en las consultas

import org.springframework.stereotype.Repository;
// Importa la anotación Repository, que indica que esta interfaz es un componente de acceso a datos

import java.util.List;
// Importa la clase List, que representa una colección de elementos

@Repository
// Marca la interfaz como un repositorio, un componente de acceso a datos en Spring
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Declara una interfaz que extiende JpaRepository para la entidad Persona y su clave primaria de tipo Long

    List<Persona> findByName(@Param("name") String name);
    // Define un método de consulta personalizado para encontrar personas por su nombre
    // @Param("name") vincula el parámetro del método al nombre del parámetro en la consulta
}

