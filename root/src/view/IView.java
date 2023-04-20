package view;

import java.io.IOException;

/**
 * Represents the general view for the application.
 */
public interface IView {

  /**
   * Renders a message to the user.
   * @param message the message to render (from model)
   */
  public void renderMessage(String message) throws IOException;
}
