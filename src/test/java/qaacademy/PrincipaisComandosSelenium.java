package qaacademy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrincipaisComandosSelenium {

    @Test
    public void testeSeleniumEnviarTextosParaTela() throws InterruptedException { // metodos

        WebDriver driver = new ChromeDriver(); // Abrir o Browser
        driver.get("https://www.qaacademy.com.br/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder='Nome']")).click(); // Seleciona campo nome
        driver.findElement(By.xpath("//*[@placeholder='Nome']")).sendKeys("Vinicius Barros"); //Envia informações para tela
        driver.findElement(By.xpath("//*[@placeholder='Email']")).click(); // Seleciona campo email
        driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("teste@teste.com.br");
        driver.findElement(By.xpath("//*[@id='comp-k37gdiro']/button/span")).click(); // Clicar no botão Enviar

    }

}
