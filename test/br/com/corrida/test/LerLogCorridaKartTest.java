package br.com.corrida.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.corrida.inicio.LerLogCorridaKart;

public  class LerLogCorridaKartTest {
	
	private static String pathLog;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setPathLog("logKart.txt");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test(expected=IOException.class)
	public void testLerArquivoLogKartIOException() throws IOException {
			LerLogCorridaKart.lerArquivoLogKart("erroAoLerArquivo");
	}
	
	@Test
	public void testLerArquivoLogKart() throws IOException {
			LerLogCorridaKart.lerArquivoLogKart(getPathLog());
	}

	public static String getPathLog() {
		return pathLog;
	}

	public static void setPathLog(String pathLog) {
		LerLogCorridaKartTest.pathLog = pathLog;
	}

}
