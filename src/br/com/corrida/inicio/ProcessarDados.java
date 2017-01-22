package br.com.corrida.inicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import br.com.corrida.beans.Piloto;
import br.com.corrida.beans.Volta;

public abstract class ProcessarDados {

	private static Map<String, Piloto> mapPilotos = new HashMap<String, Piloto>();
	
	public static Piloto processaDados(String dado) {
		String[] dadosDaLinha = dado.split("-");
		LinhaLog linha = new LinhaLog(dadosDaLinha[0], dadosDaLinha[1], dadosDaLinha[2], 
									  dadosDaLinha[3], dadosDaLinha[4], dadosDaLinha[5]);
		Piloto piloto = getPiloto(linha);
		Volta volta = new Volta(linha.getNumeroVolta(), linha.getVelocidadeMediaDaVolta(), linha.getTempoVolta(), linha.getHora());
		piloto.getVoltas().add(volta);
		mapPilotos.put(piloto.getCodigo(), piloto);
		return piloto;
		
	}
	
	private static Piloto getPiloto(LinhaLog linha) {
		Volta volta = new Volta(linha.getNumeroVolta(), linha.getVelocidadeMediaDaVolta(), linha.getTempoVolta(), linha.getHora());
		if(mapPilotos.containsKey(linha.getCodigoPiloto())) {
			Piloto piloto = mapPilotos.get(linha.getCodigoPiloto());
			if(piloto.getMelhorVolta().getTempoDaVolta().after(getTempoVoltaConvertida(linha.getTempoVolta()))) {
				piloto.setMelhorVolta(volta);
			}
			return piloto;
		}
		return new Piloto(linha.getNomePiloto(), linha.getCodigoPiloto(), new ArrayList<Volta>(), -1, volta);
	}

	public static Map<String, Piloto> getMapPilotos() {
		return mapPilotos;
	}

	public static void setMapPilotos(Map<String, Piloto> mapPilotos) {
		ProcessarDados.mapPilotos = mapPilotos;
	}
	
	public static Calendar zerarHora(Calendar tempo) {
		tempo.set(Calendar.HOUR, 0);
		tempo.set(Calendar.MINUTE, 0);
		tempo.set(Calendar.SECOND, 0);
		tempo.set(Calendar.MILLISECOND, 0);
		return tempo;
	}
	
	public static Calendar getTempoVoltaConvertida(String tempoVolta) {
		Calendar TempoVoltaConvertida = Calendar.getInstance();
		String[] vetorHora = tempoVolta.split(":");
		if(vetorHora.length > 2) {
			TempoVoltaConvertida.set(Calendar.HOUR, Integer.parseInt(vetorHora[0]));
			TempoVoltaConvertida.set(Calendar.MINUTE, Integer.parseInt(vetorHora[1]));
			String[] segundosMiliSsegundos = vetorHora[2].split("\\.");
			TempoVoltaConvertida.set(Calendar.SECOND, Integer.parseInt(segundosMiliSsegundos[0]));
			TempoVoltaConvertida.set(Calendar.MILLISECOND, Integer.parseInt(segundosMiliSsegundos[1]));
		}
		else {
			TempoVoltaConvertida.set(Calendar.MINUTE, Integer.parseInt(vetorHora[0]));
			String[] segundosMiliSsegundos = vetorHora[1].split("\\.");
			TempoVoltaConvertida.set(Calendar.SECOND, Integer.parseInt(segundosMiliSsegundos[0]));
			TempoVoltaConvertida.set(Calendar.MILLISECOND, Integer.parseInt(segundosMiliSsegundos[1]));
		}
		return TempoVoltaConvertida;
	}
	
	public static String diferencaEntreDatas(Calendar d1, Calendar d2) {
		d2.add(Calendar.HOUR, -d1.get(Calendar.HOUR));
		d2.add(Calendar.MINUTE, -d1.get(Calendar.MINUTE));
		d2.add(Calendar.SECOND, -d1.get(Calendar.SECOND));
		d2.add(Calendar.MILLISECOND, -d1.get(Calendar.MILLISECOND));
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
		return sdf.format(d2.getTime());
	}
}
