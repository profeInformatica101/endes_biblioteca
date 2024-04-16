package com.endes.biblioteca;

import java.util.Date;
import java.util.List;

import com.endes.biblioteca.enumerado.EstadoCuenta;

public class CuentaUsuario {
	 private String numero;
	    private List<EjemplarLibro> librosPrestados;
	    private List<EjemplarLibro> librosReservados;
	    private Date fechaApertura;
	    private EstadoCuenta estado;

}
