package model;

import java.io.IOException;

import dataclasses.IFestival;
import controller.IController;

/**
 * Represents the general model for the application.
 * Contains the stubs for the data and logic of the application.
 */
public interface IModel {

  /**
   * Sets the controller.
   * @param controller the controller
   * @throws IllegalArgumentException if the controller is null
   */
  public void setController(IController controller) throws IllegalArgumentException;

  /**
   * Returns the festival data.
   * @return the festival data
   * @throws IllegalStateException if the festival data is not set
   */
  public IFestival getFestivalData() throws IllegalStateException;

  /**
   * Sets the festival data.
   * @param data the festival data
   * @throws IllegalArgumentException if the festival data is null
   */
  public void setFestivalData(IFestival data) throws IllegalArgumentException;

  /**
   * Imports data from a JSON file.
   * @param filename the name of the JSON file
   * @throws IllegalArgumentException if the filename is null or empty
   */
  public void importDataJSON(String filename) throws IllegalArgumentException;

  /**
   * Exports data to a JSON file.
   * @param filename the name of the JSON file
   * @throws IllegalArgumentException if the filename is null or empty
   */
  public void exportDataJSON(String filename) throws IllegalArgumentException;

  /**
   * Imports data from a TXT file.
   * @param filename the name of the TXT file
   * @throws IllegalArgumentException if the filename is null or empty
   */
  public void importDataTxt(String filename) throws IllegalArgumentException;

  /**
   * Exports data to a TXT file.
   * @param filename the name of the TXT file
   * @throws IllegalArgumentException if the filename is null or empty
   */
  public void exportDataTxt(String filename) throws IllegalArgumentException, IOException;

  /**
   * Generates a schedule for the festival.
   *
   * @throws IllegalStateException if the festival data is not set
   */
  public void generateSchedule() throws IllegalStateException;

  /**
   * Passes a message to the view for display.
   * @param message - the controller's message
   * @throws IOException if the view cannot communicate with the out
   */
  public void renderMessage(String message) throws IllegalStateException;
}
