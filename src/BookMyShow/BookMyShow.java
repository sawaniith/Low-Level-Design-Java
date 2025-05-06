package BookMyShow;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BookMyShow {
    public Map<String, List<Movie>> cityMovies;
    public Map<String, List<Theater>> cityTheaters;

    public BookMyShow() {
        cityMovies = new ConcurrentHashMap<>();
        cityTheaters = new ConcurrentHashMap<>();
    }

    public void addMovies(String city, Movie movie){
        cityMovies.putIfAbsent(city, new ArrayList<>());
        cityMovies.get(city).add(movie);
    }

    public void addTheaters(String city, Theater theater){
        cityTheaters.putIfAbsent(city, new ArrayList<>());
        cityTheaters.get(city).add(theater);
    }

    public List<Movie> getMovies(String city){
        return cityMovies.get(city);
    }

    public Map<Theater, List<Show>> getShows(Movie movie, String city) {
        List<Theater> theaters = cityTheaters.getOrDefault(city, Collections.emptyList());
        Map<Theater, List<Show>> result = new HashMap<>();

        for (Theater theater : theaters) {
            List<Show> filteredShows = theater.getShows().stream()
                    .filter(show -> show.getMovie().getId().equals(movie.getId()))
                    .collect(Collectors.toList());

            if (!filteredShows.isEmpty()) {
                result.put(theater, filteredShows);
            }
        }
        return result;
    }

    public void addShow(Theater theater, Show show){
        theater.addShow(show);
    }

    public synchronized void bookShow(User user, Show show, List<ShowSeat> showSeats){

    }
}
