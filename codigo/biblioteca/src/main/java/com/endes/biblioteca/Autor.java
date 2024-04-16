package com.endes.biblioteca;

import java.util.List;

/**
* Representa a un autor de libros dentro de un sistema de gestión de biblioteca.
* Contiene información personal del autor y una lista de libros que ha escrito.
* 
* @author Pablo
* @version 1.0
*/
public class Autor {
	
	  private String nombre;
	    private String biografia;
	    private List<Libro> librosEscritos;
	    
	    
	    /**
	     *  Constructor de autor
	     * @param nombre  El nombre del autor a establecer.
	     * @param biografia La biografía del autor a establecer.
	     */
	    public Autor(String nombre, String biografia) {
	    	this.nombre = nombre;
	    	this.biografia  = biografia;
		}

		/**
	     * Obtiene la lista de libros escritos por el autor.
	     * 
	     * @return Una lista de objetos {@link Libro} que representa los libros escritos por el autor.
	     */
	    public List<Libro> getLibrosEscritos() {
	        return librosEscritos;
	    }

	    /**
	     * Establece la lista de libros escritos por el autor.
	     * 
	     * @param librosEscritos Una lista de objetos {@link Libro} que representa los libros escritos por el autor.
	     */
	    public void setLibrosEscritos(List<Libro> librosEscritos) {
	        this.librosEscritos = librosEscritos;
	    }

	    /**
	     * Obtiene el nombre del autor.
	     * 
	     * @return El nombre del autor.
	     */
	    public String getNombre() {
	        return nombre;
	    }

	    /**
	     * Establece el nombre del autor.
	     * 
	     * @param nombre El nombre del autor a establecer.
	     */
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    /**
	     * Obtiene la biografía del autor.
	     * 
	     * @return La biografía del autor.
	     */
	    public String getBiografia() {
	        return biografia;
	    }

	    /**
	     * Establece la biografía del autor.
	     * 
	     * @param biografia La biografía del autor a establecer.
	     */
	    public void setBiografia(String biografia) {
	        this.biografia = biografia;
	    }



	}

