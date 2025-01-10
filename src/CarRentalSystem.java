import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CarRentalSystem {
    private static final CarRentalSystem instance = new CarRentalSystem();
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;

    private PaymentProcessor paymentProcessor;

    private CarRentalSystem() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        this.paymentProcessor = new CreditCardPaymentProcessor();
    }

    public static CarRentalSystem getInstance() {
        return instance;
    }

    public void addCar(final Car car) {
        cars.put(car.getPlateNumber(), car);
    }

    public void removeCar(final Car car) {
        cars.remove(car.getPlateNumber());
    }

    public synchronized Reservation madeReservation(final Car car, final Customer customer, final LocalDate startDate, final LocalDate endDate) {
        if (!car.isAvailable()) {
            return null;
        }
        car.setAvailable(false);
        Reservation reservation = new Reservation(car, customer, startDate, endDate);
        reservations.put(reservation.getId(), reservation);
        System.out.println("Car with number : " + car.getPlateNumber() + " is successfully booked");
        return reservation;
    }

    public synchronized void cancelReservation(Reservation reservation) {
        if (!reservations.containsKey(reservation.getId())) {
            throw new RuntimeException("No such reservation exists");
        }
        reservations.remove(reservation.getId());
        reservation.getCar().setAvailable(true);
    }

    public boolean isCarAvailable(final Car car, final LocalDate startDate, final LocalDate endDate) {
        return reservations.values().stream()
                .filter(reservation -> reservation.getCar().equals(car))
                .noneMatch(reservation -> startDate.isBefore(reservation.getEndDate()) &&
                        endDate.isAfter(reservation.getStartDate()));
    }

    public List<Car> search(final LocalDate startDate, final LocalDate endDate) {
        return cars.values().stream()
                .filter(car -> isCarAvailable(car, startDate, endDate))
                .collect(Collectors.toList());
    }
    public void setPaymentProcessor(final PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    public void makePayment(final Reservation reservation) {
        if (reservation!=null) {
            paymentProcessor.makePayment(reservation.getTotalAmount());
        }
    }
}
