package Spotify;

import java.util.UUID;

class Artist {
    private final String id;
    private final String name;

    public Artist(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
