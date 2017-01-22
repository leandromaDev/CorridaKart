package br.com.corrida.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.corrida.inicio.ProcessarDados;

public class Piloto {
	
	private String nome;
	
	private String codigo;
	
	private List<Volta> voltas;
	
	private int posicaoChegada;
	
	private Volta melhorVolta;

	public Piloto() {

	}

	public Piloto(String nome, String codigo, List<Volta> voltas, int posicaoChegada, Volta melhorVolta) {
		this.nome = nome;
		this.codigo = codigo;
		this.voltas = voltas;
		this.posicaoChegada = posicaoChegada;
		this.melhorVolta = melhorVolta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Volta> getVoltas() {
		return voltas;
	}

	public void setVoltas(List<Volta> voltas) {
		this.voltas = voltas;
	}

	public int getPosicaoChegada() {
		return posicaoChegada;
	}

	public void setPosicaoChegada(int posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}
	
	public Calendar getTempoCorrida() {
		Calendar tempoCorrida = Calendar.getInstance();
		tempoCorrida = ProcessarDados.zerarHora(tempoCorrida);
		for (Volta volta : voltas) {
			Calendar tempoDaVolta = volta.getTempoDaVolta();
			tempoCorrida.add(Calendar.MINUTE, tempoDaVolta.get(Calendar.MINUTE));
			tempoCorrida.add(Calendar.SECOND, tempoDaVolta.get(Calendar.SECOND));
			tempoCorrida.add(Calendar.MILLISECOND, tempoDaVolta.get(Calendar.MILLISECOND));
		}		
		return tempoCorrida;
	}
		
	public int quantidadeVoltasCompletadas() {
		return getVoltas().size();
	}
	
	public String imprimiTempoTotalDeProva() {
		Calendar tempoCorrida = getTempoCorrida();
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
		return sdf.format(tempoCorrida.getTime());
	}
	
	public String imprimirMelhorVolta() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
		return "Piloto : [" + String.format("%-15s"	, nome) + " - Melhor Volta : " + melhorVolta.getNumero() + " Tempo : " +  sdf.format(melhorVolta.getTempoDaVolta().getTime());
	}

	public Volta getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(Volta melhorVolta) {
		this.melhorVolta = melhorVolta;
	}
	
	public Double velocidadeMediaTodaCorrida() {
		Double velocidadeMediaTotal = 0D;
		for (Volta volta : voltas) {
			velocidadeMediaTotal += volta.getVelocidadeMedia();
		}
		return velocidadeMediaTotal/voltas.size();
	}
	
}
