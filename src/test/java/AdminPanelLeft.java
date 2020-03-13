import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminPanelLeft {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void leftPanel(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        List<WebElement> panel = driver.findElements(By.xpath("//ul[@id='box-apps-menu'] /li[@id='app-'] /span[@class='name']"));
        for (WebElement elements : panel){
            elements.click();
        }
        List<WebElement> panel2 = driver.findElements(By.xpath("//ul[@id='box-apps-menu'] //li[@id='app-'] //ul[@class='docs'] //span[@class='name']"));
        for (WebElement elements2 : panel2){
            elements2.click();
            elements2.findElement(By.xpath("//h1"));
        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
