package Models;

/**
 * Base class representing a generic audio item, either music or podcast.
 * Contains common properties for all audio types, such as title, number of plays,
 * likes, and rating.
 */
public class Audio {

    private String title;
    private int totalPlays;
    private int totalLikes;
    private int rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getRating() {
        return rating;
    }

    /**
     * Increments the number of likes for the audio.
     */
    public void like() {
        this.totalLikes++;
    }

    /**
     * Increments the number of plays for the audio.
     */
    public void play() {
        this.totalPlays++;
    }
}

// This project was developed by Leonardo Mendes Rodrigues.
