package br.com.corrida.inicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import br.com.corrida.beans.Piloto;

public abstract class LerLogCorridaKart {
	
	public static Map<String, Piloto> lerArquivoLogKart(String path) throws FileNotFoundException, IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine();
        while (true) {
            linha = buffRead.readLine();
            if (linha != null) {              
                String[] dados = linha.split("\\s+");
                String dadosDaVolta = "";
                for(String dado : dados) {
                	if(!"–".equals(dado)) {
                		dado += "-";
                		dadosDaVolta += dado;
                	}
                }
                ProcessarDados.processaDados(dadosDaVolta);
            } else
                break;            
        }
        buffRead.close();
        return ProcessarDados.getMapPilotos();
    }
	
	

}
