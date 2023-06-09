package model;

import java.util.Objects;

import dataclasses.Artist;
import dataclasses.Day;
import dataclasses.Festival;
import dataclasses.IArtist;
import dataclasses.IDay;
import dataclasses.IFestival;
import dataclasses.ISong;
import dataclasses.Song;
import controller.IController;

import java.io.*;
import java.util.*;

/**
 * Represents the general model for the application.
 */
public class Model implements IModel {
  private IFestival festival;
  private IController controller;
  private String schedule;

  public Model(IController controller, IFestival festival) {
    Objects.requireNonNull(festival);
    Objects.requireNonNull(controller);
    this.festival = festival;
    this.controller = controller;
    this.schedule = "Schedule has not been generated.";
  }

  public Model() {
    this.festival = null;
    this.controller = null;
    this.schedule = "Schedule has not been generated.";
  }

  @Override
  public void setController(IController controller) throws IllegalArgumentException {
    Objects.requireNonNull(controller);
    this.controller = controller;
  }

  @Override
  public IFestival getFestivalData() throws IllegalStateException {
    if (this.festival == null) {
      throw new IllegalStateException("Festival data is not set.");
    }
    return this.festival;
  }

  @Override
  public void setFestivalData(IFestival data) throws IllegalArgumentException {
    Objects.requireNonNull(data);
    this.festival = data;
  }

  @Override
  public void importDataJSON(String filename) throws IllegalArgumentException {
    // TODO: Implement this method
  }

  @Override
  public void exportDataJSON(String filename) throws IllegalArgumentException {
    // TODO: Implement this method
  }

  @Override
  public void importDataTxt(String filename) throws IllegalArgumentException {
    if (filename == null || filename.isEmpty()) {
      throw new IllegalArgumentException("Filename is null or empty.");
    }

    int lines = 0;
    ArrayList<String> data = new ArrayList<>();
    try {
      // get file
      File file = new File(filename);
      Scanner sc = new Scanner(file);
      this.renderMessage("Found file! Parsing...");

      // get file data
      while (sc.hasNextLine()) {
        lines++;
        data.add(sc.nextLine());
      }
      this.renderMessage("Found " + lines + " lines of data...");

      // reject bad file types
      if (!data.get(0).equals("JL-FS-1.0")) {
        throw new IllegalArgumentException("File is not a valid JL-FS-1.0 file.");
      }

      // parse data
      try {
        this.parseDataFromImport(data, lines, 0);
      } catch (IOException e) {
        this.renderMessage("Error parsing data.");
      }

      this.renderMessage("File imported successfully!");
    } catch (FileNotFoundException e) {
      this.renderMessage("File not found.");
    }
  }

  private void parseDataFromImport(ArrayList<String> data, int lines, int currentLine) throws IOException {
    /**
     * FILE SCHEMA
     * -------------
     * JL-FS-1.0
     * festival festival-name
     * day id start-time end-time
     * day id start-time end-time
     * ...
     * artist id start-time end-time stage-name day-num IRL-index override-value
     * artist-name name
     * artist id start-time end-time stage-name day-num IRL-index override-value
     * artist-name name
     * ...
     * song id rating IRL-index
     * song-name name
     * artist-name name
     * song id rating IRL-index
     * song-name name
     * artist-name name
     * ...
     */

    String command = data.get(currentLine);
    String[] commandArgs = command.split(" ");
    String commandType = commandArgs[0];

    if (commandType.equals("JL-FS-1.0")) {
      // move on
      try {
        this.parseDataFromImport(data, lines, currentLine + 1);
      } catch (IndexOutOfBoundsException e) {
        this.renderMessage("No data to import.");
      }
    } else if (commandType.equals("festival")) {
      StringBuilder name = new StringBuilder();
      for (int i = 1; i < commandArgs.length; i++) {
        name.append(commandArgs[i]);
        if (i != commandArgs.length - 1) {
          name.append(" ");
        }
      }
      this.festival = new Festival(name.toString());
      this.renderMessage("Festival name set to " + name.toString());

      try {
        this.parseDataFromImport(data, lines, currentLine + 1);
      } catch (IndexOutOfBoundsException e) {
        this.renderMessage("Import complete.");
      }
    } else if (commandType.equals("artist")) {
      int id = Integer.parseInt(commandArgs[1]);
      int startTime = Integer.parseInt(commandArgs[2]);
      int endTime = Integer.parseInt(commandArgs[3]);
      String stageName = commandArgs[4];
      int dayNum = Integer.parseInt(commandArgs[5]);
      double IRLIndex = Double.parseDouble(commandArgs[6]);
      String overrideValue = commandArgs[7];

      String artistNameCommand = data.get(currentLine + 1);
      String[] artistNameCommandArgs = artistNameCommand.split(" ");
      StringBuilder artistName = new StringBuilder();
      for (int i = 1; i < artistNameCommandArgs.length; i++) {
        artistName.append(artistNameCommandArgs[i]);
        if (i != commandArgs.length - 1) {
          artistName.append(" ");
        }
      }

      IArtist artist = new Artist(id, artistName.toString(),
              startTime, endTime, stageName, dayNum, IRLIndex, overrideValue);

      this.festival.addArtist(artist);
      this.renderMessage("Added artist " + artistName.toString());

      double progress = ((double) currentLine / (double) lines) * 100;
      this.renderMessage("Progress: " + progress + "%");

      try {
        this.parseDataFromImport(data, lines, currentLine + 2);
      } catch (IndexOutOfBoundsException e) {
        this.renderMessage("Import complete.");
      }
    } else if (commandType.equals("song")) {
      int id = Integer.parseInt(commandArgs[1]);
      double rating = Double.parseDouble(commandArgs[2]);
      double IRLIndex = Double.parseDouble(commandArgs[3]);

      String songNameCommand = data.get(currentLine + 1);
      String[] songNameCommandArgs = songNameCommand.split(" ");
      StringBuilder songName = new StringBuilder();
      for (int i = 1; i < songNameCommandArgs.length; i++) {
        songName.append(songNameCommandArgs[i]);
        if (i != commandArgs.length - 1) {
          songName.append(" ");
        }
      }

      String artistNameCommand = data.get(currentLine + 2);
      String[] artistNameCommandArgs = artistNameCommand.split(" ");
      StringBuilder artistName = new StringBuilder();
      for (int i = 1; i < artistNameCommandArgs.length; i++) {
        artistName.append(artistNameCommandArgs[i]);
        if (i != commandArgs.length - 1) {
          artistName.append(" ");
        }
      }

      IArtist songArtist = this.festival.getArtistByName(artistName.toString());
      ISong song = new Song(id, songName.toString(), songArtist, rating, IRLIndex);
      songArtist.addSong(song);

      this.renderMessage("Added song " + songName.toString());
      double progress = ((double) currentLine / (double) lines) * 100;
      this.renderMessage("Progress: " + progress + "%");

      try {
        this.parseDataFromImport(data, lines, currentLine + 3);
      } catch (IndexOutOfBoundsException e) {
        this.renderMessage("Import complete.");
      }
    } else if (commandType.equals("day")) {
      int id = Integer.parseInt(commandArgs[1]);
      int startTime = Integer.parseInt(commandArgs[2]);
      int endTime = Integer.parseInt(commandArgs[3]);

      IDay day = new Day(id, startTime, endTime);

      this.festival.addDay(day);
      this.renderMessage("Added day " + id);

      double progress = ((double) currentLine / (double) lines) * 100;
      this.renderMessage("Progress: " + Math.round(progress) + "%");

      try {
        this.parseDataFromImport(data, lines, currentLine + 1);
      } catch (IndexOutOfBoundsException e) {
        this.renderMessage("Import complete.");
      }
    }
  }

