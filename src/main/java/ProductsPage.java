import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;
    By title = By.xpath("//div[@class = 'product_label']");
    By cart = By.id("shopping_cart_container");
    By productInCart = By.xpath("//span[@class = 'fa-layers-counter shopping_cart_badge']");
    String addToCart = "//div[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean titleisDisplayed() {
        return driver.findElement(title).isDisplayed();

    }

    public void addToCart(String productName) {
    driver.findElement(By.xpath(String.format(addToCart, productName))).click();
    }

    public void clickCart() {
        driver.findElement(cart).click();
    }

    public String getProductItemsInCart () {
        return driver.findElement(productInCart).getText();
    }
}
