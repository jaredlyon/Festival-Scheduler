package dataclasses;

import java.util.ArrayList;
import java.util.List;

import model.ScheduleGenerator;

/**
 * Represents the general festival data class.
 */
public class Festival implements IFestival {
  private String name;
  private List<IDay> dayList;
  private List<IArtist> artistList;

  public Festival(String name, List<IDay> dayList, List<IArtist> artistList)
          throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Festival name cannot be null or empty.");
    }
    if (dayList == null) {
      throw new IllegalArgumentException("Festival day list cannot be null.");
    }
    if (artistList == null) {
      throw new IllegalArgumentException("Festival artist list cannot be null.");
    }

    this.name = name;
    this.dayList = dayList;
    this.artistList = artistList;
  }

  public Festival(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Festival name cannot be null or empty.");
    }

    this.name = name;
    this.dayList = new ArrayList<>();
    this.artistList = new ArrayList<>();
  }

  @Override
  public String getName() throws IllegalStateException {
    if (this.name == null || this.name.equals("")) {
      throw new IllegalStateException("Festival name is not set.");
    }
    return this.name;
  }

  @Override
  public List<IDay> getDayList() throws IllegalStateException {
    if (this.dayList == null) {
      throw new IllegalStateException("Festival day list is not set.");
    }
    return this.dayList;
  }

  @Override
  public List<IArtist> getArtistList() throws IllegalStateException {
    if (this.artistList == null) {
      throw new IllegalStateException("Festival artist list is not set.");
    }
    return this.artistList;
  }

  @Override
  public List<ISong> getSongList() throws IllegalStateException {
    if (this.artistList == null) {
      throw new IllegalStateException("Festival artist list is not set.");
    }

    List<ISong> songList = new ArrayList<>();
    for (IArtist artist : this.artistList) {
      if (artist.getSongList() == null) {
        throw new IllegalStateException("Artist song list is not set.");
      }

      songList.addAll(artist.getSongList());
    }

    return songList;
  }

  @Override
  public List<ISong> getSongListByArtist(IArtist artist) throws IllegalStateException {
    if (artist == null) {
      throw new IllegalArgumentException("Artist cannot be null.");
    }
    if (this.artistList == null) {
      throw new IllegalStateException("Festival artist list is not set.");
    }

    List<ISong> songList = new ArrayList<>();
    for (IArtist a : this.artistList) {
      if (a.equals(artist)) {
        if (a.getSongList() == null) {
          throw new IllegalStateException("Artist song list is not set.");
        }

        songList.addAll(a.getSongList());
      }
    }

    return songList;
  }

  @Override
  public List<ISong> getSongListByArtistName(String artistName) throws IllegalStateException {
    if (artistName == null || artistName.equals("")) {
      throw new IllegalArgumentException("Artist name cannot be null or empty.");
    }
    if (this.artistList == null) {
      throw new IllegalStateException("Festival artist list is not set.");
    }

    List<ISong> songList = new ArrayList<>();
    for (IArtist a : this.artistList) {
      if (a.getName().equals(artistName)) {
        if (a.getSongList() == null) {
          throw new IllegalStateException("Artist song list is not set.");
        }

        songList.addAll(a.getSongList());
      }
    }

    return songList;
  }

  @Override
  public List<ISong> getSongListByArtistID(int artistID) throws IllegalStateException {
    if (this.artistList == null) {
      throw new IllegalStateException("Festival artist list is not set.");
    }

    List<ISong> songList = new ArrayList<>();
    for (IArtist a : this.artistList) {
      if (a.getID() == artistID) {
        if (a.getSongList() == null) {
          throw new IllegalStateException("Artist song list is not set.");
        }

        songList.addAll(a.getSongList());
      }
    }

    return songList;
  }

  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Festival name cannot be null or empty.");
    }
    this.name = name;
  }

  @Override
  public void setDayList(List<IDay> dayList) throws IllegalArgumentException {
    if (dayList == null) {
      throw new IllegalArgumentException("Festival day list cannot be null.");
    }
    this.dayList = dayList;
  }

  @Override
  public void setArtistList(List<IArtist> artistList) throws IllegalArgumentException {
    if (artistList == null) {
      throw new IllegalArgumentException("Festival artist list cannot be null.");
    }
    this.artistList = artistList;
  }

  @Override
  public void addDay(IDay day) throws IllegalArgumentException {
    if (day == null) {
      throw new IllegalArgumentException("Day cannot be null.");
    }
    this.dayList.add(day);
  }

  @Override
  public void addArtist(IArtist artist) throws IllegalArgumentException {
    if (artist == null) {
      throw new IllegalArgumentException("Artist cannot be null.");
    }
    this.artistList.add(artist);
  }

  @Override
  public void removeDay(int id) throws IllegalArgumentException {
    for (IDay day : this.dayList) {
      if (day.getID() == id) {
        this.dayList.remove(day);
        return;
      }
    }

    throw new IllegalArgumentException("Day with ID " + id + " does not exist.");
  }

  @Override
  public void removeArtist(String name) throws IllegalArgumentException {
    for (IArtist artist : this.artistList) {
      if (artist.getName().equals(name)) {
        this.artistList.remove(artist);
        return;
      }
    }

    throw new IllegalArgumentException("Artist with name " + name + " does not exist.");
  }

  @Override
  public String generateSchedule() throws IllegalStateException {
    ScheduleGenerator generator = new ScheduleGenerator(this);
    return generator.generateSchedule();
  }
}