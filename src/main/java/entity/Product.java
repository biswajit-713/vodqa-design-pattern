package entity;

public class Product {

    private String name;
    private String size;
    private int quantity;

    private Product(String name, String size, int quantity) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class builder {
        private String name;
        private String size;
        private int quantity;

        public builder() {
        }

        public builder(String name) {
            this.name = name;
        }

        public builder name(String name) {
            this.name = name;
            return this;
        }

        public builder size(String size) {
            this.size = size;
            return this;
        }

        public builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            Product product = new Product(name, size, quantity);
            return product;
        }
    }
}
