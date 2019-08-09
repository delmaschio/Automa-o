package br.com.automacao.Filmes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportarCsv {

	public static void ExportarDiretores(ArrayList<ArrayList<String>> lista) {
		
		try (PrintWriter writer = new PrintWriter(new File("src/main/resources/diretores.csv"))) {

			StringBuilder sb = new StringBuilder();
			sb.append("Nome");
			sb.append(',');
			sb.append("Data de Nascimento");
			sb.append(',');
	    	sb.append("Filme");
			sb.append(',');
			sb.append("Ano de Lancamento");
			sb.append("\n");

			for (ArrayList<String> linha : lista) {
				sb.append(String.join(",", linha));
				sb.append("\n");
			}

			writer.write(sb.toString());

			System.out.println("Finalizado!");

			writer.flush();
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível salvar o arquivo no caminho: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro desconhecido: " + e.getMessage());
		}
	}
}
