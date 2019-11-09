package pages;

import data.ApplicationContext;
import data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewProductPage extends Page {

    @FindBy(name = "name[en]")
    private WebElement nameElement;
    @FindBy(name = "code")
    private WebElement codeElement;
    @FindBy(name = "short_description[en]")
    private WebElement shortDescriptionElement;
    @FindBy(css = "div.trumbowyg-editor.trumbowyg-autogrow-on-enter")
    private WebElement descriptionElement;
    @FindBy(name = "technical_data[en]")
    private WebElement technicalDataElement;
    @FindBy(name = "head_title[en]")
    private WebElement headTitleElement;
    @FindBy(name = "meta_description[en]")
    private WebElement metaDescriptionElement;
    @FindBy(name = "purchase_price")
    private WebElement purchasePriceElement;
    @FindBy(name = "prices[USD]")
    private WebElement pricesUSDElement;
    @FindBy(name = "save")
    private WebElement saveButtonElement;


    public AddNewProductPage(ApplicationContext apContext) {
        super(apContext);
        PageFactory.initElements(driver, this);
    }


    public void addProduct(Product product) {
        nameElement.sendKeys(product.getName());
        codeElement.sendKeys(product.getCode());
        driver.findElement(By.linkText("Information")).click();
        shortDescriptionElement.sendKeys(product.getShortDescription());
        descriptionElement.sendKeys(product.getDescription());
        technicalDataElement.sendKeys(product.getTechnicalData());
        headTitleElement.sendKeys(product.getHeadTitle());
        metaDescriptionElement.sendKeys(product.getMetaDescription());
        driver.findElement(By.linkText("Prices")).click();
        purchasePriceElement.sendKeys(product.getPurchasePrice());
        pricesUSDElement.sendKeys(product.getPriceUSD());
        saveButtonElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("catalog_form")));
    }

    public boolean findProduct(Product product) {
        return driver.findElement(By.xpath(String.format("//td[contains(text(), '%s')]", product.getName()))).isDisplayed();
    }

}
