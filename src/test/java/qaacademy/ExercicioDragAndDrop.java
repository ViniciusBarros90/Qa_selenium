package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExercicioDragAndDrop {
    WebDriver driver;

    @Before
    public void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// muda o contexto do driver para o frame
        driver.get(("https://demo.automationtesting.in/Static.html"));
    }

    @Test
    public void testeDragAndDrop() {
        WebElement elementoInicial = driver.findElement(By.id("node")); // Elemento Inicial
        WebElement areaDestino = driver.findElement(By.id("droparea")); // Area Final
      Actions actionsProvider = new Actions(driver); //Instancia do ActionProvider
      actionsProvider.dragAndDrop(elementoInicial, areaDestino).build().perform();

    }

    @After
    public void After(){
        driver.quit();
    }

}
