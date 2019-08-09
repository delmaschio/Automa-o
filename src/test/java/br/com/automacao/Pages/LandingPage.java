package br.com.automacao.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement txtBarraPesquisa;

	public ResultadosPage realizarPesquisa(String texto) {
		txtBarraPesquisa.sendKeys(texto);
		txtBarraPesquisa.sendKeys(Keys.ENTER);
		return new ResultadosPage(driver);
	}

}
