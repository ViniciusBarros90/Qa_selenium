package qaacademy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrincipaisComandosSelenium {
   
    @Test
   public void testeSeleniumClick () throws InterruptedException{ //metodos
    
    WebDriver driver = new ChromeDriver(); //Abrir o Browser
    driver.get("https://www.qaacademy.com.br/");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button[1]")).click();
   
    
    }
    
}
