package ejercicio11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio11Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Curso> cursos = new ArrayList<>();

		// Crear 5 cursos
		cursos.add(new Curso("Java Básico", 1, 20, 150));
		cursos.add(new Curso("Python Avanzado", 50, 30, 200));
		cursos.add(new Curso("Desarrollo Web", 60, 40, 250));
		cursos.add(new Curso("Machine Learning", 45, 25, 180));
		cursos.add(new Curso("Bases de Datos", 35, 15, 100));
		duracionTotal(cursos);
		menos500Alumnos(cursos);
		cursoMayorDuracion(cursos);
	}

	public long obtenerCursosMas5h(List<Curso> cursos) { // 1. Obtener la cantidad de cursos con una duración mayor a 5
		// horas.
		long contador = cursos.stream().filter(c -> c.getDuracion() > 5).count();

		return contador;
	}

	public long obtenerCursosMenos2h(List<Curso> cursos) { // 2. Obtener la cantidad de cursos con una duración menor a
															// 2 horas

		long contador = cursos.stream().filter(c -> c.getDuracion() < 2).count();
		return contador;
	}

	public List<String> titulosMas50Videos(List<Curso> cursos) { // 3. Listar el título de todos aquellos cursos con una
																	// cantidad de vídeos mayor a 50.
		List<String> titulos = cursos.stream().filter(c -> c.getNumvideos() > 50).map(c -> c.getNombre()).toList();

		return titulos;
	}

	public void top3MayorDuracion(List<Curso> cursos) { // 4. Mostrar en consola el título de los 3 cursos con mayor
														// duración
		// Ordenar la lista de cursos por duración en orden descendente
		List<Curso> cursosOrdenados = cursos.stream()
				.sorted((c1, c2) -> Integer.compare(c2.getDuracion(), c1.getDuracion())).collect(Collectors.toList());

		// Obtener los tres primeros cursos y extraer sus nombres
		List<String> titulos = cursosOrdenados.stream().limit(3).map(Curso::getNombre).collect(Collectors.toList());

		// Mostrar en consola los títulos de los tres cursos
		System.out.println("Los 3 cursos con mayor duración son:");
		for (String titulo : titulos) {
			System.out.println(titulo);
		}
	}

	public static void duracionTotal(List<Curso> cursos) { // 5. Mostrar en consola la duración total de todos los
															// cursos.

		int suma = cursos.stream().map(c -> c.getDuracion()).reduce(0, Integer::sum);
		System.out.println(suma);
	}

	public static void menos500Alumnos(List<Curso> cursos) { // 6. Mostrar en consola la duración de todos aquellos cursos
																// que tengan una cantidad dealumnos inscritos menor a
																// 500. Nombre del curso: número de horas ”horas”
		cursos.stream().filter(c -> c.getNumAlumnos() < 500).map(c -> c.getNombre() + ": " + c.getDuracion() + " horas.").forEach(System.out::println);;
	}
	public static void cursoMayorDuracion(List<Curso> cursos) { //7. Obtener el curso con mayor duración.
		Optional<Curso> cursoMayor = cursos.stream().max((p1, p2) -> p1.getDuracion().compareTo(p2.getDuracion()));
		cursoMayor.ifPresent(valor -> System.out.println("El curso de mayor duración es " + valor.toString()));
	}
}
