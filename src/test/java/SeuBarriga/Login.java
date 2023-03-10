package SeuBarriga;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    @Test
    public void testeLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.id("email")).sendKeys("usuarioteste2065@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("12345teste");
        driver.findElement(By.xpath("//button[text()= 'Entrar']")).click();
        driver.quit();
    }

    @Test
    public void testeLoginInvalido() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.id("email")).sendKeys("usuarioteste2065@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("12345");
        driver.findElement(By.xpath("//button[text()= 'Entrar']")).click();
        WebElement mensagem = driver.findElement(By.xpath("//div[text()= 'Problemas com o login do usuário']"));

        Assert.assertEquals("Problemas com o login do usuário", mensagem.getText());
        driver.quit();

    }

    @Test
    public void testeDeCadastro() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.xpath("//li/a[text()= 'Novo usuário?']")).click();
        driver.findElement(By.id("nome")).sendKeys("kplwa51Intmed4h048");
        driver.findElement(By.id("email")).sendKeys("kplwa51meu1tes42t5je20654@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("12345");

        Assert.assertEquals("Novo usuário?", driver.findElement(By.xpath("//li/a[text()= 'Novo usuário?']")).getText());
        WebDriverWait wait = new WebDriverWait(driver, (5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nome")));
        Assert.assertEquals("kplwa51Intmed4h048", driver.findElement(By.id("nome")).getAttribute("value"));
        Assert.assertEquals("kplwa51meu1tes42t5je20654@gmail.com", driver.findElement(By.id("email")).getAttribute("value"));

        driver.findElement(By.xpath("//input[@value= 'Cadastrar']")).click();

        Assert.assertEquals("Usuário inserido com sucesso", driver.findElement(By.xpath("//div[text()= 'Usuário inserido com sucesso']")).getText());
        driver.quit();
    }

    @Test
    public void testeDeCadastroInvalido() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.xpath("//li/a[text()= 'Novo usuário?']")).click();
        driver.findElement(By.id("nome")).sendKeys("Intmed06");
        driver.findElement(By.id("email")).sendKeys("meu1tes2te2065@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("12345");

        Assert.assertEquals("Novo usuário?", driver.findElement(By.xpath("//li/a[text()= 'Novo usuário?']")).getText());
        WebDriverWait wait = new WebDriverWait(driver, (5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nome")));
        Assert.assertEquals("Intmed06", driver.findElement(By.id("nome")).getAttribute("value"));
        Assert.assertEquals("meu1tes2te2065@gmail.com", driver.findElement(By.id("email")).getAttribute("value"));

        driver.findElement(By.xpath("//input[@value= 'Cadastrar']")).click();

        Assert.assertEquals("Endereço de email já utilizado", driver.findElement(By.xpath("//div[text()= 'Endereço de email já utilizado']")).getText());
        driver.quit();
    }


    @Test
    public void testeLogOut() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seubarriga.wcaquino.me/login");

        driver.findElement(By.id("email")).sendKeys("usuarioteste2065@gmail.com");
        driver.findElement(By.id("senha")).sendKeys("12345teste");
        driver.findElement(By.xpath("//button[text()= 'Entrar']")).click();

        driver.findElement(By.xpath("//li/a[text()= 'Sair']")).click();
        driver.quit();

    }

}

