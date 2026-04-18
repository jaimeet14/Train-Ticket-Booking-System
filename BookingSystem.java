import java.util.*;

public class BookingSystem {

    private Map<String, Integer> bookings = new HashMap<>();

    public synchronized String bookTicket(User user, Train train) {
        if (train.getAvailableSeats() > 0) {
            train.setAvailableSeats(train.getAvailableSeats() - 1);
            bookings.put(user.getName(), bookings.getOrDefault(user.getName(), 0) + 1);
            return user.getName() + " booked successfully! Seats left: " + train.getAvailableSeats();
        } else {
            return "No seats available!";
        }
    }

    public synchronized String cancelTicket(User user, Train train) {
        String name = user.getName();

        if (bookings.containsKey(name) && bookings.get(name) > 0) {
            bookings.put(name, bookings.get(name) - 1);
            train.setAvailableSeats(train.getAvailableSeats() + 1);
            return name + " canceled ticket. Seats left: " + train.getAvailableSeats();
        } else {
            return "No booking found for " + name;
        }
    }
}
