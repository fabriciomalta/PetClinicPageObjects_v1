package com.github.custom.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Configurar o WebDriver e abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Fabricio\\\\Documents\\\\Mestrado\\\\Testes de Software\\\\petclinic\\\\chrome-win64\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://bueno.inf.br/teste/painel/index.php");
    }

    @Test
    public void testLoginSenhaEmBranco() {
        loginComCredenciais("", "");

        WebElement alert = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));

        assertTrue(alert.isDisplayed());
    }

    @Test
    public void testLoginEmBrancoSenhaCorreta() {
        loginComCredenciais("", "nCvj#D8V$b5X$7Dq%wGu");

        WebElement alert = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));

        assertTrue(alert.isDisplayed());
    }

    @Test
    public void testLoginSenhaIncorretosPreenchidos() {
        loginComCredenciais("usuario_inexistente", "senha_errada");

        WebElement alert = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));

        assertTrue(alert.isDisplayed());
    }

    @Test
    public void testLoginCorretoSenhaIncorreta() {
        loginComCredenciais("admin", "senha_errada");

        WebElement alert = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));

        assertTrue(alert.isDisplayed());
    }

    @Test
    public void testLoginIncorretoSenhaCorreta() {
        loginComCredenciais("usuario_inexistente", "nCvj#D8V$b5X$7Dq%wGu");

        WebElement alert = new WebDriverWait(driver, 5)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-dismissible")));

        assertTrue(alert.isDisplayed());
    }

    @Test
    public void testLoginSenhaCorretos() {
        loginComCredenciais("admin", "nCvj#D8V$b5X$7Dq%wGu");

        WebElement navigation = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("navigation")));

        assertTrue(navigation.isDisplayed());
    }

    @After
    public void tearDown() {
        // Fechar o navegador após cada teste
        driver.quit();
    }

    private void loginComCredenciais(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("input-username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
    }
}