  @Override
  public void exportDataTxt(String filename) throws IllegalArgumentException, IOException {
    if (filename == null) {
      throw new IllegalArgumentException("Filename cannot be null.");
    }

    if (filename.equals("")) {
      throw new IllegalArgumentException("Filename cannot be empty.");
    }

    if (!filename.endsWith(".txt")) {
      throw new IllegalArgumentException("Filename must end with .txt");
    }

    try {
      File file = new File(filename);
      FileWriter fileWriter = new FileWriter(file);
      StringBuilder data = this.parseDataForExport();
      fileWriter.write(data.toString());
      fileWriter.close();
    } catch (IOException e) {
      throw new IOException("Error writing to file.");
    }
  }

  private StringBuilder parseDataForExport() {
    /**
     * FILE SCHEMA
     * -------------
     * JL-FS-1.0
     * festival festival-name
     * day id start-time end-time
     * day id start-time end-time
     * ...
     * artist id start-time end-time stage-name day-num IRL-index override-value
     * artist-name name
     * artist id start-time end-time stage-name day-num IRL-index override-value
     * artist-name name
     * ...
     * song id rating IRL-index
     * song-name name
     * artist-name name
     * song id rating IRL-index
     * song-name name
     * artist-name name
     * ...
     */


    StringBuilder data = new StringBuilder();
    data.append("JL-FS-1.0\n");
    data.append("festival " + this.festival.getName() + "\n");

    // get data
    List<IDay> dayList = this.festival.getDayList();
    List<IArtist> artistList = this.festival.getArtistList();
    List<ISong> songList = this.festival.getSongList();

    // add days
    for (IDay day : dayList) {
      data.append("day " + day.getID() + " " + day.getStartTime() + " " + day.getEndTime() + "\n");
    }

    // add artists
    for (IArtist artist : artistList) {
      data.append("artist " + artist.getID() + " " + artist.getStartTime() + " " + artist.getEndTime() + " " +
              artist.getStage() + " " + artist.getDay() + " " + artist.getIRLIndex() +
              " " + artist.getOverride() + "\n");
      data.append("artist-name " + artist.getName() + "\n");
    }

    // add songs
    for (ISong song : songList) {
      data.append("song " + song.getID() + " " + song.getRating() + " " + song.getIRLIndex() + "\n");
      data.append("song-name " + song.getName() + "\n");
      data.append("artist-name " + song.getArtist().getName() + "\n");
    }

    return data;
  }

  @Override
  public void generateSchedule() throws IllegalStateException {
    if (this.festival == null) {
      throw new IllegalStateException("Festival data is not set.");
    }

    this.schedule = this.festival.generateSchedule();
  }

  @Override
  public void renderMessage(String message) throws IllegalStateException {
    if (this.controller == null) {
      throw new IllegalStateException("Controller is not set.");
    }
    this.controller.renderModelMessage(message);
  }
}
