package pages;

import data.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminHomePage extends Page {

    @FindBy(partialLinkText = "Catalog")
    private WebElement catalog;

    public AdminHomePage(ApplicationContext apContext) {
        super(apContext);
        PageFactory.initElements(driver, this);
    }

    public AdminHomePage open() {
        driver.get(baseUrl + "/admin/");
        if (!isOnThisPage())
            return null;
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.id("box-apps-menu")).size() > 0;
    }

    public CatalogPage clickCatalog() {
        catalog.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("catalog_form")));
        return new CatalogPage(appContext);
    }
}
