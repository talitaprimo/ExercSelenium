package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformationuserTest {
    @Test
    public void testAddInformUser() {
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "/home/talita/Documentos/chromedriver_linux64/chromedriver");
        WebDriver navegador = new ChromeDriver();

        //Aumentar o time out
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Maximizar janela do navegador
        navegador.manage().window().maximize();

        //Acessar uma página web
        navegador.get("http://www.juliodelima.com.br/taskit");
        // é necessário inserir o http!

        //Clicar no link que possui o texto Sign in
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificar o formulário de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
        //Variável formularioSignInBox foi criada para que possamos reaproveitar esse mapeamento.

        //Digitar no campo Login
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo Password
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link Sign In
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar texto Hi, Julio
        WebElement me = navegador.findElement(By.className("me"));
        String textoElem = me.getText();
        assertEquals("Hi, Julio",textoElem);

        //fechar navegador
        navegador.quit();

    }
}