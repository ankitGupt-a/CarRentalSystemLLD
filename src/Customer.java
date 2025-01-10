public class Customer {
    private final String name;
    private final String driverLicenseNumber;
    private final String address;
    private final String contactNumber;

    public Customer(final String name, final String driverLicenseNumber, final String address, final String contactNumber) {
        this.name = name;
        this.driverLicenseNumber = driverLicenseNumber;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
