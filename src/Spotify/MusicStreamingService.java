package Spotify;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MusicStreamingService {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Song> songs = new ConcurrentHashMap<>();
    private final Map<String, Album> albums = new ConcurrentHashMap<>();
    private final Map<String, Artist> artists = new ConcurrentHashMap<>();

    public User registerUser(String username, String password) {
        User user = new User(username, password);
        users.put(user.getId(), user);
        return user;
    }

    public Artist addNewArtist(String name) {
        Artist artist = new Artist(name);
        artists.put(artist.getId(), artist);
        return artist;
    }

    public Album addNewAlbum(String title, String artistId) {
        Artist artist = artists.get(artistId);
        if (artist == null) {
            throw new IllegalArgumentException("Artist with ID " + artistId + " not found");
        }
        Album album = new Album(title, artist);
        albums.put(album.getId(), album);
        return album;
    }

    public Song addNewSong(String title, String artistId, String albumId, Language language, int duration) {
        Artist artist = artists.get(artistId);
        if (artist == null) {
            throw new IllegalArgumentException("Artist with ID " + artistId + " not found");
        }
        Album album = albums.get(albumId);
        if (album == null) {
            throw new IllegalArgumentException("Album with ID " + albumId + " not found");
        }
        Song song = new Song(title, artist, album, language, duration);
        songs.put(song.getId(), song);
        album.addSong(song);
        return song;
    }

    public Playlist createPlaylist(String userId, String name) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        return user.createPlaylist(name);
    }

    public void addSongToPlaylist(String userId, String playlistId, String songId) {
        User user = users.get(userId);
        Song song = songs.get(songId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        if (song == null) {
            throw new IllegalArgumentException("Song with ID " + songId + " not found");
        }
        Playlist playlist = user.getPlaylist(playlistId);
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist with ID " + playlistId + " not found");
        }
        playlist.addSong(song);
    }

    public List<Song> searchSongs(String keyword) {
        List<Song> results = new ArrayList<>();
        for (Song song : songs.values()) {
            if (song.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }

    public void playSong(String userId, String songId) {
        User user = users.get(userId);
        Song song = songs.get(songId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        if (song == null) {
            throw new IllegalArgumentException("Song with ID " + songId + " not found");
        }
        user.playSong(song);
    }

    public void playPlaylist(String userId, List<Song> songs) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        user.playPlaylist(songs);
    }

    public void playNext(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        user.playNext();
    }

    public void playPrevious(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        user.playPrevious();
    }

    public void pauseSong(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        user.pause();
    }
}