package entity;


import java.util.function.Consumer;

public class Shopper {
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String address;
    private final String city;
    private final String zipCode;
    private final String address2;
    private final String state;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress2() {
        return address2;
    }

    public String getState() {
        return state;
    }

    private Shopper(ShopperBuilder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.city = builder.city;
        this.zipCode = builder.zipcode;
        this.address2 = builder.address2;
        this.state = builder.state;
    }


    public static class ShopperBuilder {
        private final String email;
        private final String password;
        public String firstName;
        public String lastName;
        public String address;
        public String city;
        public String zipcode;
        public String address2;
        public String state;
        public String phoneNumber;

        public ShopperBuilder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public ShopperBuilder builder(Consumer<ShopperBuilder> shopperBuilder){
            shopperBuilder.accept(this);
            return this;
        }

        public Shopper build() {
            Shopper shopper = new Shopper(this);
            return shopper;
        }
    }
}
