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

  /**
   * Sets the ID of the day.
   * @param id the ID of the day
   * @throws IllegalArgumentException if the ID is not positive
   */
  public void setID(int id) throws IllegalArgumentException;

  /**
   * Sets the start time of the day.
   * @param startTime the start time of the day
   * @throws IllegalArgumentException if the start time is not positive
   */
  public void setStartTime(int startTime) throws IllegalArgumentException;

  /**
   * Sets the end time of the day.
   * @param endTime the end time of the day
   * @throws IllegalArgumentException if the end time is not positive
   */
  public void setEndTime(int endTime) throws IllegalArgumentException;

  /**
   * Returns a string representation of the day.
   * @return a string representation of the day
   * @throws IllegalStateException if the attributes are not set
   */
  public String toString() throws IllegalStateException;
}
