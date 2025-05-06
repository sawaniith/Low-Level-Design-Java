package BookMyShow;

import java.util.List;

public class Theater {
    private final String id;
    private final String name;
    private final String location;
    private final String city;
    private final List<Show> shows;

    public Theater(String id, String name, String location, String city, List<Show> shows) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.city = city;
        this.shows = shows;
    }

    public List<Show> getShows(){
        return shows;
    }

    public void addShow(Show show){
        shows.add(show);
    }
}
