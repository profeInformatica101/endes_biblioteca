package com.endes.biblioteca;



import java.util.HashMap;
import java.util.Map;

import com.endes.biblioteca.servicio.IBusqueda;
import com.endes.biblioteca.servicio.IGestion;

public class Catalogo implements  IBusqueda, IGestion{

	private Map<String, Libro> librosPorISBN = new HashMap<>();
    private Map<String, Libro> librosPorTitulo = new HashMap<>();

    @Override
    public void agregarLibro(EjemplarLibro libro) throws Exception {
        if (librosPorISBN.containsKey(libro.getIsbn())) {
            throw new Exception("El libro con ISBN " + libro.getIsbn() + " ya existe.");
        }
        librosPorISBN.put(libro.getIsbn(), libro);
        librosPorTitulo.put(libro.getTitulo(), libro);
    }

    @Override
    public Libro obtenerLibroPorISBN(String isbn) throws Exception {
        if (!librosPorISBN.containsKey(isbn)) {
            throw new Exception("No se encontró el libro con ISBN " + isbn);
        }
        return librosPorISBN.get(isbn);
    }

    @Override
    public void actualizarLibro(EjemplarLibro libro) throws Exception {
        if (!librosPorISBN.containsKey(libro.getIsbn())) {
            throw new Exception("No se puede actualizar porque no existe el libro con ISBN " + libro.getIsbn());
        }
        librosPorISBN.put(libro.getIsbn(), libro);
        librosPorTitulo.put(libro.getTitulo(), libro);
    }

    @Override
    public void eliminarLibro(String isbn) throws Exception {
        if (!librosPorISBN.containsKey(isbn)) {
            throw new Exception("No se encontró el libro con ISBN " + isbn + " para eliminar.");
        }
        Libro libro = librosPorISBN.remove(isbn);
        librosPorTitulo.remove(libro.getTitulo());
    }

    @Override
    public Libro encontrarLibroPorTituto(String titulo) {
        return librosPorTitulo.get(titulo);
    }


}
