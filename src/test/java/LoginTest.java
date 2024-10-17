import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get ("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginfield = By.id("user-name");
        By passwordfield = By.id("password");
        By loginbutton = By.id("login-button");
        By productsTitle = By.className("product_label");


        driver.findElement(loginfield).sendKeys("standard_user");
        driver.findElement(passwordfield).sendKeys("secret_sauce");
        driver.findElement(loginbutton).click();

        boolean result = driver.findElement(productsTitle).isDisplayed();
        Assert.assertTrue(result);

        driver.quit();
    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get ("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginfield = By.id("user-name");
        By passwordfield = By.id("password");
        By loginbutton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test = 'error']");

        driver.findElement(loginfield).sendKeys("standard_user");
        driver.findElement(passwordfield).sendKeys("");
        driver.findElement(loginbutton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Password is required");

        driver.quit();
    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get ("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginfield = By.id("user-name");
        By passwordfield = By.id("password");
        By loginbutton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test = 'error']");

        driver.findElement(loginfield).sendKeys("standard_user");
        driver.findElement(passwordfield).sendKeys("dream123");
        driver.findElement(loginbutton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }

    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get ("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginfield = By.id("user-name");
        By passwordfield = By.id("password");
        By loginbutton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test = 'error']");

        driver.findElement(loginfield).sendKeys("");
        driver.findElement(passwordfield).sendKeys("secret_sauce");
        driver.findElement(loginbutton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Username is required");

        driver.quit();
    }

    @Test
    public void test5() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get ("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By loginfield = By.id("user-name");
        By passwordfield = By.id("password");
        By loginbutton = By.id("login-button");
        By errorMessage = By.xpath("//h3[@data-test = 'error']");

        driver.findElement(loginfield).sendKeys("");
        driver.findElement(passwordfield).sendKeys("");
        driver.findElement(loginbutton).click();
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, "Epic sadface: Username is required");

        driver.quit();
    }

    @Test
    public void test7() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get ("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By sitefield = By.className("login_logo");

        driver.findElement(sitefield);

        boolean result = driver.findElement(sitefield).isDisplayed();
        Assert.assertTrue(result);


        driver.quit();
    }
}


