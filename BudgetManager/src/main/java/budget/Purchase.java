package budget;

public class Purchase {
    final private String name;
    final private double price;
    final private PurchaseCategory category;

    private Purchase (PurchaseCategory category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

//    private void setName(String name) {
//        this.name = name;
//    }

    public double getPrice() {
        return price;
    }

//    private void setPrice(double price) {
//        this.price = price;
//    }

    public PurchaseCategory getCategory() {
        return category;
    }

//    private void setCategory(PurchaseCategory category) {
//        this.category = category;
//    }

    @Override
    public String toString() {
        return getName() + " $" + String.format("%.2f", getPrice());
    }

    static class Builder {
        private PurchaseCategory category;
        private String name;
        private double price;

        Builder() {
        }

        Builder setCategory(PurchaseCategory category) {
            this.category = category;
            return this;
        }

        Builder setName(String name) {
            this.name = name;
            return this;
        }

        Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        Purchase build() {
            return new Purchase(category, name, price);
        }
    }
}
