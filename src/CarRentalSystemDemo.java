import java.time.LocalDate;
import java.util.List;

public class CarRentalSystemDemo {

    public static void main(String[] args) {
        final CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();

        final Car car1 = new Car("car1", 2015, "car12015", 600);
        final Car car2 = new Car("car2", 2016, "car22016", 700);
        final Car car3 = new Car("car3", 2017, "car32017", 800);
        final Car car4 = new Car("car4", 2018, "car42018", 900);
        final Car car5 = new Car("car5", 2019, "car52019", 1000);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);
        carRentalSystem.addCar(car5);

        Customer customer = new Customer("ankit", "1234", "Pune", "987654321");

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(5);
        List<Car> availableCars = carRentalSystem.search(startDate, endDate);

        for (Car car: availableCars) {
            if (car.isAvailable()) {
                Reservation reservation = carRentalSystem.madeReservation(car, customer, startDate, endDate);
                carRentalSystem.makePayment(reservation);
            }
        }

    }


}
