package BookMyShow;

public class Movie {
    public final String id;
    public final String title;
    public final String description;
    public final int durationInMinutes;

    public Movie(String id, String title, String description, int durationInMinutes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getId(){
        return id;
    }
}
