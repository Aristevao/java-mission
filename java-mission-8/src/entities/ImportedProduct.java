package entities;

public class ImportedProduct extends Product {
    private final Double customFee;

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    @Override
    public String priceTag() {
        return getName()
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Customs fee: $ "
                + String.format("%.2f", customFee)
                + ")";
    }

    Double totalPrice() {
        return getPrice() + customFee;
    }
}
