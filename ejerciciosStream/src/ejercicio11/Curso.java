package ejercicio11;

public class Curso {
	private String nombre;
	private Integer duracion;
	private int numvideos;
	private int numAlumnos;
	public Curso(String nombre, Integer duracion, int numvideos, int numAlumnos) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.numvideos = numvideos;
		this.numAlumnos = numAlumnos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getNumvideos() {
		return numvideos;
	}
	public void setNumvideos(int numvideos) {
		this.numvideos = numvideos;
	}
	public int getNumAlumnos() {
		return numAlumnos;
	}
	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", duracion=" + duracion + ", numvideos=" + numvideos + ", numAlumnos="
				+ numAlumnos + "]";
	}
	
}
