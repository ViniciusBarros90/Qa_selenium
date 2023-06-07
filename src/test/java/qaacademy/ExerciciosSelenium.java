package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciciosSelenium {
        static WebDriver driver;

        @Before
        public void before() throws InterruptedException {
                driver = new ChromeDriver(); // Abrir o Browser
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get("http://demo.automationtesting.in/Register.html");
        }

        @Test
        public void testesFormularioSelenium() throws InterruptedException {
                // First Name
                driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Vinicius");
                // Last Name
                driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Barros");
                // Adress
                driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("Rua Selenium");
                // Email Adress
                driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("teste@teste.com.br");
                // Phone
                driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("1139998577");

                // Selecionando o radio buttom "Gender" = combobox
                driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']")).click();
                // Validando que o radio buttom "Gender" foi selecionado
                Assert.assertTrue("Elemento não selecionado",
                                driver.findElement(By.xpath("//*[@ng-model='radiovalue' and @value='Male']"))
                                                .isSelected());

                // Selecionando o Checkbox "Movies"
                driver.findElement(By.xpath("//input[@value='Movies']")).click();
                // Validando que o radio o Checkbox "Movies" foi selecionado
                Assert.assertTrue("Checkbox não selecionado",
                                driver.findElement(By.xpath("//input[@value='Movies']")).isSelected());

                driver.findElement(By.xpath("//*[@id='msdd']")).click();

                // Selecionar lista <li>
                driver.findElement(By.xpath("//*[@id='msdd']")).click();
                driver.findElement(By.xpath("//a[contains(text(), 'Portuguese')]")).click();
                driver.findElement(By.xpath("//a[contains(text(), 'English')]")).click();

                // Validando que Portugues e English foram selecionados e exibidos
                boolean LinguagemPortuguesSelecionada = driver
                                .findElement(
                                                By.xpath("//div[contains(text(),'Portuguese') and @class='ui-autocomplete-multiselect-item']"))
                                .isDisplayed();

                boolean LinguagemEnglishSelecionada = driver
                                .findElement(
                                                By.xpath("//div[contains(text(),'English') and @class='ui-autocomplete-multiselect-item']"))
                                .isDisplayed();
                Assert.assertTrue(LinguagemPortuguesSelecionada && LinguagemEnglishSelecionada);

                // Selecionando o item "Java" na lista "Skills" do tipo option
                Select selectObject = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
                selectObject.selectByVisibleText("Java");

                // Selecionando item na lista "Select Countryn"
                driver.findElement(By.xpath(
                                "//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[10]/div[1]/span[1]/span[1]/span[1]"))
                                .click();
                driver.findElement(By.xpath("//li[contains(text(),'United States of America')]")).click();

                // Selecionando a data na lista "Date Of Birth" do tipo option
                Select selectAnoAniversario = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
                selectAnoAniversario.selectByVisibleText("1988");
                Select selectMes = new Select(driver.findElement(
                                By.xpath(" //body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[11]/div[2]/select[1]")));
                selectMes.selectByVisibleText("April");
                Select selectDia = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
                selectDia.selectByVisibleText("15");

                // Preenchendo o campo Password e Confirm Password
                driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("Teste");
                driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("Teste");
                // Clicar em Submit
                driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

                String msgErroTelefone = "Portuguese";
                Assert.assertTrue("Linguagem não está presente", driver.getPageSource().contains(msgErroTelefone));
        }

        @Test
        public void TestesFormularioSelenium(){


                
        }

        @AfterClass
        public static void after() throws InterruptedException {
                driver.quit();

        }
}
