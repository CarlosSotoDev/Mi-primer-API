package com.example.APIBasicaMySQL.Controller;
// Define el paquete donde se encuentra la clase PersonaControlador

import com.example.APIBasicaMySQL.Model.Persona;
// Importa la clase Persona desde el paquete Model

import com.example.APIBasicaMySQL.Repository.PersonaRepository;
// Importa la interfaz PersonaRepository desde el paquete Repository

import org.springframework.beans.factory.annotation.Autowired;
// Importa la anotación Autowired para inyectar dependencias automáticamente

import org.springframework.web.bind.annotation.*;
// Importa las anotaciones necesarias para definir un controlador REST y sus mapeos

import java.util.List;
// Importa la clase List, que representa una colección de elementos

@RestController
@RequestMapping("/api")
// Marca la clase como un controlador REST y define la ruta base para todas las solicitudes
public class PersonaControlador {

    @Autowired
    // Inyecta automáticamente una instancia de PersonaRepository
    private PersonaRepository repository;

    @GetMapping("/persona")
    // Mapea las solicitudes GET a /api/personas a este método
    public List<Persona> todasPersonas() {
        // Devuelve una lista de todas las personas en la base de datos
        return repository.findAll();
    }

    @GetMapping("/persona/{name}")
    // Mapea las solicitudes GET a /api/persona/{name} a este método
    public List<Persona> findByName(@PathVariable("name") String name) {
        // Devuelve una lista de personas cuyo nombre coincida con el parámetro de la ruta
        return repository.findByName(name);
    }

    @PostMapping("/persona")
    // Mapea las solicitudes POST a /api/persona a este método
    public Persona crearPersona(@RequestBody Persona persona) {
        // Crea una nueva persona en la base de datos
        return repository.save(persona);
    }

    @PutMapping("/persona/{id}")
    // Mapea las solicitudes PUT a /api/persona/{id} a este método
    public Persona actualizarPersona(@PathVariable int id, @RequestBody Persona persona) {
        // Actualiza una persona existente en la base de datos
        return repository.save(persona);
    }

    @DeleteMapping("/persona/{id}")
    // Mapea las solicitudes DELETE a /api/persona/{id} a este método
    public void borrarPersona(@PathVariable("id") Long id) {
        // Elimina una persona de la base de datos por su ID
        repository.deleteById(id);
    }
}
