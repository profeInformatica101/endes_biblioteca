package com.endes.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class LibroTest {

    private Libro libro;
    private List<Autor> autores;

    @BeforeEach
    public void setUp() {
        autores = new ArrayList<>();
        autores.add(new Autor("Gabriel García Márquez", "Escritor colombiano, premio Nobel de Literatura en 1982."));
        libro = new EjemplarLibro("123","Cien años de soledad", autores);
    }

    @Test
    @DisplayName("Obtener título del libro")
    public void testGetTitulo() {
        assertEquals("Cien años de soledad", libro.getTitulo());
    }

    @Test
    @DisplayName("Obtener autores del libro")
    public void testGetAutores() {
        assertNotNull(libro.getAutores());
        assertEquals(1, libro.getAutores().size());
        assertEquals("Gabriel García Márquez", libro.getAutores().get(0).getNombre());
    }

    @Test
    @DisplayName("Obtener número de páginas del libro")
    public void testGetNumeroDePaginas() {
        assertEquals(432, libro.getNumeroDePaginas());
    }

    @Test
    @DisplayName("Establecer título del libro")
    public void testSetTitulo() {
        libro.setTitulo("El amor en los tiempos del cólera");
        assertEquals("El amor en los tiempos del cólera", libro.getTitulo());
    }

    @Test
    @DisplayName("Establecer autores del libro")
    public void testSetAutores() {
        List<Autor> nuevosAutores = new ArrayList<>();
        nuevosAutores.add(new Autor("Jorge Luis Borges", "Escritor argentino, uno de los autores más destacados del siglo XX."));
        libro.setAutores(nuevosAutores);

        assertNotNull(libro.getAutores());
        assertEquals(1, libro.getAutores().size());
        assertEquals("Jorge Luis Borges", libro.getAutores().get(0).getNombre());
    }

    @Test
    @DisplayName("Establecer número de páginas del libro")
    public void testSetNumeroDePaginas() {
        libro.setNumeroDePaginas(350);
        assertEquals(350, libro.getNumeroDePaginas());
    }
}