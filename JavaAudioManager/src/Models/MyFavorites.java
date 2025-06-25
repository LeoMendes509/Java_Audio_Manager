package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for managing registered music and podcasts,
 * and for controlling the user's favorite items.
 */
public class MyFavorites {

    // Lists to store all media
    private List<Music> allMusic = new ArrayList<>();
    private List<Podcast> allPodcasts = new ArrayList<>();
    private List<Music> favoriteMusic = new ArrayList<>();
    private List<Podcast> favoritePodcasts = new ArrayList<>();

    // === ADD METHODS ===

    public void addMusic(Music music, boolean addToFavorites) {
        if (music == null || music.getTitle().isBlank()) {
            System.out.println("❌ Invalid music title.");
            return;
        }

        if (!allMusic.contains(music)) {
            allMusic.add(music);
        }

        if (addToFavorites) {
            addMusicToFavorites(music);
        }
    }

    public void addPodcast(Podcast podcast, boolean addToFavorites) {
        if (podcast == null || podcast.getTitle().isBlank()) {
            System.out.println("❌ Invalid podcast title.");
            return;
        }

        if (!allPodcasts.contains(podcast)) {
            allPodcasts.add(podcast);
        }

        if (addToFavorites) {
            addPodcastToFavorites(podcast);
        }
    }

    // === HELPER METHODS FOR FAVORITES ===

    private void addMusicToFavorites(Music music) {
        if (!favoriteMusic.contains(music)) {
            favoriteMusic.add(music);
            System.out.printf("🎶✨ *%s* successfully added to your favorites! 💖🎧%n", music.getTitle());
        } else {
            System.out.println("⚠️ " + music.getTitle() + " is already in your favorites list.");
        }
    }

    private void addPodcastToFavorites(Podcast podcast) {
        if (!favoritePodcasts.contains(podcast)) {
            favoritePodcasts.add(podcast);
            System.out.printf("🎧✨ *%s* has been added to your favorites! 📻💬%n", podcast.getTitle());
        } else {
            System.out.println("⚠️ " + podcast.getTitle() + " is already in your favorites list.");
        }
    }

    // === LISTING METHODS ===

    public void listAllMusic() {
        if (allMusic.isEmpty()) {
            System.out.println("📭 No music registered.");
            return;
        }

        System.out.println("\n🎵 Registered Music:");
        for (Music music : allMusic) {
            displayMusicInfo(music);
        }
    }

    public void listFavoriteMusic() {
        if (favoriteMusic.isEmpty()) {
            System.out.println("📭 No favorite music.");
            return;
        }

        System.out.println("\n💖 Favorite Music:");
        for (Music music : favoriteMusic) {
            displayMusicInfo(music);
        }
    }

    public void listAllPodcasts() {
        if (allPodcasts.isEmpty()) {
            System.out.println("📭 No podcasts registered.");
            return;
        }

        System.out.println("\n🎙️ Registered Podcasts:");
        for (Podcast podcast : allPodcasts) {
            displayPodcastInfo(podcast);
        }
    }

    public void listFavoritePodcasts() {
        if (favoritePodcasts.isEmpty()) {
            System.out.println("📭 No favorite podcasts.");
            return;
        }

        System.out.println("\n💖 Favorite Podcasts:");
        for (Podcast podcast : favoritePodcasts) {
            displayPodcastInfo(podcast);
        }
    }

    // === DISPLAY HELPERS ===

    private void displayMusicInfo(Music music) {
        System.out.println("- " + music.getTitle());
        if (!music.getAlbum().isBlank()) {
            System.out.println("  Album: " + music.getAlbum());
        }
        System.out.println("  Artist: " + music.getArtist());
    }

    private void displayPodcastInfo(Podcast podcast) {
        System.out.println("- " + podcast.getTitle());
        if (!podcast.getDescription().isBlank()) {
            System.out.println("  Description: " + podcast.getDescription());
        }
        System.out.println("  Host: " + podcast.getHost());
    }

    // === GENERAL DELETE METHOD ===

    public void deleteAudio(String title, String type) {
        if (title == null || title.isBlank() || type == null) {
            System.out.println("❌ Invalid title or type.");
            return;
        }

        if (type.equalsIgnoreCase("music")) {
            removeMusic(title);
        } else if (type.equalsIgnoreCase("podcast")) {
            removePodcast(title);
        } else {
            System.out.println("❌ Invalid type. Use 'music' or 'podcast'.");
        }
    }

    // === REMOVE MUSIC FROM ALL LISTS ===

    private void removeMusic(String title) {
        Music musicToRemove = null;

        for (Music music : allMusic) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                musicToRemove = music;
                break;
            }
        }

        if (musicToRemove != null) {
            allMusic.remove(musicToRemove);
            favoriteMusic.remove(musicToRemove);
            System.out.println("🗑️ Music \"" + title + "\" successfully removed from all lists.");
        } else {
            System.out.println("⚠️ Music \"" + title + "\" not found.");
        }
    }

    // === REMOVE PODCAST FROM ALL LISTS ===

    private void removePodcast(String title) {
        Podcast podcastToRemove = null;

        for (Podcast podcast : allPodcasts) {
            if (podcast.getTitle().equalsIgnoreCase(title)) {
                podcastToRemove = podcast;
                break;
            }
        }

        if (podcastToRemove != null) {
            allPodcasts.remove(podcastToRemove);
            favoritePodcasts.remove(podcastToRemove);
            System.out.println("🗑️ Podcast \"" + title + "\" successfully removed from all lists.");
        } else {
            System.out.println("⚠️ Podcast \"" + title + "\" not found.");
        }
    }
}

// This project was developed by Leonardo Mendes Rodrigues.
