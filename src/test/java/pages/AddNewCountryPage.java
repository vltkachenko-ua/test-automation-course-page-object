package pages;

import data.ApplicationContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewCountryPage extends Page {


    public AddNewCountryPage(ApplicationContext apContext) {
        super(apContext);
    }

    public List<WebElement> arrowIconClickOn() {
        return driver.findElements(By.cssSelector("i.fa.fa-external-link"));
    }
}
