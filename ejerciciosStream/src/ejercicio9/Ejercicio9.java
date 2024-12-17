package ejercicio9;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*9. Dado una clase Persona, con nombre y edad, crear un main con una lista de 5 personas y
		obtener sólo aquellas personas mayores de 25 años y ordenarlas por nombre e imprimir el
		resultado. Imprimirlos de la forma:
		nombre ( edad )
		Ej: Ana (30 años) */
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Marta", 15));
		personas.add(new Persona("Angel", 28));
		personas.add(new Persona("Pepe", 52));
		personas.add(new Persona("María", 78));
		personas.add(new Persona("Paco", 92));
		
		personas.stream().filter(p -> p.getEdad() > 25).sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre())).map(p -> p.getNombre()+ " (" + p.getEdad() + " años)" )
		.forEachOrdered(System.out::println);;
	}

}
