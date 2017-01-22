package br.com.corrida.beans;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.corrida.inicio.ProcessarDados;

public class Corrida {

	private List<Piloto> pilotos;
	
	private String tempoTotalDeProva;
	
	private String[] posicaoChegada;
	
	private Map<Integer, Piloto> pilotoPorPosicaoChegada;
	
	public Corrida(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public Corrida() {

	}
	
	public List<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	public String getTempoTotalDeProva() {
		return tempoTotalDeProva;
	}

	public void setTempoTotalDeProva(String tempoTotalDeProva) {
		this.tempoTotalDeProva = tempoTotalDeProva;
	}
	
	public String[] getPosicaoChegada() {
		return posicaoChegada;
	}

	public void setPosicaoChegada(String[] posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}

	public void processarDadosDaCorrida() {
		Calendar menorTempo = Calendar.getInstance();
		menorTempo = ProcessarDados.zerarHora(menorTempo);
		Calendar tempoTotalPrimeiroColocado = Calendar.getInstance();
		tempoTotalPrimeiroColocado = ProcessarDados.zerarHora(tempoTotalPrimeiroColocado);
		setPosicaoChegada(new String[pilotos.size()]);
		pilotoPorPosicaoChegada = new HashMap<Integer,Piloto>(pilotos.size());
		for (Piloto piloto : pilotos) {
			int posicao = 1;
			for (Piloto piloto2 : pilotos) {
				if(piloto.getTempoCorrida().after(piloto2.getTempoCorrida())) {
					posicao++;
				}
			}
			if(posicao == 1) {
				tempoTotalPrimeiroColocado = piloto.getTempoCorrida();
			}
			piloto.setPosicaoChegada(posicao);
			pilotoPorPosicaoChegada.put(posicao, piloto);
		}
		for(Map.Entry<Integer, Piloto> entry : pilotoPorPosicaoChegada.entrySet()) {
			getPosicaoChegada()[entry.getValue().getPosicaoChegada()-1] = entry.getValue().getCodigo() + "      | " + String.format("%-15s"	, entry.getValue().getNome()) + " | " + entry.getValue().quantidadeVoltasCompletadas() + " |      " + entry.getValue().imprimiTempoTotalDeProva() + "     |   " + ProcessarDados.diferencaEntreDatas(tempoTotalPrimeiroColocado, entry.getValue().getTempoCorrida()) ;
			
		}
	}
	
	public void imprimiResultadoDaCorrida() {
		System.out.println("Resultado da corrida: \n");
		System.out.println("Posição    Código     Nome            Voltas     Tempo Total       Tempo após vencedor");
		for (int index = 0; index < posicaoChegada.length; index++) {
			System.out.println(index + 1  + "º       : " + posicaoChegada[index]);
		}
	}

	public void imprimirMelhorVoltaDosPilotos() {
		System.out.println("\nMelhor volta dos pilotos: \n");
		for (Piloto piloto : pilotos) {
			System.out.println(piloto.imprimirMelhorVolta());
		}
	}
	
	public void imprimirMelhorVoltaDaCorrida() {
		System.out.println("\nMelhor volta da corrida");
		Volta melhorVoltaDaCorrida = null;
		String pilotoNome = "";
		for (Piloto piloto : pilotos) {
			if(melhorVoltaDaCorrida == null) {
				melhorVoltaDaCorrida = piloto.getMelhorVolta();
			}
			else {
				if(melhorVoltaDaCorrida.getTempoDaVolta().after(piloto.getMelhorVolta().getTempoDaVolta())) {
					melhorVoltaDaCorrida = piloto.getMelhorVolta();
					pilotoNome = piloto.getNome();
				}
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
		System.out.println("Piloto : [" + pilotoNome + " - Melhor Volta : " + melhorVoltaDaCorrida.getNumero() + " Tempo : " +  sdf.format(melhorVoltaDaCorrida.getTempoDaVolta().getTime()) + "]");
	}
	
	public void imprimirVelocidadeMediaTotalPorPiloto() {
		System.out.println("\nVelocidade média de cada piloto:");
		DecimalFormat formato = new DecimalFormat("#.###");
		for (Piloto piloto : pilotos) {
			System.out.println("Piloto : [" + String.format("%-15s"	, piloto.getNome()) + " = " + formato.format(piloto.velocidadeMediaTodaCorrida()) + "]");
		}
	}

	public Map<Integer, Piloto> getPilotoPorPosicaoChegada() {
		return pilotoPorPosicaoChegada;
	}

	public void setPilotoPorPosicaoChegada(Map<Integer, Piloto> pilotoPorPosicaoChegada) {
		this.pilotoPorPosicaoChegada = pilotoPorPosicaoChegada;
	}
}
