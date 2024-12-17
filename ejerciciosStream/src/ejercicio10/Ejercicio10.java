package ejercicio10;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10. Dada una lista de 10 números, devuelve una lista con el cuadrado sólo de
		// los números pares. Imprimir la lista
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numeros.stream().filter(s -> s % 2 == 0).map(s -> Math.pow(s, 2)).forEach(System.out::println);
		;

		// 13. generar un stream que produzca la cadena "ABC" cinco veces y luego
		// sustituya la letra "B" por un espacio en blanco.
		Stream<String> abc = Stream.generate(() -> "ABC");
		abc.limit(5).map(s -> s.replace("B", " ")).forEach(System.out::println);

		// 14.Generar 5 números impares aleatorios entre 1 y 20.
		Random random = new Random();
		Stream<Integer> imparAlea = Stream.generate(() -> random.nextInt(20) + 1).filter(s -> s % 2 != 0).limit(5);

		imparAlea.forEach(System.out::println); // Llamada a forEach separada porque si no funciona
		
		// 15.Generar una secuencia de 10 números a partir del 4 incrementándose de dos
		// en dos. Transformar cada número en una cadena con formato: “Numero X”.
		
		Stream<Integer> incremento = Stream.iterate(4, n -> n +2).limit(10);
		List<String> cadena = incremento.map(n -> "Numero " + n)
				.collect(Collectors.toList()); 
		cadena.forEach(System.out::println);
	}

}
