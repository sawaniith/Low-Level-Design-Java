package Spotify;

import java.util.*;

public class User {
    private final String id;
    private final String username;
    private final String password;
    private final Map<String, Playlist> playlists = new HashMap<>();
    private final PlaybackSession playbackSession = new PlaybackSession();

    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public Playlist createPlaylist(String name) {
        Playlist playlist = new Playlist(name, this);
        playlists.put(playlist.getId(), playlist);
        return playlist;
    }

    public Playlist getPlaylist(String playlistId) {
        return playlists.get(playlistId);
    }

    public void playSong(Song song) {
        playbackSession.playSong(song);
    }

    public void playPlaylist(List<Song> songs) {
        playbackSession.playPlaylist(songs);
    }

    public void playNext() {
        playbackSession.playNext();
    }

    public void playPrevious() {
        playbackSession.playPrevious();
    }

    public void pause() {
        playbackSession.pause();
    }

    public void shutdownPlayback() {
        playbackSession.shutdown();
    }
}