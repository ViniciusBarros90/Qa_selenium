package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosFrame {
    WebDriver driver;


@Before
public void iniciaTeste() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//muda o contexto do driver para o frame
    driver.get(("https://demo.automationtesting.in/Frames.html"));
}

@Test
public void testeIframeSimples(){
driver.switchTo().frame("singleframe");
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Teste QA academy");
driver.switchTo().defaultContent(); // Retornado para o contexto original. Na pagina original fora do contexto Iframe

}

@After
public void after() {
    driver.quit();
}


}

