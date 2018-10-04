package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class removerContatoUsuarioTest {
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
    }

    @Test
    public void RemoveContact() {

        //Identificar a informação (telefone ou e-mail) para clicar no botão Excluir referente a essa informação.
        navegador.findElement(By.xpath("//span[text()=\"551132435354\"]/following-sibling::a")).click();

        //Confirmar a janela Javascript
        navegador.switchTo().alert().accept();

        // Mapear toast que exibe a mensagem
        WebElement mensagem = navegador.findElement(By.id("toast-container"));
        // capturar o texto da mensagem e atribuir a variável conteudoMsg
        String conteudoMsg = mensagem.getText();
        // Validar o texto da mensagem
        assertEquals("Rest in peace, dear phone!", conteudoMsg);

        //Espera explícita
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);


    }

}