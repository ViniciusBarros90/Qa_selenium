package qaacademy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosComScreenShot {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(("https://demo.automationtesting.in/Windows.html"));
    }

    @Test 
    public void testeJanelasWindow() throws IOException{
        screenShot("Janela Windows 1");
        driver.findElement(By.linkText("click")).click();
        
        System.out.println(driver.getCurrentUrl());                //Mostra a URL da primeira janela
        Object[] janelas = driver.getWindowHandles().toArray();   // Estou mapeanedo as janelas que estão abertas
        driver.switchTo().window(janelas[1].toString());         //Faz a troca de fato, Pega a janela posição 1 e converte o Object para String
        screenShot("Tab Navegador");          
        System.out.println(driver.getCurrentUrl());               //Mostra a URL da segunda janela
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));

    }
    
    public void screenShot(String nomeScreenshot) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver; // Convertendo o driver em TakesScreenShot
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE); // Tira o screen shot e transforma para o tipo File
FileUtils.copyFile(arquivo, new File("output"+File.separator+ nomeScreenshot+"_screenshot.jpg")); //Grava os bytes do arquivo no sistema operacional
    }

}


