package data;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class ProductDataProvide {
    @DataProvider
    public static Object[][] validProduct() {
        return new Object[][]{
                {Product.newEntity()
                        .withName("TVV" + System.currentTimeMillis())
                        .withCode("TVV Code")
                        .withShortDescription("Description")
                        .withDescription("Short Description")
                        .withTechnicalData("Technical Data")
                        .withHeadTitle("TVV Title")
                        .withMetaDescription("Meta Description")
                        .withPurchasePrice("20")
                        .withPriceUSD("10")
                        .build()
                }
        };
    }
}
