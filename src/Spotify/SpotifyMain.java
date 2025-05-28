package Spotify;

public class SpotifyMain {
    public static void main(String[] args) throws InterruptedException {
        MusicStreamingService service = new MusicStreamingService();

        // Add artist, album, and songs
        Artist artist = service.addNewArtist("Artist A");
        Album album = service.addNewAlbum("Album 1", artist.getId());

        Song song1 = service.addNewSong("Song 1", artist.getId(), album.getId(), Language.ENGLISH, 210);
        Song song2 = service.addNewSong("Song 2", artist.getId(), album.getId(), Language.ENGLISH, 180);
        Song song3 = service.addNewSong("Song 3", artist.getId(), album.getId(), Language.ENGLISH, 200);

        // Register user and create playlist
        User user = service.registerUser("user1", "password");
        Playlist playlist = user.createPlaylist("My Favorites");
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        // Play playlist
        user.playPlaylist(playlist.getSongs());

        Thread.sleep(3000); // Wait 3 seconds of playback

        // Pause playback
        user.pause();

        Thread.sleep(2000); // Wait 2 seconds paused

        // Play next song
        user.playNext();

        Thread.sleep(2000); // Play 2 seconds

        // Pause again
        user.pause();

        // Shutdown scheduler on exit (important!)
        user.shutdownPlayback();
    }
}