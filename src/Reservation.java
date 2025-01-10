import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;


public class Reservation {
    private final String id;
    private final Car car;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalAmount;

    public Reservation(final Car car, final Customer customer, final LocalDate startDate, final LocalDate endDate) {
        this.id = UUID.randomUUID().toString();
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = calculateAmount();
    }

    private double calculateAmount() {
        long rentedDays = DAYS.between(startDate, endDate)+1;
        return rentedDays*car.getRentPricePerDay();
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }

}
