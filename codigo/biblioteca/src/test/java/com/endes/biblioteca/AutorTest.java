package com.endes.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AutorTest {

        private Autor autor;
        private List<Libro> libros;

        @BeforeEach
        public void setUp() {
            autor = new Autor("Gabriel García Márquez", "Escritor colombiano, premio Nobel de Literatura en 1982.");

           
            libros = new ArrayList<>();
            libros.add(new EjemplarLibro("Cien años de soledad"));
            libros.add(new EjemplarLibro("El amor en los tiempos del cólera"));
            autor.setLibrosEscritos(libros);
        }

        @Test
        @DisplayName("Obtener nombre del autor")
        public void testGetNombre() {
            assertEquals("Gabriel García Márquez", autor.getNombre());
        }

        @Test
        @DisplayName("Obtener biografía del autor")
        public void testGetBiografia() {
            assertEquals("Escritor colombiano, premio Nobel de Literatura en 1982.", autor.getBiografia());
        }

        @Test
        @DisplayName("Obtener libros escritos por el autor")
        public void testGetLibrosEscritos() {
            assertNotNull(autor.getLibrosEscritos());
            assertEquals(2, autor.getLibrosEscritos().size());
            assertEquals("Cien años de soledad", autor.getLibrosEscritos().get(0).getTitulo());
            assertEquals("El amor en los tiempos del cólera", autor.getLibrosEscritos().get(1).getTitulo());
        }

        @Test
        @DisplayName("Establecer nombre del autor")
        public void testSetNombre() {
            autor.setNombre("Jorge Luis Borges");
            assertEquals("Jorge Luis Borges", autor.getNombre());
        }

        @Test
        @DisplayName("Establecer biografía del autor")
        public void testSetBiografia() {
            autor.setBiografia("Escritor argentino, uno de los autores más destacados del siglo XX.");
            assertEquals("Escritor argentino, uno de los autores más destacados del siglo XX.", autor.getBiografia());
        }

        @Test
        @DisplayName("Establecer libros escritos por el autor")
        public void testSetLibrosEscritos() {
            List<Libro> nuevosLibros = new ArrayList<>();
            nuevosLibros.add(new EjemplarLibro("Ficciones"));
            nuevosLibros.add(new EjemplarLibro("El Aleph"));
            autor.setLibrosEscritos(nuevosLibros);
            
            assertNotNull(autor.getLibrosEscritos());
            assertEquals(2, autor.getLibrosEscritos().size());
            assertEquals("Ficciones", autor.getLibrosEscritos().get(0).getTitulo());
            assertEquals("El Aleph", autor.getLibrosEscritos().get(1).getTitulo());
        }
    }

