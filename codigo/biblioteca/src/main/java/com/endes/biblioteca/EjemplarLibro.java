package com.endes.biblioteca;

import java.util.Date;
import java.util.List;

public class EjemplarLibro extends Libro {
	 
	private String codigoDeBarras;
	private Date prestado;
	private Date reservado;
	
    public EjemplarLibro(String isbn, String titulo,  List<Autor> autores, int paginas, String codigoDeBarras) {
    	this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutores(autores); // Estableciendo la lista de autores en el libro.
        this.setNumeroDePaginas(paginas);
        this.codigoDeBarras = codigoDeBarras;
        this.prestado = null; // Inicializando con null, indicando que no está prestado inicialmente
        this.reservado = null; // Inicializando con null, indicando que no está reservado inicialmente
    }

    public EjemplarLibro(String isbn, String titulo,  List<Autor> autores) {
    	this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setAutores(autores);
    }

	public EjemplarLibro(String titulo) {
		this.setTitulo(titulo);
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public Date getPrestado() {
		return prestado;
	}
	public void setPrestado(Date prestado) {
		this.prestado = prestado;
	}
	public Date getReservado() {
		return reservado;
	}
	public void setReservado(Date reservado) {
		this.reservado = reservado;
	}
	
	
	
}
