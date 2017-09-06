package testes;

import java.util.LinkedList;
import java.util.List;

public class GeradorNumerosMegasenaMain {

	public static void main(String[] args) {
		List<List<Double>> jogosGerados = new LinkedList<List<Double>>();
		
		for (int jogos = 0; jogos < 4; jogos++) {
			List<Double> numeroGerados = new LinkedList<Double>();
			
			for (int dezenas = 0; dezenas < 6; dezenas++) {
				Double numero = Math.floor((Math.random() * 61));
				boolean numeroJaFoiGerado = numeroGerados.contains(numero);
				boolean numeroIgualZero = numero.compareTo(0d) == 0;
				
				if (!numeroJaFoiGerado && !numeroIgualZero) {
					numeroGerados.add(numero);
				} else {
					dezenas--;
				}
				
				// TODO Nao permitir 2 jogos identicos
			}
			
			// TODO Ordenar saida
			
			numeroGerados.forEach(item -> System.out.printf("%02.0f - ", item));
			jogosGerados.add(numeroGerados);
			
			System.out.println();
		}

		
/*
		System.out.println();

		for (int jogos = 0; jogos < 4; jogos++) {
			for (int dezenas = 0; dezenas < 6; dezenas++) {
				System.out.print(Math.ceil((Math.random() * 60)) + " - ");
			}
			System.out.println();
		}
*/
	}
}
