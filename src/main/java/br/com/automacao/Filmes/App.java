package br.com.automacao.Filmes;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		String continuar;
		ArrayList<ArrayList<String>> geral = new ArrayList<ArrayList<String>>();

		do {
			ArrayList<String> diretores = new ArrayList<String>();
			Diretor diretor = new Diretor();
			Filme filme = new Filme();

			System.out.println("Digite o nome do diretor: ");
			diretor.nome = leitor.nextLine();
			System.out.println("Digite a data de nascimento do diretor (DD/MM/AAAA): ");
			diretor.dataNascimento = leitor.nextLine();
			System.out.println("Digite o nome do filme: ");
			filme.nome = leitor.nextLine();
			System.out.println("Digite o ano de lancamento do filme: ");
			filme.anoLancamento = leitor.next();
			System.out.println("Digite SAIR para encerrar, ou enter para cadastrar um novo registro ");
			continuar = leitor.nextLine();
			continuar = leitor.nextLine();

			diretores.add(diretor.nome);
			diretores.add(diretor.dataNascimento);
			diretores.add(filme.nome);
			diretores.add(filme.anoLancamento);

			geral.add(diretores);

		} while (!continuar.toUpperCase().equals("SAIR"));

		leitor.close();

		ExportarCsv.ExportarDiretores(geral);

	}

}
