package tests.Homework3;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import data.Product;
import data.ProductDataProvide;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import tests.BaseTest;

@RunWith(DataProviderRunner.class)
public class AddNewProductTest extends BaseTest {

    @Test
    @UseDataProvider(value = "validProduct", location = ProductDataProvide.class)
    public void addNewProductTest(Product product) {
        app.addNewProduct(product);
        Assert.assertTrue(app.isNewProductAdded(product));
    }


}
