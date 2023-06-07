package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosNovaTab {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(("https://demo.automationtesting.in/Windows.html"));
    }

    @Test 
    public void testeJanelasWindow(){
        driver.findElement(By.linkText("click")).click();
        System.out.println(driver.getCurrentUrl());                //Mostra a URL da primeira janela
        Object[] janelas = driver.getWindowHandles().toArray();   // Estou mapeanedo as janelas que estão abertas
        driver.switchTo().window(janelas[1].toString());          //Faz a troca de fato, Pega a janela posição 1 e converte para o Object para String
        System.out.println(driver.getCurrentUrl());               //Mostra a URL da segunda janela
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));

        
    }

}
