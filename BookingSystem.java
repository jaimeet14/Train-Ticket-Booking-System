public class BookingSystem {

    public synchronized String bookTicket(User user, Train train) {
        if (train.getAvailableSeats() > 0) {
            train.setAvailableSeats(train.getAvailableSeats() - 1);
            return user.getName() + " booked successfully!";
        } else {
            return "No seats available!";
        }
    }
}