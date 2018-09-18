package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformationuserTest {
    @Test
    public void testAddInformUser() {
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "/home/talita/Documentos/chromedriver_linux64/chromedriver");
        WebDriver navegador = new ChromeDriver();

        //Acessar uma página web
        navegador.get("http://www.juliodelima.com.br/taskit");
        // é necessário inserir o http!

        //Exemplo de validação
        assertEquals(1,1);
    }
}