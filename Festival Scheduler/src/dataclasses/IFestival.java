package dataclasses;

import java.util.List;

/**
 * Represents the general festival data class.
 */
public interface IFestival {

  public String getName() throws IllegalStateException;

  public List<IDay> getDayList() throws IllegalStateException;

  public List<IArtist> getArtistList() throws IllegalStateException;

  public List<ISong> getSongList() throws IllegalStateException;

  public List<ISong> getSongListByArtist(IArtist artist) throws IllegalStateException;

  public List<ISong> getSongListByArtistName(String artistName) throws IllegalStateException;

  public void setName(String name) throws IllegalArgumentException;

  public void setDayList(List<IDay> dayList) throws IllegalArgumentException;

  public void setArtistList(List<IArtist> artistList) throws IllegalArgumentException;

  public void setSongList(List<ISong> songList) throws IllegalArgumentException;

  public void addDay(IDay day) throws IllegalArgumentException;

  public void addArtist(IArtist artist) throws IllegalArgumentException;



  public String generateSchedule() throws IllegalStateException;
}
