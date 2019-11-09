package pages;

import data.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage extends Page {

    @FindBy(css = "ul.list-inline")
    private WebElement listInline;


    public CatalogPage(ApplicationContext apContext) {
        super(apContext);
        PageFactory.initElements(driver, this);
    }

    public CatalogPage open() {
        driver.get(baseUrl + "/admin/?app=catalog&doc=catalog");
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElement(By.className("panel-heading")).getText().trim().equals("Catalog");
    }

    public AddNewProductPage clickAddNewProduct() {
        listInline.findElements(By.tagName("li")).get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.main-image")));
        return new AddNewProductPage(appContext);
    }
}
