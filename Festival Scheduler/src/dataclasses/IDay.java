package dataclasses;

/**
 * Represents the general day data class.
 */
public interface IDay {

  /**
   * Returns the ID of the day.
   * @return the ID of the day
   * @throws IllegalStateException if the ID is not set
   */
  public int getID() throws IllegalStateException;

  /**
   * Returns the start time of the day.
   * @return the start time of the day
   * @throws IllegalStateException if the start time is not set
   */
  public int getStartTime() throws IllegalStateException;

  /**
   * Returns the end time of the day.
   * @return the end time of the day
   * @throws IllegalStateException if the end time is not set
   */
  public int getEndTime() throws IllegalStateException;
}
