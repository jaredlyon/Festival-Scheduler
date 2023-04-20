package controller;

public interface IController {

  /**
   * Starts the Festival Scheduler program!
   */
  public void start() throws IllegalStateException;

  /**
   * Renders a message to the user from the model.
   */
  public void renderModelMessage(String message) throws IllegalStateException;
}
