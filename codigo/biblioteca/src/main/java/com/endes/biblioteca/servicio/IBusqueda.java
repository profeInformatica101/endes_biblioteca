package com.endes.biblioteca.servicio;

import com.endes.biblioteca.Libro;

public interface IBusqueda {
	Libro encontrarLibroPorTituto(String titulo);
}
