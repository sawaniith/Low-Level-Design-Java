package Spotify;

import java.time.Duration;
import java.util.UUID;

class Song {
    private final String id;
    private final String title;
    private final Artist artist;
    private final Album album;
    private final Language language;
    private final int durationInSeconds;

    public Song(String title, Artist artist, Album album, Language language, int durationInSeconds) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.language = language;
        this.durationInSeconds = durationInSeconds;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Artist getArtist() { return artist; }
    public Album getAlbum() { return album; }
    public Language getLanguage() { return language; }
    public int getDuration() { return durationInSeconds; }
    public String getArtistName() { return artist.getName(); }
}
