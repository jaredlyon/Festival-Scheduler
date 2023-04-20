import java.io.InputStreamReader;

import controller.IController;
import controller.ScriptController;
import model.IModel;
import model.Model;
import view.ScriptView;

/**
 * Represents the main method for the Festival Scheduler program.
 */
public final class Main {
  /**
   * Runs the Festical Scheduler program.
   * @param args - a String[] determining which version to play
   */
  public static void main(String[] args) {
    // currently can only run script commands in the CLI
    // starts the script version
    IModel model = new Model();
    ScriptView view = new ScriptView(model);
    Readable in = new InputStreamReader(System.in);
    IController controller = new ScriptController(model, view, in);
    model.setController(controller);
    controller.start();
  }
}