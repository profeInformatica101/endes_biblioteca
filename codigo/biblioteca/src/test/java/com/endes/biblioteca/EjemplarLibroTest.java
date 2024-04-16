package com.endes.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EjemplarLibroTest {


    private EjemplarLibro ejemplar;
    private List<Autor> autor;

    @BeforeEach
    public void setUp() {
        autor = new ArrayList<>();
        autor.add(new Autor("Gabriel García Márquez", "Escritor colombiano, premio Nobel de Literatura en 1982."));
        ejemplar = new EjemplarLibro("978-0307476463", "Cien años de soledad", autor, 432, "1234567890");
    }

    @Test
    public void testGetCodigoDeBarras() {
        assertEquals("1234567890", ejemplar.getCodigoDeBarras());
    }

    @Test
    public void testSetCodigoDeBarras() {
        ejemplar.setCodigoDeBarras("0987654321");
        assertEquals("0987654321", ejemplar.getCodigoDeBarras());
    }

    @Test
    public void testGetPrestado() {
        assertNull(ejemplar.getPrestado());
    }

    @Test
    public void testSetPrestado() {
        Date fechaPrestamo = new Date();
        ejemplar.setPrestado(fechaPrestamo);
        assertEquals(fechaPrestamo, ejemplar.getPrestado());
    }

    @Test
    public void testGetReservado() {
        assertNull(ejemplar.getReservado());
    }

    @Test
    public void testSetReservado() {
        Date fechaReserva = new Date();
        ejemplar.setReservado(fechaReserva);
        assertEquals(fechaReserva, ejemplar.getReservado());
    }

}
