package br.com.corrida.inicio;

public class LinhaLog {

	private String hora;
	
	private String codigoPiloto;
	
	private String nomePiloto;
	
	private String numeroVolta;
	
	private String tempoVolta;
	
	private String velocidadeMediaDaVolta;

	public LinhaLog(String hora, String codigoPiloto, String nomePiloto, String numeroVolta, String tempoVolta,
			String velocidadeMediaDaVolta) {
		this.hora = hora;
		this.codigoPiloto = codigoPiloto;
		this.nomePiloto = nomePiloto;
		this.numeroVolta = numeroVolta;
		this.tempoVolta = tempoVolta;
		this.velocidadeMediaDaVolta = velocidadeMediaDaVolta.replace(",", ".");
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCodigoPiloto() {
		return codigoPiloto;
	}

	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public String getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(String numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public String getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public String getVelocidadeMediaDaVolta() {
		return velocidadeMediaDaVolta;
	}

	public void setVelocidadeMediaDaVolta(String velocidadeMediaDaVolta) {
		this.velocidadeMediaDaVolta = velocidadeMediaDaVolta;
	}
	
}
