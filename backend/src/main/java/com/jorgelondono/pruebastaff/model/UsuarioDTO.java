package com.jorgelondono.pruebastaff.model;

public class UsuarioDTO {

	private String nombre;
	private String contrasena;	
	
	public UsuarioDTO(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
	
	public UsuarioDTO() {
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	
	
}
