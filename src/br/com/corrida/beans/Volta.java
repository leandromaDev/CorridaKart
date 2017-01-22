package br.com.corrida.beans;

import java.util.Calendar;

import br.com.corrida.inicio.ProcessarDados;

public class Volta {

	private int numero;
	
	private Double velocidadeMedia;
	
	private Calendar tempoDaVolta;
	
	private Calendar HoraDaVolta;

	public Volta(int numero, Double velocidadeMedia, Calendar tempoDaVolta, Calendar horaDaVolta) {
		this.numero = numero;
		this.velocidadeMedia = velocidadeMedia;
		this.tempoDaVolta = tempoDaVolta;
		this.HoraDaVolta = horaDaVolta;
	}

	public Volta(String numeroVolta, String velocidadeMediaDaVolta, String tempoVolta, String hora) {
		
		this.numero = Integer.parseInt(numeroVolta);
		this.velocidadeMedia = Double.parseDouble(velocidadeMediaDaVolta); 
		this.tempoDaVolta = getTempoVoltaConvertida(tempoVolta);
		this.HoraDaVolta = getTempoVoltaConvertida(hora);
	}

	private Calendar getTempoVoltaConvertida(String tempoVolta) {
		return ProcessarDados.getTempoVoltaConvertida(tempoVolta);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	public Calendar getTempoDaVolta() {
		return tempoDaVolta;
	}

	public void setTempoDaVolta(Calendar tempoDaVolta) {
		this.tempoDaVolta = tempoDaVolta;
	}

	public Calendar getHoraDaVolta() {
		return HoraDaVolta;
	}

	public void setHoraDaVolta(Calendar horaDaVolta) {
		HoraDaVolta = horaDaVolta;
	}
	
}
