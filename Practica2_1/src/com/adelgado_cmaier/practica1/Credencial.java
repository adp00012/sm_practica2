package com.adelgado_cmaier.practica1;

public class Credencial {
	private String nom_usuario;
	private String password;
	private String dir_red;
	private String puerto;
	
	//Constructor
	public Credencial(String user, String pass, String dir, String port){
		this.nom_usuario=user;
		this.password=pass;
		this.dir_red=dir;
		this.puerto=port;
	}
	
	//Getters y Setters
	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDir_red() {
		return dir_red;
	}

	public void setDir_red(String dir_red) {
		this.dir_red = dir_red;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
}
