package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class InformationuserTest {
  private WebDriver navegador;

  @Before
  public void Setup() {
    // Abrir o navegador
    System.setProperty(
        "webdriver.chrome.driver", "/home/talita/Documentos/chromedriver_linux64/chromedriver");
    navegador = new ChromeDriver();

    // Aumentar o time out
    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    // Maximizar janela do navegador
    navegador.manage().window().maximize();

    // Acessar uma página web
    navegador.get("http://www.juliodelima.com.br/taskit");
    // é necessário inserir o http!
  }

  @Test
  public void testAddInformUser() {

    // Mapear e clicar no link que possui o texto Sign in
    navegador.findElement(By.linkText("Sign in")).click();

    // Mapear o formulário de login e atribuir o mapeamento a uma variável para que possamos
    // reaproveitá-lo.
    WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

    // Mapear e digitar no campo Login
    formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

    // Mapear e digitar no campo Password
    formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

    // Mapear e clicar no link Sign In
    navegador.findElement(By.linkText("SIGN IN")).click();

    // Mapear e clicar no link Hi, Julio
    navegador.findElement(By.className("me")).click();

    // Mapear e clicar no link que possui o texto "MORE DATA ABOUT YOU"
    navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    // Mapear e clicar no botão Add More Data
    navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

    // Mapear o pop-up onde está o formulário a ser preenchido e colocar esse contexto em uma
    // variável, para que possa ser reutilizado
    WebElement popup = navegador.findElement(By.id("addmoredata"));

    // Mapear o combobox com nome Type e selecionar a opção Phone
    WebElement combobox = popup.findElement(By.name("type"));
    // A classe Select é específica para combobox no Selenium
    new Select(combobox).selectByVisibleText("Phone");

    // Mapear o campo Contact e digitar o telefone nesse campo
    popup.findElement(By.name("contact")).sendKeys("5511999999999");

    // Mapear e clicar no link Save
    popup.findElement(By.linkText("SAVE")).click();

    // Mapear toast que exibe a mensagem
    WebElement mensagem = navegador.findElement(By.id("toast-container"));
    // capturar o texto da mensagem e atribuir a variável conteudoMsg
    String conteudoMsg = mensagem.getText();
    // Validar o texto da mensagem
    assertEquals("Your contact has been added!", conteudoMsg);
  }

  @After
  public void tearDown() {
    // fechar navegador
    navegador.quit();
  }
}
