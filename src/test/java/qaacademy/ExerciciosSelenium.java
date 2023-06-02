package qaacademy;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium {
    static WebDriver driver;

    @Test
    public void testesFormularioSelenium() throws InterruptedException {
        driver = new ChromeDriver(); // Abrir o Browser
        driver.get("http://demo.automationtesting.in/Register.html");
        Thread.sleep(3000);

        // First Name
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Vinicius");

        // Last Name
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Barros");

        // Adress
        driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("Rua Selenium");

        // Email Adress
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("teste@teste.com.br");

        // Phone
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("39998577");

        // Selecionando o radio buttom "Gender" = combobox
        driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']")).click();
        // Validando que o radio buttom "Gender" foi selecionado
        Assert.assertTrue("Elemento não selecionado",
        driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']")).isSelected());

        // Selecionando o Checkbox "Movies" 
        driver.findElement(By.xpath("//input[@value='Movies']")).click();
        // Validando que o radio o Checkbox "Movies" foi selecionado
        Assert.assertTrue("Checkbox não selecionado",
        driver.findElement(By.xpath("//input[@value='Movies']")).isSelected());

        driver.findElement(By.xpath("//*[@id='msdd']")).click();
        Thread.sleep(1000);

        //Selecionar lista
        driver.findElement(By.xpath("//*[@id='msdd']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Portuguese')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'English')]")).click();
        

boolean LinguagemPortuguesSelecionada = driver
        //Validando que Portugues e English foram selecionados e exibidos
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Portuguese') and @class='ui-autocomplete-multiselect-item']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'English') and @class='ui-autocomplete-multiselect-item']")).isDisplayed());
    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
