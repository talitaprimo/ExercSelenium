package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformationuserTest {
    private WebDriver navegador;

    @Before
    public void Setup() {
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "/home/talita/Documentos/chromedriver_linux64/chromedriver");
        navegador = new ChromeDriver();

        //Aumentar o time out
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Maximizar janela do navegador
        navegador.manage().window().maximize();

        //Acessar uma página web
        navegador.get("http://www.juliodelima.com.br/taskit");
        // é necessário inserir o http!
    }

    @Test
    public void testAddInformUser() {

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

        //Clicar no link Hi, Julio
        navegador.findElement(By.className("me")).click();

        //Clicar no link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("More data about you")).click();

        //Clicar no botão Add More Data
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Selecionar uma opção no combo Type

        //Digitar no campo Contact

        //Clicar no link Save

        //Validar mensagem exibida no toast message
    }

        @After
        public void tearDown(){
            //fechar navegador
            navegador.quit();
        }
}