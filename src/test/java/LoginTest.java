import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void test1() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.titleisDisplayed());
    }

    @Test
    public void test2() {
        loginPage.open();
        loginPage.login("standard_user", "");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Password is required");
    }

    @Test
    public void test3() {
        loginPage.open();
        loginPage.login("standard_user", "123124124");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void test4() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username is required");
    }

    @Test
    public void test5() {
        loginPage.open();
        loginPage.login("", "");
        String error = loginPage.getErrorMessage();
        Assert.assertEquals(error, "Epic sadface: Username is required");


    }
}





