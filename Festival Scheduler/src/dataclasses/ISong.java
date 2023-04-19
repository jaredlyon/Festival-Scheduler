package dataclasses;

/**
 * Represents the general song data class.
 */
public interface ISong {

  /**
   * Returns the ID of the song.
   *
   * @return the ID of the song
   * @throws IllegalStateException if the ID is not set
   */
  public int getID() throws IllegalStateException;

  /**
   * Returns the name of the song.
   *
   * @return the name of the song
   * @throws IllegalStateException if the name is not set
   */
  public String getSongName() throws IllegalStateException;

  /**
   * Returns the artist of the song.
   *
   * @return the artist of the song
   * @throws IllegalStateException if the artist is not set
   */
  public IArtist getArtist() throws IllegalStateException;

  /**
   * Returns the name of the artist of the song.
   *
   * @return the name of the artist of the song
   * @throws IllegalStateException if the artist is not set
   */
  public String getArtistName() throws IllegalStateException;

  /**
   * Return the song's rating value.
   *
   * @return the song's rating value
   * @throws IllegalStateException if the rating is not set
   */
  public double getRating() throws IllegalStateException;

  /**
   * Return the song's IRL index.
   *
   * @return the song's IRL index
   * @throws IllegalStateException if the IRL index is not set
   */
  public double getIRLIndex() throws IllegalStateException;

  /**
   * Sets the ID of the song.
   *
   * @param id the ID of the song
   * @throws IllegalArgumentException if the ID is not positive
   */
  public void setID(int id) throws IllegalArgumentException;

  /**
   * Sets the name of the song.
   *
   * @param name the name of the song
   * @throws IllegalArgumentException if the name is null or empty
   */
  public void setSongName(String name) throws IllegalArgumentException;

  /**
   * Sets the artist of the song.
   *
   * @param artist the artist of the song
   * @throws IllegalArgumentException if the artist is null
   */
  public void setArtist(IArtist artist) throws IllegalArgumentException;

  /**
   * Sets the rating of the song.
   *
   * @param rating the rating of the song
   * @throws IllegalArgumentException if the rating is not between 0 and 10
   */
  public void setRating(double rating) throws IllegalArgumentException;

  /**
   * Sets the IRL index of the song.
   *
   * @param irlIndex the IRL index of the song
   * @throws IllegalArgumentException if the IRL index is not between 0 and 5
   */
  public void setIRLIndex(double irlIndex) throws IllegalArgumentException;

  /**
   * Calculates the overall rating of the song.
   * @return the overall rating of the song
   * @throws IllegalStateException if the rating or IRL index is not set
   */
  public double calculateOverallRating() throws IllegalStateException;
}
