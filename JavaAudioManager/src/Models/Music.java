package Models;

/**
 * Class that represents a music track, inheriting properties and methods from the Audio class.
 * Includes specific attributes for music, such as genre and album.
 */
public class Music extends Audio {

    private String artist;
    private String album;
    private String genre;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Overrides the getRating() method to calculate a rating for the music
     * based on the number of likes.
     *
     * @return The rating of the music.
     */
    @Override
    public int getRating() {
        if (this.getTotalLikes() > 500) {
            return 10; // Huge success!
        } else {
            return 8; // Good, but could use more likes.
        }
    }
}

// This project was developed by Leonardo Mendes Rodrigues.
