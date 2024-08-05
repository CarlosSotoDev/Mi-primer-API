package com.example.APIBasicaMySQL.Model;
// Define el paquete donde se encuentra la clase Persona

import jakarta.persistence.*;
// Importa las clases y anotaciones necesarias para definir una entidad JPA

import org.springframework.data.annotation.CreatedDate;
// Importa la anotación CreatedDate para marcar la fecha de creación de la entidad

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// Importa AuditingEntityListener para habilitar la auditoría en las entidades

import java.util.Date;
// Importa la clase Date para manejar fechas

@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
// Indica que esta clase es una entidad JPA y se mapeará a la tabla "usuarios" en la base de datos
// También, configura la entidad para usar el listener de auditoría
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Marca el campo 'id' como la clave primaria y especifica que su valor se generará automáticamente
    private Long id;

    private String name;
    // Define el campo 'name' que se mapeará a una columna con el mismo nombre en la tabla "usuarios"

    @Column(name = "user_name")
    // Especifica que el campo 'userName' se mapeará a la columna "user_name" en la tabla "usuarios"
    private String userName;

    @Column(name = "date_registry")
    @CreatedDate
    // Especifica que el campo 'date' se mapeará a la columna "date_registry" en la tabla "usuarios"
    // Marca el campo 'date' para ser automáticamente poblado con la fecha de creación de la entidad
    private Date date;

    // Constructor por defecto necesario para que JPA pueda crear instancias de la entidad
    public Persona() {
    }

    // Constructor que inicializa todos los campos de la clase
    public Persona(Long id, String name, String userName, Date date) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.date = date;
    }

    // Métodos getter y setter para acceder y modificar los campos de la clase

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
