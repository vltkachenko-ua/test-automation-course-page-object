package data;


public class Product {
    private String name;
    private String code;
    private String shortDescription;
    private String description;
    private String technicalData;
    private String headTitle;
    private String metaDescription;
    private String purchasePrice;
    private String priceUSD;

    public static Builder newEntity() {
        return new Product().new Builder();
    }

    public String getName(){ return name;}
    public String getCode(){return code;}
    public String getShortDescription(){return shortDescription;}
    public String getDescription(){return description;}
    public String getTechnicalData(){return technicalData;}
    public String getHeadTitle(){return headTitle;}
    public String getMetaDescription(){return metaDescription;}
    public String getPurchasePrice(){return purchasePrice;}
    public String getPriceUSD(){return priceUSD;}



    public class Builder {
        private Builder() {
        }
        public Builder withName(String name){
            Product.this.name = name;
            return this;
        }
        public Builder withCode(String code){
            Product.this.code = code;
            return this;
        }
        public Builder withShortDescription(String shortDescription){
            Product.this.shortDescription = shortDescription;
            return this;
        }
        public Builder withDescription(String description){
            Product.this.description = description;
            return this;
        }
        public Builder withTechnicalData(String technicalData){
            Product.this.technicalData = technicalData;
            return this;
        }
        public Builder withHeadTitle(String headTitle){
            Product.this.headTitle = headTitle;
            return this;
        }
        public Builder withMetaDescription(String metaDescription){
            Product.this.metaDescription = metaDescription;
            return this;
        }
        public Builder withPurchasePrice(String purchasePrice){
            Product.this.purchasePrice = purchasePrice;
            return this;
        }
        public Builder withPriceUSD(String priceUSD){
            Product.this.priceUSD = priceUSD;
            return this;
        }
        public Product build(){return Product.this;}
    }

}
