package Models;

/**
 * Class that represents a podcast, inheriting properties and methods from the Audio class.
 * Includes specific attributes for podcasts, such as host and description.
 */
public class Podcast extends Audio {

    private String host;
    private String description;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Overrides the getRating() method to generate a rating
     * for the podcast based on the number of likes.
     *
     * @return The podcast's rating.
     */
    @Override
    public int getRating() {
        if (this.getTotalLikes() > 500) {
            return 10; // Absolute success!
        } else {
            return 8; // Good, but could have more likes.
        }
    }
}

// This project was developed by Leonardo Mendes Rodrigues.
