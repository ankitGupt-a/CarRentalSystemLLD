public class Car {
    private final String model;
    private final int yearOfBuild;
    private final String plateNumber;

    private boolean available;
    private double rentPricePerDay;

    public Car(final String model, final int yearOfBuild, final String plateNumber, final double rentPricePerDay) {
        this.model = model;
        this.yearOfBuild = yearOfBuild;
        this.plateNumber = plateNumber;
        this.rentPricePerDay = rentPricePerDay;
        this.available = true;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfBuild() {
        return yearOfBuild;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getRentPricePerDay() {
        return rentPricePerDay;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRentPricePerDay(int rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }
}
