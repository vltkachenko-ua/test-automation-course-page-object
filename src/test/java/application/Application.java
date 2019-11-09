package application;

import data.AdminUser;

import data.ApplicationContext;
import data.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public ApplicationContext applicationContext;

    private AdminLoginPage adminLoginPage;
    private CountriesPage countriesPage;
    private AddNewCountryPage addNewCountryPage;
    private AdminHomePage adminHomePage;
    private CatalogPage catalogPage;
    private AddNewProductPage addNewProductPage;


    public Application() {

        applicationContext = new ApplicationContext()
                .updateDriver()
                .setDriver(new ChromeDriver())
                .setBaseUrl("http://demo.litecart.net")
                .setAdminUser(new AdminUser("demo", "demo"));

        adminLoginPage = new AdminLoginPage(applicationContext);
        countriesPage = new CountriesPage(applicationContext);
        addNewCountryPage = new AddNewCountryPage(applicationContext);
        adminHomePage = new AdminHomePage(applicationContext);
        catalogPage = new CatalogPage(applicationContext);
        addNewProductPage = new AddNewProductPage(applicationContext);
    }

    public void quit() {
        applicationContext.getDriver().quit();
    }

    public List<WebElement> getAllArrowIconOnAddNewCountryPage() {
        adminLoginPage.open();
        countriesPage.open();
        return addNewCountryPage.arrowIconClickOn();
    }

    public boolean waitForNewWindow() {
        ArrayList<String> tabs = new ArrayList<String>(applicationContext.getDriver().getWindowHandles());
        applicationContext.getDriver().switchTo().window(tabs.get(1));
        applicationContext.getDriver().close();
        applicationContext.getDriver().switchTo().window(tabs.get(0));
        return tabs.size() > 1;
    }

    public void addNewProduct(Product product) {
        adminLoginPage.open();
        adminHomePage.open().clickCatalog();
        catalogPage.clickAddNewProduct();
        addNewProductPage.addProduct(product);
    }

}