package dataclasses;

import java.util.List;

/**
 * Represents the general artist data class.
 */
public interface IArtist {

  /**
   * Returns the ID of the artist.
   * @return the ID of the artist
   * @throws IllegalStateException if the ID is not set
   */
  public int getID() throws IllegalStateException;

  /**
   * Returns the name of the artist.
   * @return the name of the artist
   * @throws IllegalStateException if the name is not set
   */
  public String getName() throws IllegalStateException;

  /**
   * Returns the start time of the artist's set.
   * @return the start time of the artist's set
   * @throws IllegalStateException if the start time is not set
   */
  public int getStartTime() throws IllegalStateException;

  /**
   * Returns the end time of the artist's set.
   * @return the end time of the artist's set
   * @throws IllegalStateException if the end time is not set
   */
  public int getEndTime() throws IllegalStateException;

  /**
   * Returns the day of the artist's set.
   * @return the day of the artist's set
   * @throws IllegalStateException if the day is not set
   */
  public int getDay() throws IllegalStateException;

  /**
   * Returns the stage of the artist's set.
   * @return the stage of the artist's set
   * @throws IllegalStateException if the stage is not set
   */
  public String getStage() throws IllegalStateException;

  /**
   * Returns the list of songs of the artist.
   * @return the list of songs of the artist
   * @throws IllegalStateException if the song list is not set
   */
  public List<ISong> getSongList() throws IllegalStateException;

  /**
   * Returns the song of the artist with the given ID.
   * @param id the ID of the song
   * @return the song of the artist with the given ID
   * @throws IllegalArgumentException if the song with the given ID does not exist
   */
  public ISong getSongByID(int id) throws IllegalArgumentException;

  /**
   * Returns the song of the artist with the given name.
   * @param name the name of the song
   * @return the song of the artist with the given name
   * @throws IllegalArgumentException if the song with the given name does not exist
   */
  public ISong getSongByName(String name) throws IllegalArgumentException;

  /**
   * Returns the IRL index of the artist.
   * @return the IRL index of the artist
   * @throws IllegalStateException if the IRL index is not set
   */
  public double getIRLIndex() throws IllegalStateException;

  /**
   * Returns the override of the artist.
   * @return the override of the artist
   * @throws IllegalStateException if the override is not set
   */
  public boolean getOverride() throws IllegalStateException;

  /**
   * Sets the ID of the artist.
   * @param id the ID of the artist
   * @throws IllegalArgumentException if the ID is not positive
   */
  public void setID(int id) throws IllegalArgumentException;

  /**
   * Sets the name of the artist.
   * @param name the name of the artist
   * @throws IllegalArgumentException if the name is null
   */
  public void setName(String name) throws IllegalArgumentException;

  /**
   * Sets the start time of the artist's set.
   * @param startTime the start time of the artist's set
   * @throws IllegalArgumentException if the start time is not positive
   */
  public void setStartTime(int startTime) throws IllegalArgumentException;

  /**
   * Sets the end time of the artist's set.
   * @param endTime the end time of the artist's set
   * @throws IllegalArgumentException if the end time is not positive
   */
  public void setEndTime(int endTime) throws IllegalArgumentException;

  /**
   * Sets the day of the artist's set.
   * @param day the day of the artist's set
   * @throws IllegalArgumentException if the day is not positive
   */
  public void setDay(int day) throws IllegalArgumentException;

  /**
   * Sets the stage of the artist's set.
   * @param stage the stage of the artist's set
   * @throws IllegalArgumentException if the stage is null
   */
  public void setStage(String stage) throws IllegalArgumentException;

  /**
   * Sets the list of songs of the artist.
   * @param songList the list of songs of the artist
   * @throws IllegalArgumentException if the song list is null
   */
  public void setSongList(List<ISong> songList) throws IllegalArgumentException;

  /**
   * Adds a song to the artist's list of songs.
   * @param song the song to be added
   * @throws IllegalArgumentException if the song is null
   */
  public void addSong(ISong song) throws IllegalArgumentException;

  /**
   * Removes a song from the artist's list of songs.
   * @param id the ID of the song to be removed
   * @throws IllegalArgumentException if the song with the given ID does not exist
   */
  public void removeSong(int id) throws IllegalArgumentException;

  /**
   * Sets the song of the artist with the given ID.
   * @param name the name of the song
   * @param song the song to be set
   * @throws IllegalArgumentException if the song with the given ID does not exist
   */
  public void setSong(String name, ISong song) throws IllegalArgumentException;

  /**
   * Sets the rating of the artist.
   * @param irlIndex the rating of the artist
   * @throws IllegalArgumentException if the IRL index is not between 0 and 5
   */
  public void setIRLIndex(double irlIndex) throws IllegalArgumentException;

  /**
   * Sets the override of the artist.
   * @param override the override of the artist
   * @throws IllegalArgumentException if the override is null
   */
  public void setOverride(boolean override);

  /**
   * Returns whether the artist is playing during the given time.
   * @param time the time to check
   * @return whether the artist is playing during the given time
   * @throws IllegalArgumentException if the time is not positive
   * @throws IllegalStateException if the start time or end time is not set
   */
  public boolean isDuring(int time)
          throws IllegalArgumentException, IllegalStateException;

  /**
   * Calculates the overall rating of the artist.
   * @throws IllegalStateException if any required fields are null
   */
  public double calculateOverallRating() throws IllegalStateException;

  /**
   * Returns the string representation of the artist.
   * @return the string representation of the artist
   * @throws IllegalStateException if any required fields are null
   */
  public String toString() throws IllegalStateException;
}
