package dataclasses;

/**
 * Represents a song.
 * Implements the ISong interface.
 */
public class Song implements ISong {
  private String name; // song name
  private int id; // song id
  private IArtist artist; // song artist
  private double rating; // song rating
  private double irlIndex; // song IRL index - represents how willing you are to see it live

  public Song(String name, int id, IArtist artist, double rating, double irlIndex)
      throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Song name cannot be null or empty.");
    }
    if (id < 0) {
      throw new IllegalArgumentException("Song ID cannot be negative.");
    }
    if (artist == null) {
      throw new IllegalArgumentException("Song artist cannot be null.");
    }
    if (rating < 0 || rating > 5) {
      throw new IllegalArgumentException("Song rating must be above 0 and 5.");
    }
    if (irlIndex < 0 || irlIndex > 5) {
      throw new IllegalArgumentException("Song IRL index must be between 0 and 5.");
    }

    this.name = name;
    this.id = id;
    this.artist = artist;
    this.rating = rating;
    this.irlIndex = irlIndex;
  }

  public Song(int id, String name, IArtist artist, double rating, double irlIndex)
          throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Song name cannot be null or empty.");
    }
    if (id < 0) {
      throw new IllegalArgumentException("Song ID cannot be negative.");
    }
    if (artist == null) {
      throw new IllegalArgumentException("Song artist cannot be null.");
    }
    if (rating < 0 || rating > 5) {
      throw new IllegalArgumentException("Song rating must be above 0 and 5.");
    }
    if (irlIndex < 0 || irlIndex > 5) {
      throw new IllegalArgumentException("Song IRL index must be between 0 and 5.");
    }

    this.name = name;
    this.id = id;
    this.artist = artist;
    this.rating = rating;
    this.irlIndex = irlIndex;
  }

  @Override
  public int getID() throws IllegalStateException {
    if (this.id == 0) {
      throw new IllegalStateException("Song ID is not set.");
    }
    return this.id;
  }

  @Override
  public String getName() throws IllegalStateException {
    if (this.name == null || this.name.equals("")) {
      throw new IllegalStateException("Song name is not set.");
    }
    return this.name;
  }

  @Override
  public IArtist getArtist() throws IllegalStateException {
    if (this.artist == null) {
      throw new IllegalStateException("Song artist is not set.");
    }
    return this.artist;
  }

  @Override
  public String getArtistName() throws IllegalStateException {
    if (this.artist == null) {
      throw new IllegalStateException("Song artist is not set.");
    }
    return this.artist.getName();
  }

  @Override
  public double getRating() throws IllegalStateException {
    if (this.rating == 0) {
      throw new IllegalStateException("Song rating is not set.");
    }
    return this.rating;
  }

  @Override
  public double getIRLIndex() throws IllegalStateException {
    if (this.irlIndex == 0) {
      throw new IllegalStateException("Song IRL index is not set.");
    }
    return this.irlIndex;
  }

  @Override
  public void setID(int id) throws IllegalArgumentException {
    if (id < 0) {
      throw new IllegalArgumentException("Song ID cannot be negative.");
    }
    this.id = id;
  }

  @Override
  public void setSongName(String name) throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Song name cannot be null or empty.");
    }
    this.name = name;
  }

  @Override
  public void setArtist(IArtist artist) throws IllegalArgumentException {
    if (artist == null) {
      throw new IllegalArgumentException("Song artist cannot be null.");
    }
    this.artist = artist;
  }

  @Override
  public void setRating(double rating) throws IllegalArgumentException {
    if (rating < 0 || rating > 10) {
      throw new IllegalArgumentException("Song rating must be between 0 and 10.");
    }
    this.rating = rating;
  }

  @Override
  public void setIRLIndex(double irlIndex) throws IllegalArgumentException {
    if (irlIndex < 0 || irlIndex > 5) {
      throw new IllegalArgumentException("Song IRL index must be between 0 and 5.");
    }
    this.irlIndex = irlIndex;
  }

  @Override
  public double calculateOverallRating() throws IllegalStateException {
    if (this.irlIndex == 0) {
      throw new IllegalStateException("Song IRL index is not set.");
    }
    if (this.rating < 0 || this.rating > 5) {
      throw new IllegalStateException("Song rating is invalid.");
    }
    return (this.rating + this.irlIndex) / 2;
  }

  @Override
  public String toString() {
    return this.name + " by " + this.artist.getName();
  }
}