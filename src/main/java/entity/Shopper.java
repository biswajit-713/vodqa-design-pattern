package entity;


public class Shopper {
    private final String email;
    private final String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;
    private String address2;
    private String state;

//    public Shopper(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public Shopper(String email, String password, String firstName, String lastName, String phoneNumber,
//                   String address, String city, String zipCode) {
//        this.email = email;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.city = city;
//        this.zipCode = zipCode;
//    }

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
        this.phoneNumber = builder.phoneNUmber;
        this.city = builder.city;
        this.zipCode = builder.zipcode;
        this.address2 = builder.address2;
        this.state = builder.state;
    }

    public static class ShopperBuilder {
        private final String email;
        private final String password;
        private String firstName;
        private String lastName;
        private String phoneNUmber;
        private String address;
        private String city;
        private String zipcode;
        private String address2;
        private String state;

        public ShopperBuilder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public ShopperBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ShopperBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ShopperBuilder phoneNumber(String phoneNUmber) {
            this.phoneNUmber = phoneNUmber;
            return this;
        }

        public ShopperBuilder address(String address) {
            this.address = address;
            return this;
        }

        public ShopperBuilder city(String city) {
            this.city = city;
            return this;
        }

        public ShopperBuilder zipCode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public ShopperBuilder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public ShopperBuilder state(String state) {
            this.state = state;
            return this;
        }

        public Shopper build() {
            Shopper shopper = new Shopper(this);
            return shopper;
        }
    }
}
