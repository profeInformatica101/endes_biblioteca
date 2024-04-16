package com.endes.biblioteca.servicio;

import com.endes.biblioteca.EjemplarLibro;
import com.endes.biblioteca.Libro;

public interface IGestion {
	void agregarLibro(EjemplarLibro libro) throws Exception;
    Libro obtenerLibroPorISBN(String isbn) throws Exception;
    void actualizarLibro(EjemplarLibro libro) throws Exception;
    void eliminarLibro(String isbn) throws Exception;
}
