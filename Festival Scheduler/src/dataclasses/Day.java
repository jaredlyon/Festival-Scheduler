package dataclasses;

/**
 * Represents the general day data class.
 */
public class Day implements IDay {
  private int id; // corresponds to day 1, day 2, day 3, etc...
  private int startTime;
  private int endTime;

  public Day(int id, int startTime, int endTime) {
    if (id < 1) {
      throw new IllegalArgumentException("Day ID cannot be less than one.");
    }
    if (startTime < 0) {
      throw new IllegalArgumentException("Day start time cannot be negative.");
    }
    if (endTime < 0) {
      throw new IllegalArgumentException("Day end time cannot be negative.");
    }

    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public int getID() throws IllegalStateException {
    if (this.id == 0) {
      throw new IllegalStateException("Day ID is not set.");
    }
    return this.id;
  }

  @Override
  public int getStartTime() throws IllegalStateException {
    if (this.startTime == 0) {
      throw new IllegalStateException("Day start time is not set.");
    }
    return this.startTime;
  }

  @Override
  public int getEndTime() throws IllegalStateException {
    if (this.endTime == 0) {
      throw new IllegalStateException("Day end time is not set.");
    }
    return this.endTime;
  }

  @Override
  public void setID(int id) throws IllegalArgumentException {
    if (id < 1) {
      throw new IllegalArgumentException("Day ID cannot be less than one.");
    }
    this.id = id;
  }

  @Override
  public void setStartTime(int startTime) throws IllegalArgumentException {
    if (startTime < 0) {
      throw new IllegalArgumentException("Day start time cannot be negative.");
    }
    this.startTime = startTime;
  }

  @Override
  public void setEndTime(int endTime) throws IllegalArgumentException {
    if (endTime < 0) {
      throw new IllegalArgumentException("Day end time cannot be negative.");
    }
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    if (this.id == 0 || this.startTime == 0 || this.endTime == 0) {
      throw new IllegalStateException("Day attributes are not set.");
    }
    return "Day " + this.id + ": " + this.startTime + " - " + this.endTime;
  }
}
