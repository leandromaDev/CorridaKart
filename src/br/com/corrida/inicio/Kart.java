package br.com.corrida.inicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import br.com.corrida.beans.Corrida;
import br.com.corrida.beans.Piloto;

public class Kart {
	
	private static String pathLog = "logKart.txt";

	public static void main(String[] args) {

		try {
			Map<String, Piloto> mapPilotos = LerLogCorridaKart.lerArquivoLogKart(pathLog);
			gerarSaida(mapPilotos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void gerarSaida(Map<String, Piloto> mapPilotos) {
		Corrida corrida = new Corrida();
		corrida.setPilotos(new ArrayList<Piloto>(mapPilotos.values()));
		corrida.processarDadosDaCorrida();
		corrida.imprimiResultadoDaCorrida();
		corrida.imprimirMelhorVoltaDosPilotos();
		corrida.imprimirMelhorVoltaDaCorrida();
		corrida.imprimirVelocidadeMediaTotalPorPiloto();
	}

}
