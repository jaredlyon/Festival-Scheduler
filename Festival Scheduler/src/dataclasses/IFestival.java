package dataclasses;

import java.util.List;

/**
 * Represents the general festival data class.
 */
public interface IFestival {

  /**
   * Returns the name of the festival.
   * @return the name of the festival
   * @throws IllegalStateException if the name is not set
   */
  public String getName() throws IllegalStateException;

  /**
   * Returns the list of days of the festival.
   * @return the list of days of the festival
   * @throws IllegalStateException if the day list is not set
   */
  public List<IDay> getDayList() throws IllegalStateException;

  /**
   * Returns the list of artists of the festival.
   * @return the list of artists of the festival
   * @throws IllegalStateException if the artist list is not set
   */
  public List<IArtist> getArtistList() throws IllegalStateException;

  /**
   * Returns the artist of the festival by the given name.
   * @param name the artist name
   * @return the artist of the festival by the given name
   * @throws IllegalStateException if the artist list is not set
   */
  public IArtist getArtistByName(String name) throws IllegalArgumentException;
  // TODO: add test for this method

  /**
   * Returns the list of songs of the festival.
   * @return the list of songs of the festival
   * @throws IllegalStateException if the song list is not set
   */
  public List<ISong> getSongList() throws IllegalStateException;

  /**
   * Returns the list of songs of the festival by the given artist.
   * @param artist the artist
   * @return the list of songs of the festival by the given artist
   * @throws IllegalStateException if the song list is not set
   */
  public List<ISong> getSongListByArtist(IArtist artist) throws IllegalStateException;

  /**
   * Returns the list of songs of the festival by the given artist name.
   * @param artistName the artist name
   * @return the list of songs of the festival by the given artist name
   * @throws IllegalStateException if the song list is not set
   */
  public List<ISong> getSongListByArtistName(String artistName) throws IllegalStateException;

  /**
   * Returns the list of songs of the festival by the given artist ID.
   * @param artistID the artist ID
   * @return the list of songs of the festival by the given artist ID
   * @throws IllegalStateException if the song list is not set
   */
  public List<ISong> getSongListByArtistID(int artistID) throws IllegalStateException;

  /**
   * Set's the festival name.
   * @param name the festival name
   * @throws IllegalArgumentException if the name is null or empty
   */
  public void setName(String name) throws IllegalArgumentException;

  /**
   * Set's the festival day list.
   * @param dayList the festival day list
   * @throws IllegalArgumentException if the day list is null or empty
   */
  public void setDayList(List<IDay> dayList) throws IllegalArgumentException;

  /**
   * Set's the festival artist list.
   * @param artistList the festival artist list
   * @throws IllegalArgumentException if the artist list is null or empty
   */
  public void setArtistList(List<IArtist> artistList) throws IllegalArgumentException;

  /**
   * Adds a day to the festival.
   * @param day the day to add
   * @throws IllegalArgumentException if the day is null
   */
  public void addDay(IDay day) throws IllegalArgumentException;

  /**
   * Adds an artist to the festival.
   * @param artist the artist to add
   * @throws IllegalArgumentException if the artist is null
   */
  public void addArtist(IArtist artist) throws IllegalArgumentException;

  /**
   * Removes a day from the festival.
   * @param id the day to remove
   * @throws IllegalArgumentException if the day is null
   */
  public void removeDay(int id) throws IllegalArgumentException;

  /**
   * Removes an artist from the festival.
   * @param name the artist to remove
   * @throws IllegalArgumentException if the artist is null
   */
  public void removeArtist(String name) throws IllegalArgumentException;

  /**
   * Generates the optimal schedule for the festival.
   * From the point of an attendee.
   * @return the optimal schedule for the festival
   * @throws IllegalStateException if data is missing
   */
  public String generateSchedule() throws IllegalStateException;
}
