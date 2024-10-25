import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By loginfield = By.id("user-name");
    By passwordfield = By.id("password");
    By loginbutton = By.id("login-button");
    By errorMessage = By.xpath("//h3[@data-test = 'error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    public void login(String user, String password) {
        driver.findElement(loginfield).sendKeys(user);
        driver.findElement(passwordfield).sendKeys(password);
        driver.findElement(loginbutton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
