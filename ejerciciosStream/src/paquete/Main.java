package paquete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Dada una lista de 5 nombres, filtrar e imprimir aquellos que comienzan por
		// ‘A’
		List<String> nombres = Arrays.asList("Antonio", "Amanda", "Carmen", "Ana", "Pepe");
		nombres.stream().filter(nombre -> nombre.startsWith("A")).forEach(System.out::println);

		// 2. Dada una lista de 5 nombres, filtrar e imprimir aquellos que comienzan por
		// ‘A’, convertirlos a mayúsculas y luego ordenarlo alfabéticamente.
		List<String> nombres2 = Arrays.asList("Antonio", "Amanda", "Carmen", "Ana", "Pepe");
		nombres2.stream().filter(nombre -> nombre.startsWith("A")).map(String::toUpperCase).sorted()
				.forEach(System.out::println);

		// 3. Dado un array de 5 palabras, imprimir la primera letra de cada palabra.
		List<String> palabras = Arrays.asList("casa", "xiaomi", "chaleco", "samsung", "mesa");
		palabras.stream().map(palabra -> palabra.charAt(0)).forEach(System.out::println);

		// 4. Dado un array de 5 palabras, devuelve una lista con la longitud de cada
		// palabra. Imprime la lista.
		palabras.stream().map(palabra -> palabra.length()).forEach(System.out::println);

		// 5. Dado un array de 5 palabras, devolver aquellas palabras que tengan más de
		// 5 caracteres.
		palabras.stream().filter(palabra -> palabra.length() > 5).forEach(System.out::println);

		// 6. Crea un array de 10 enteros y devuelve el numero de pares que hay
		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Stream<Integer> numerosStream = Arrays.stream(numeros);

		long cuenta = numerosStream.filter(numero -> numero % 2 == 0).count();
		
		System.out.println("numeros pares: " +cuenta);//despues de un foreach se cierra el stream

		// 7. Multiplicar todos los elementos de un array de 10 numeros
		Stream<Integer> numerosStream2 = Arrays.stream(numeros); //lo volvemos a crear
		Integer total = numerosStream2.reduce(1, (a,b) -> a*b); //ponemos 1 porque vamos a multiplicar
		System.out.println("El total es " + total);
		
		//8. Dado un array de 5 precios, devolver en una lista los mayores de 20 euros. Usar Double.
		Double[] precios = {20.5, 85.0, 10.0, 5.2, 86.3};
		Stream<Double> preciosStream = Arrays.stream(precios);
		List<Double> precioLista = preciosStream.filter(precio -> precio > 20.0).toList();
		System.out.println(precioLista);
		
	}

}
