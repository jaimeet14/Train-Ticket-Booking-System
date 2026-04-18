public class Train {
    private int trainId;
    private int availableSeats;

    public Train(int trainId, int seats) {
        this.trainId = trainId;
        this.availableSeats = seats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int seats) {
        this.availableSeats = seats;
    }
}