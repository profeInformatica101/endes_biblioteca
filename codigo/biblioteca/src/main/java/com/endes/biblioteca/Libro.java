package com.endes.biblioteca;

import java.util.Date;
import java.util.List;

public abstract class Libro {
	
    private String isbn;
    private String titulo;
    private String resumen;
    private String editorial;
    private Date fechaPublicacion;
    private int numeroDePaginas;
    private String idioma;
    private List<Autor> autores;

    // Constructor, getters y setters aquí
}
