package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Screenshot {
  public static void print(WebDriver navegador, String arquivo) {

    // criar uma variável do tipo File
    File screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
    // WebDriver não faz uso dos métodos da classe TakesScreenshot por isso precisamos chamar os
    // métodos da forma acima
    // Método getScreenshotAs irá capturar a tela

    // Armazenar o arquivo gerado em um lugar específico
    // Esse método pode retornar uma exceção por isso precisamos usar um try catch.
    try {
      FileUtils.copyFile(screenshot, new File(arquivo));
    } catch (Exception e) {
      System.out.println("Falha ao copiar o arquivo para a pasta " + e.getMessage());
    }
  }
}
