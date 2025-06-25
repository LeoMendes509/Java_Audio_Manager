package Main;

import java.util.Scanner;
import Models.Music;
import Models.Podcast;
import Models.MyFavorites;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyFavorites favorites = new MyFavorites();  // Instance to store favorite items

        // Prompt for username and welcome message
        System.out.print("👤 Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("\n✨ Welcome, " + userName + "! Let's begin your musical experience! 🎶🎧");

        int option = -1;

        // Main menu loop
        while (option != 0) {
            // Display menu options
            System.out.println("\n🎵 MENU - MY MEDIA 🎧");
            System.out.println("1. Add Music");
            System.out.println("2. Add Podcast");
            System.out.println("3. List All Songs");
            System.out.println("4. List Favorite Songs");
            System.out.println("5. List All Podcasts");
            System.out.println("6. List Favorite Podcasts");
            System.out.println("7. Delete Music");
            System.out.println("8. Delete Podcast");
            System.out.println("9. Return to Previous Menu");
            System.out.println("0. Exit");

            System.out.print("Choose an option (0 to 9): ");
            String input = scanner.nextLine().trim();

            // Validate input (only digits 0–9 allowed)
            if (!input.matches("[0-9]")) {
                System.out.println("⚠ Invalid input. Enter a number from 0 to 9.");
                continue;
            }

            option = Integer.parseInt(input);

            // Handle menu option
            switch (option) {
                case 1:
                    // Create and configure a new Music object
                    Music music = new Music();  // CORRIGIDO: era Musica, agora Music
                    music.setTitle(readText(scanner, "🎶 Music title: "));
                    music.setArtist(readText(scanner, "🎤 Artist: "));
                    music.setAlbum(readOptionalText(scanner, "📀 Album (optional): "));
                    music.setGenre(readOptionalText(scanner, "🎼 Genre (optional): "));

                    // Play simulation
                    System.out.print("▶ How many times would you like to play it? ");
                    int musicPlays = readFormattedNumber(scanner);
                    for (int i = 0; i < musicPlays; i++) {
                        music.play();  // CORRIGIDO: método reproduz() para play()
                    }

                    // Likes simulation
                    System.out.print("❤ How many likes? ");
                    int musicLikes = readFormattedNumber(scanner);
                    for (int i = 0; i < musicLikes; i++) {
                        music.like();  // CORRIGIDO: método curte() para like()
                    }

                    // Highlight popular content
                    if (musicPlays > 1000) {
                        System.out.println("🎶 Wow! Your music is getting a lot of plays!");
                    }
                    if (musicLikes > 500) {
                        System.out.println("❤ What a hit! Your music has a lot of likes!");
                    }

                    // Ask if user wants to add to favorites
                    System.out.print("Do you want to add the song to favorites? (yes/no): ");
                    String musicAnswer = scanner.nextLine().trim();

                    if (musicAnswer.equalsIgnoreCase("yes")) {
                        favorites.addMusic(music, true);  // CORRIGIDO: incluiMusica → addMusic
                        System.out.println("🎶 Song added to your favorites!");
                    } else if (musicAnswer.equalsIgnoreCase("no")) {
                        favorites.addMusic(music, false);
                        System.out.println("🎶 Song was registered but not added to favorites.");
                    } else {
                        favorites.addMusic(music, false);
                        System.out.println("⚠ Invalid answer. Song registered but not added to favorites.");
                    }
                    break;

                case 2:
                    // Create and configure a new Podcast object
                    Podcast podcast = new Podcast();
                    podcast.setTitle(readText(scanner, "🎧 Podcast title: "));
                    podcast.setHost(readText(scanner, "🗣 Host: "));
                    podcast.setDescription(readOptionalText(scanner, "📝 Description (optional): "));

                    // Play simulation
                    System.out.print("▶ How many times would you like to play it? ");
                    int podcastPlays = readFormattedNumber(scanner);
                    for (int i = 0; i < podcastPlays; i++) {
                        podcast.play();
                    }

                    // Likes simulation
                    System.out.print("❤ How many likes? ");
                    int podcastLikes = readFormattedNumber(scanner);
                    for (int i = 0; i < podcastLikes; i++) {
                        podcast.like();
                    }

                    // Highlight popular podcast
                    if (podcastPlays > 1000) {
                        System.out.println("🎧 Wow! Your podcast is getting a lot of plays!");
                    }
                    if (podcastLikes > 500) {
                        System.out.println("❤ What a hit! Your podcast has a lot of likes!");
                    }

                    // Ask if user wants to add to favorites
                    System.out.print("Do you want to add the podcast to favorites? (yes/no): ");
                    String podcastAnswer = scanner.nextLine().trim();

                    if (podcastAnswer.equalsIgnoreCase("yes")) {
                        favorites.addPodcast(podcast, true);
                        System.out.println("🎧 Podcast added to your favorites!");
                    } else if (podcastAnswer.equalsIgnoreCase("no")) {
                        favorites.addPodcast(podcast, false);
                        System.out.println("🎧 Podcast was registered but not added to favorites.");
                    } else {
                        favorites.addPodcast(podcast, false);
                        System.out.println("⚠ Invalid answer. Podcast registered but not added to favorites.");
                    }
                    break;

                case 3:
                    // List all songs
                    favorites.listAllMusic();
                    break;
                case 4:
                    // List favorite songs
                    favorites.listFavoriteMusic();
                    break;
                case 5:
                    // List all podcasts
                    favorites.listAllPodcasts();
                    break;
                case 6:
                    // List favorite podcasts
                    favorites.listFavoritePodcasts();
                    break;
                case 7:
                    // Delete a music entry by title
                    System.out.print("Enter the title of the song you want to delete: ");
                    String songTitleToDelete = scanner.nextLine();
                    favorites.deleteAudio(songTitleToDelete, "music");  // CORRIGIDO: excluirAudio → deleteAudio; "musica" → "music"
                    break;
                case 8:
                    // Delete a podcast entry by title
                    System.out.print("Enter the title of the podcast you want to delete: ");
                    String podcastTitleToDelete = scanner.nextLine();
                    favorites.deleteAudio(podcastTitleToDelete, "podcast");
                    break;
                case 9:
                    // Return to previous menu
                    System.out.println("↩ Returning to previous menu...");
                    break;
                case 0:
                    // Exit program
                    System.out.println("👋 Closing the program. See you soon!");
                    break;
                default:
                    // Invalid option handler
                    System.out.println("⚠ Invalid option. Please choose a number from 0 to 9.");
            }
        }

        scanner.close(); // Close input scanner
    }

    // Reads mandatory input text
    public static String readText(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Reads optional input text
    public static String readOptionalText(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Reads a formatted number, accepting only digits
    public static int readFormattedNumber(Scanner scanner) {
        String input;
        int number = 0;
        boolean validated = false;
        while (!validated) {
            input = scanner.nextLine().replaceAll("[^0-9]", "");
            if (!input.isEmpty()) {
                try {
                    number = Integer.parseInt(input);
                    validated = true;
                } catch (NumberFormatException e) {
                    System.out.println("⚠ Invalid input. Please enter numbers only.");
                }
            } else {
                System.out.println("⚠ Invalid input. Please enter a number.");
            }
        }
        return number;
    }
}

// This project was developed by Leonardo Mendes Rodrigues.
