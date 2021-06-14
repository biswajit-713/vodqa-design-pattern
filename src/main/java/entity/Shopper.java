package entity;


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

    private Shopper(builder builder) {
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

    public static class builder {
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

        public builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public builder phoneNumber(String phoneNUmber) {
            this.phoneNUmber = phoneNUmber;
            return this;
        }

        public builder address(String address) {
            this.address = address;
            return this;
        }

        public builder city(String city) {
            this.city = city;
            return this;
        }

        public builder zipCode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public builder state(String state) {
            this.state = state;
            return this;
        }

        public Shopper build() {
            Shopper shopper = new Shopper(this);
            return shopper;
        }
    }
}
