package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosAlertas {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(("http://demo.automationtesting.in/Alerts.html"));
    }

    


    @Test
    public void TestesAlertaSimples() {
        driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        String mensagemEsperada = "I am an alert box!";
        alert.accept();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);
    }

    @Test
    public void TestesAlertaComOKeCancela() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAlerta = alert.getText();
        String mensagemEsperada = "Press a Button !";
        alert.dismiss();
        Assert.assertEquals(mensagemEsperada, mensagemAlerta);
    }

    @Test
    public void TestesAlertaComPrompt() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"))
                .click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("QA Academy | Formação em automação de testes WEB ");
        Thread.sleep(6000);
        alert.accept();
        
    }

    @After
    public void after() {
        driver.quit();
    }

}
