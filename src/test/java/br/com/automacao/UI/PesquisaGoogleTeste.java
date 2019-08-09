package br.com.automacao.UI;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.automacao.Pages.LandingPage;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

@RunWith(JUnitParamsRunner.class)
public class PesquisaGoogleTeste {

	private WebDriver driver;
	static FileWriter fileWriter;

	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/Resultado.txt");
		if (file.exists()) {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Before
	public void preCondicao() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		fileWriter = new FileWriter("src/test/resources/Resultado.txt", true);
	}

	@After
	public void posCondicao() throws IOException {
		driver.quit();
	}

	@Test
	@FileParameters(value = "src/main/resources/diretores.csv", mapper = CsvWithHeaderMapper.class)
	public void test(String nome, String dataNascimento, String filme, String anoLancamento)
			throws InterruptedException {

		driver.get("http://www.google.com.br");

		String textoBusca = nome + " " + filme;
		String textoResultado = (new LandingPage(driver).realizarPesquisa(textoBusca).retornaResultados());

		assertTrue("Resultado não disponível", !textoResultado.isEmpty());

		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(textoBusca + " - " + textoResultado);
		printWriter.close();

	}

}
