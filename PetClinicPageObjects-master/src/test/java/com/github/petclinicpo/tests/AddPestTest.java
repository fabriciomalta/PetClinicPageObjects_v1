package com.github.petclinicpo.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPestTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        // Configurar o driver do Selenium (neste exemplo, estamos usando o ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fabricio\\Documents\\Mestrado\\Testes de Software\\petclinic\\chrome-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        // URL base do PetClinic
        baseUrl = "http://localhost:8080/";
    }

    @Test
    public void testAdicionarNovoPet() {
        // Navegar até a página de adicionar um novo pet
       driver.get(baseUrl + "owners/find");
        // click in option 'find owners'
        driver.findElement(By.xpath("//a[@title='find owners']")).click();
            //driver.findElement(By.linkText("Find owners")).click();
        driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys("Davis");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.linkText("Betty Davis")).click();
        driver.findElement(By.linkText("Add New Pet")).click();

        // Preencher os detalhes do novo pet
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Tiago");
        driver.findElement(By.id("birthDate")).clear();
        driver.findElement(By.id("birthDate")).sendKeys("022/01/10");
        driver.findElement(By.id("type")).click();
       {
          WebElement dropdown = driver.findElement(By.id("type"));
            dropdown.findElement(By.xpath("//option[. = 'dog']")).click();
        }
       //driver.findElement(By.id("type")).click();
    	   //driver.findElement(By.cssSelector(".form-group:nth-child(5)")).click();

////        // Clicar no botão para adicionar o pet
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verificar se o pet foi adicionado com sucesso
        //assertTrue(driver.findElement(By.cssSelector(".table:nth-child(3)")).getText().contains("Santiago"));
        assertTrue(driver.findElement(By.xpath("//dd[text()='Tiago']")).isDisplayed());

        // Fechar o navegador
        driver.close();
    }

    @After
    public void tearDown() {
        // Fechar o navegador após cada teste
        driver.quit();
    }
}
