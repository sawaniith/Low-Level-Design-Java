package Spotify;

import java.util.List;
import java.util.concurrent.*;

public class PlaybackSession {
    private Song currentSong;
    private List<Song> currentPlaylist;
    private int currentIndex = -1;
    private volatile int currentTime; // seconds
    private volatile boolean isPlaying;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> scheduledTask;

    public synchronized void playSong(Song song) {
        stopPlaybackTask();
        currentSong = song;
        currentPlaylist = null;
        currentIndex = -1;
        currentTime = 0;
        isPlaying = true;
        System.out.println("Now playing: " + song.getTitle() + " from 0s");
        startPlaybackTimer();
    }

    public synchronized void playPlaylist(List<Song> songs) {
        if (songs == null || songs.isEmpty()) {
            System.out.println("No playlist playing.");
            return;
        }
        stopPlaybackTask();
        currentPlaylist = songs;
        currentIndex = 0;
        currentSong = currentPlaylist.get(currentIndex);
        currentTime = 0;
        isPlaying = true;
        System.out.println("Playing playlist: My Favorites");
        System.out.println("Now playing: " + currentSong.getTitle() + " from 0s");
        startPlaybackTimer();
    }

    public synchronized void playNext() {
        if (currentPlaylist == null || currentPlaylist.isEmpty()) {
            System.out.println("No playlist playing.");
            return;
        }
        if (currentIndex < currentPlaylist.size() - 1) {
            stopPlaybackTask();
            currentIndex++;
            currentSong = currentPlaylist.get(currentIndex);
            currentTime = 0;
            isPlaying = true;
            System.out.println("Playing next song:");
            System.out.println("Now playing: " + currentSong.getTitle() + " from 0s");
            startPlaybackTimer();
        } else {
            System.out.println("No next song.");
        }
    }

    public synchronized void playPrevious() {
        if (currentPlaylist == null || currentPlaylist.isEmpty()) {
            System.out.println("No playlist playing.");
            return;
        }
        if (currentIndex > 0) {
            stopPlaybackTask();
            currentIndex--;
            currentSong = currentPlaylist.get(currentIndex);
            currentTime = 0;
            isPlaying = true;
            System.out.println("Playing previous song:");
            System.out.println("Now playing: " + currentSong.getTitle() + " from 0s");
            startPlaybackTimer();
        } else {
            System.out.println("No previous song.");
        }
    }

    public synchronized void pause() {
        if (currentSong != null && isPlaying) {
            isPlaying = false;
            stopPlaybackTask();
            System.out.println("Paused: " + currentSong.getTitle() + " at " + currentTime + "s");
        }
    }

    private synchronized void startPlaybackTimer() {
        scheduledTask = scheduler.scheduleAtFixedRate(() -> {
            if (isPlaying && currentSong != null) {
                currentTime++;
                if (currentTime >= currentSong.getDuration()) {
                    if (currentPlaylist != null && currentIndex < currentPlaylist.size() - 1) {
                        currentIndex++;
                        currentSong = currentPlaylist.get(currentIndex);
                        currentTime = 0;
                        System.out.println("Auto playing next song: " + currentSong.getTitle());
                    } else {
                        System.out.println("Playback finished.");
                        stopPlaybackTask();
                        isPlaying = false;
                    }
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    private synchronized void stopPlaybackTask() {
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            scheduledTask.cancel(false);
        }
    }

    public synchronized void shutdown() {
        stopPlaybackTask();
        scheduler.shutdown();
    }
}