package dataclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the general artist data class.
 */
public class Artist implements IArtist {
  private String name;
  private int id;
  private int startTime;
  private int endTime;
  private int day;
  private String stage;
  private List<Song> songList;
  private double irlIndex;
  private boolean override;

  public Artist(String name, int id, int startTime, int endTime, int day, String stage,
                List<Song> songList, double irlIndex) throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Artist name cannot be null or empty.");
    }
    if (id < 0) {
      throw new IllegalArgumentException("Artist ID cannot be negative.");
    }
    if (startTime < 0) {
      throw new IllegalArgumentException("Artist start time cannot be negative.");
    }
    if (endTime < 0) {
      throw new IllegalArgumentException("Artist end time cannot be negative.");
    }
    if (day < 0) {
      throw new IllegalArgumentException("Artist day cannot be negative.");
    }
    if (stage == null || stage.equals("")) {
      throw new IllegalArgumentException("Artist stage cannot be null or empty.");
    }
    if (songList == null || songList.size() == 0) {
      this.songList = new ArrayList<>();
    } else {
      this.songList = songList;
    }
    if (irlIndex < 0 || irlIndex > 5) {
      throw new IllegalArgumentException("Artist IRL index must be between 0 and 5.");
    }

    this.name = name;
    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
    this.day = day;
    this.stage = stage;
    this.irlIndex = irlIndex;
    this.override = false;
  }

  @Override
  public int getID() throws IllegalStateException {
    if (this.id == 0) {
      throw new IllegalStateException("Artist ID is not set.");
    }
    return this.id;
  }

  @Override
  public String getName() throws IllegalStateException {
    if (this.name == null || this.name.equals("")) {
      throw new IllegalStateException("Artist name is not set.");
    }
    return this.name;
  }

  @Override
  public int getStartTime() throws IllegalStateException {
    if (this.startTime == 0) {
      throw new IllegalStateException("Artist start time is not set.");
    }
    return this.startTime;
  }

  @Override
  public int getEndTime() throws IllegalStateException {
    if (this.endTime == 0) {
      throw new IllegalStateException("Artist end time is not set.");
    }
    return this.endTime;
  }

  @Override
  public int getDay() throws IllegalStateException {
    if (this.day == 0) {
      throw new IllegalStateException("Artist day is not set.");
    }
    return this.day;
  }

  @Override
  public String getStage() throws IllegalStateException {
    if (this.stage == null || this.stage.equals("")) {
      throw new IllegalStateException("Artist stage is not set.");
    }
    return this.stage;
  }

  @Override
  public List<Song> getSongList() throws IllegalStateException {
    if (this.songList == null) {
      throw new IllegalStateException("Artist song list is not set.");
    }
    return this.songList;
  }

  @Override
  public Song getSongByID(int id) throws IllegalArgumentException {
    if (this.songList == null) {
      throw new IllegalArgumentException("Artist song list is not set.");
    }
    for (Song song : this.songList) {
      if (song.getID() == id) {
        return song;
      }
    }
    throw new IllegalArgumentException("Song with ID " + id + " does not exist.");
  }

  @Override
  public Song getSongByName(String name) throws IllegalArgumentException {
    if (this.songList == null) {
      throw new IllegalArgumentException("Artist song list is not set.");
    }
    for (Song song : this.songList) {
      if (song.getName().equals(name)) {
        return song;
      }
    }
    throw new IllegalArgumentException("Song with name " + name + " does not exist.");
  }

  @Override
  public double getIRLIndex() throws IllegalStateException {
    if (this.irlIndex == 0) {
      throw new IllegalStateException("Artist IRL index is not set.");
    }
    return this.irlIndex;
  }

  @Override
  public boolean getOverride() throws IllegalStateException {
    return this.override;
  }

  @Override
  public void setID(int id) throws IllegalArgumentException {
    if (id < 0) {
      throw new IllegalArgumentException("Artist ID cannot be negative.");
    }
    this.id = id;
  }

  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Artist name cannot be null or empty.");
    }
    this.name = name;
  }

  @Override
  public void setStartTime(int startTime) throws IllegalArgumentException {
    if (startTime < 0) {
      throw new IllegalArgumentException("Artist start time cannot be negative.");
    }
    this.startTime = startTime;
  }

  @Override
  public void setEndTime(int endTime) throws IllegalArgumentException {
    if (endTime < 0) {
      throw new IllegalArgumentException("Artist end time cannot be negative.");
    }
    this.endTime = endTime;
  }

  @Override
  public void setDay(int day) throws IllegalArgumentException {
    if (day < 0) {
      throw new IllegalArgumentException("Artist day cannot be negative.");
    }
    this.day = day;
  }

  @Override
  public void setStage(String stage) throws IllegalArgumentException {
    if (stage == null || stage.equals("")) {
      throw new IllegalArgumentException("Artist stage cannot be null or empty.");
    }
    this.stage = stage;
  }

  @Override
  public void setSongList(List<Song> songList) throws IllegalArgumentException {
    if (songList == null) {
      throw new IllegalArgumentException("Artist song list cannot be null.");
    }
    this.songList = songList;
  }

  @Override
  public void addSong(Song song) throws IllegalArgumentException {
    if (song == null) {
      throw new IllegalArgumentException("Song cannot be null.");
    }
    this.songList.add(song);
  }

  @Override
  public void removeSong(int id) throws IllegalArgumentException {
    if (this.songList == null) {
      throw new IllegalArgumentException("Artist song list is not set.");
    }
    for (Song song : this.songList) {
      if (song.getID() == id) {
        this.songList.remove(song);
        return;
      }
    }
    throw new IllegalArgumentException("Song with ID " + id + " does not exist.");
  }

  @Override
  public void setSong(String name, Song song) throws IllegalArgumentException {
    if (this.songList == null) {
      throw new IllegalArgumentException("Artist song list is not set.");
    }
    for (Song song1 : this.songList) {
      if (Objects.equals(song1.getName(), name)) {
        int index = this.songList.indexOf(song1);
        this.songList.set(index, song);
        return;
      }
    }
    throw new IllegalArgumentException("Song with ID " + id + " does not exist.");
  }

  @Override
  public void setIRLIndex(double irlIndex) throws IllegalArgumentException {
    if (irlIndex < 0 || irlIndex > 5) {
      throw new IllegalArgumentException("Song IRL index must be between 0 and 5.");
    }
    this.irlIndex = irlIndex;
  }

  @Override
  public void setOverride(boolean override) {
    this.override = override;
  }

  @Override
  public boolean isDuring(int time) throws IllegalArgumentException, IllegalStateException {
    if (time < 0) {
      throw new IllegalArgumentException("Time cannot be negative.");
    }
    if (this.startTime == 0) {
      throw new IllegalStateException("Artist start time is not set.");
    }
    if (this.endTime == 0) {
      throw new IllegalStateException("Artist end time is not set.");
    }
    return time >= this.startTime && time <= this.endTime;
  }

  @Override
  public double calculateOverallRating() throws IllegalStateException {
    if (this.songList == null) {
      throw new IllegalStateException("Artist song list is not set.");
    }
    if (this.irlIndex > 5 || this.irlIndex < 0) {
      throw new IllegalStateException("Artist IRL index invalid.");
    }

    double ratingSum = 0.0;
    for (Song song : this.songList) {
      ratingSum += song.calculateOverallRating();
    }

    double songAvg = Math.round((ratingSum / this.songList.size()) * 100.0) / 100.0;
    return Math.round(((songAvg + this.irlIndex) / 2) * 100.0) / 100.0;
  }

  @Override
  public String toString() throws IllegalStateException {
    String output = "";
    output += "(" + this.getID() + ") " + this.getName() + "\n";

    for (Song song : this.getSongList()) {
      output += song.getName() + ", ";
    }
    output = output.substring(0, output.length() - 2);
    output += "\n";

    output += "Day " + this.getDay()
            + " from " + this.getStartTime() + " to " + this.getEndTime()
            + "\n at " + this.getStage()
            + "\n";
    output += "Overall Rating: " + this.calculateOverallRating();

    return output;
  }
}
