package com.endes.biblioteca;

import org.junit.jupiter.api.Test;

import com.endes.biblioteca.stub.LibroStub;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class AutorTest {

	private Autor autor;
    private LibroStub libroStub;
    private final String NOMBRE_TEST = "Gabriel García Márquez";
    private final String BIOGRAFIA_TEST = "Autor de Cien Años de Soledad y premio Nobel de literatura.";
    
    @BeforeEach
    void setUp() {
        autor = new Autor();
        libroStub = new LibroStub();
    }

    @Test
    @DisplayName("Comprobar que los setters y getters de nombre y biografía funcionan correctamente")
    void givenNombreAndBiografia_whenSettersCalled_thenGettersReturnSameValues() {
        autor.setNombre(NOMBRE_TEST);
        autor.setBiografia(BIOGRAFIA_TEST);

        assertEquals(NOMBRE_TEST, autor.getNombre(), "El nombre del autor debería coincidir con el establecido");
        assertEquals(BIOGRAFIA_TEST, autor.getBiografia(), "La biografía del autor debería coincidir con el establecido");
    }

    @Test
    @DisplayName("Comprobar que la lista de libros escritos se establece y recupera correctamente")
    void givenLibrosEscritosList_whenSettersCalled_thenGettersReturnSameList() {
        List<Libro> librosEscritosTest = Collections.singletonList(libroStub);
        autor.setLibrosEscritos(librosEscritosTest);

        assertNotNull(autor.getLibrosEscritos(), "La lista de libros escritos no debería ser nula");
        assertEquals(1, autor.getLibrosEscritos().size(), "La lista de libros escritos debería tener un elemento");
        assertEquals(libroStub, autor.getLibrosEscritos().get(0), "La lista de libros escritos debería contener el libro establecido");
    }

    
}


