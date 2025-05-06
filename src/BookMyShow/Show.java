package BookMyShow;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private final String id;
    private final Movie movie;
    private final Theater theater; //optional as storing th show in theater
    private final LocalDate date;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    public List<ShowSeat> showSeats;

    public Show(String id, Movie movie, Theater theater, LocalDate date, LocalDateTime startTime, LocalDateTime endTime, List<ShowSeat> showSeats) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showSeats = showSeats;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public List<ShowSeat> getSeats() {
        return showSeats;
    }
}
