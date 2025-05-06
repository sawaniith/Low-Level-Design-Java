package BookMyShow;

public class ShowSeat {
    public Seat seat;
    public SeatStatus status;
    public double price;

    public ShowSeat(Seat seat, SeatStatus status, double price) {
        this.seat = seat;
        this.status = status;
        this.price = price;
    }
}
