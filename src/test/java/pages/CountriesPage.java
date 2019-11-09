package pages;

import data.ApplicationContext;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CountriesPage extends Page {

    @FindBy(css = "a.btn.btn-default")
    private WebElement addNewCountryButton;


    public CountriesPage(ApplicationContext apContext) {
        super(apContext);
        PageFactory.initElements(driver, this);
    }

    public CountriesPage open() {
        driver.get(baseUrl + "/admin/?app=countries&doc=countries");
        if (isOnThisPage())
            this.addNewCountryClickOn();
        return this;
    }

    public boolean isOnThisPage() {
        return addNewCountryButton.isDisplayed();
    }

    public AddNewCountryPage addNewCountryClickOn() {
        addNewCountryButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("save")));
        return new AddNewCountryPage(appContext);
    }




}


