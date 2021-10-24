package com.ecodeup.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videojuegos")
public class Videojuego {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String Nombre;
	@Column
	private String Director;
	@Column
	private String Estudio;
	@Column
	private int Año;
	@Column
	private String Genero;
	@Column
	private int Metacritic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		this.Director = director;
	}
	public String getEstudio() {
		return Director;
	}
	public void setEstudio(String estudio) {
		this.Estudio = estudio;
	}
	public int getAño() {
		return Año;
	}
	public void setAño(int año) {
		this.Año = año;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		this.Genero = genero;
	}
	public int getMetacritic() {
		return Metacritic;
	}
	public void setMetacritic(int metacritic) {
		this.Metacritic = metacritic;
	}

	@Override
	public String toString() {
		return "Videojuego [id="+id+", nombre="+Nombre+", Director="+Director+", Estudio="+Estudio+", Año="+Año+", Genero="+Genero+", Metacritic"+Metacritic+"]";
	}
	
}
