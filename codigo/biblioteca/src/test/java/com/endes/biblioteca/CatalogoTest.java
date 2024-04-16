package com.endes.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatalogoTest {

    private Catalogo catalogo;
    private EjemplarLibro libro;

    @BeforeEach
    public void setUp() {
        catalogo = new Catalogo();
        libro = new EjemplarLibro("978-0307476463", "Cien años de soledad", null, 432, "1234567890");
    }

    @Test
    @DisplayName("Agregar libro al catálogo")
    public void testAgregarLibro() throws Exception {
        catalogo.agregarLibro(libro);
        assertNotNull(catalogo.obtenerLibroPorISBN("978-0307476463"));
    }

    @Test
    @DisplayName("Agregar libro duplicado")
    public void testAgregarLibroDuplicado() {
        assertThrows(Exception.class, () -> {
            catalogo.agregarLibro(libro);
            catalogo.agregarLibro(libro);
        });
    }

    @Test
    @DisplayName("Obtener libro por ISBN")
    public void testObtenerLibroPorISBN() throws Exception {
        catalogo.agregarLibro(libro);
        assertEquals(libro, catalogo.obtenerLibroPorISBN("978-0307476463"));
    }

    @Test
    @DisplayName("Actualizar libro en el catálogo")
    public void testActualizarLibro() throws Exception {
        catalogo.agregarLibro(libro);
        
        libro.setTitulo("Cien años de soledad (Edición especial)");
        catalogo.actualizarLibro(libro);
        
        assertEquals("Cien años de soledad (Edición especial)", catalogo.obtenerLibroPorISBN("978-0307476463").getTitulo());
    }

    @Test
    @DisplayName("Eliminar libro del catálogo")
    public void testEliminarLibro() throws Exception {
        catalogo.agregarLibro(libro);
        catalogo.eliminarLibro("978-0307476463");
        assertNull(catalogo.obtenerLibroPorISBN("978-0307476463"));
    }

    @Test
    @DisplayName("Encontrar libro por título")
    public void testEncontrarLibroPorTitulo() throws Exception {
        catalogo.agregarLibro(libro);
        assertEquals(libro, catalogo.encontrarLibroPorTituto("Cien años de soledad"));
    }

    @Test
    @DisplayName("No encontrar libro por título")
    public void testNoEncontrarLibroPorTitulo() {
        assertNull(catalogo.encontrarLibroPorTituto("Cronica de una muerte anunciada"));
    }
}