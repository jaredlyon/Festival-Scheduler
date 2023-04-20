package controller;

import java.io.IOException;
import java.util.Scanner;

import model.IModel;
import view.ScriptView;

/**
 * Represents the controller for the Festival Scheduler program.
 */
public class ScriptController implements IController {
  private final IModel model;
  private final ScriptView view;
  private final Readable in;
  private boolean quit = false;

  /**
   * Constructs a new controller using MVC arguments.
   *
   * @param model - a model of a SetGame
   * @param view  - a view of a SetGame
   * @param in    - inputs in the form of a readable
   * @throws IllegalArgumentException if any arguments are null
   */
  public ScriptController(IModel model, ScriptView view, Readable in)
          throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Model, view, or input is null within controller "
              + "implementation!");
    }

    this.model = model;
    this.view = view;
    this.in = in;
  }

  /**
   * Starts the Festival Scheduler program!
   */
  public void start() throws IllegalArgumentException {
    Scanner sc = new Scanner(this.in);

    // startup
    this.renderMessage("""
                ____                 __     _                    __          \s
               / __/  ___    _____  / /_   (_) _   __  ____ _   / /          \s
              / /_   / _ \\  / ___/ / __/  / / | | / / / __ `/  / /           \s
             / __/  /  __/ (__  ) / /_   / /  | |/ / / /_/ /  / /            \s
            /_/     \\___/ /____/_ \\__/  /_/   |___/  \\__,_/  /_/             \s
               _____  _____   / /_   ___   ____/ /  __  __   / /  ___    _____
              / ___/ / ___/  / __ \\ / _ \\ / __  /  / / / /  / /  / _ \\  / ___/
             (__  ) / /__   / / / //  __// /_/ /  / /_/ /  / /  /  __/ / /   \s
            /____/  \\___/  /_/ /_/ \\___/ \\__,_/   \\__,_/  /_/   \\___/ /_/    \s
                                                                             \s
                    \nBy Jared Lyon\nv1.0\nTHIS IS A WORK IN PROGRESS""");

    // instruction
    this.renderMessage("""
            Welcome to the Festival Scheduler!
            This program uses JL-FS-1.0 .txt files to predict your festival schedule.
            github.com/jaredlyon/festival-scheduler
            Type "help" for a list of commands.
            """);

    while (!quit) {
      // get command
      String command = sc.nextLine();
      String[] commandArgs = command.split(" ");

      switch (commandArgs[0]) {
        case "help":
          this.renderMessage("""
                  Script options:
                  import <file path> - imports a festival from a file
                  build - builds your schedule
                  quit - quits the program""");
          break;
        case "quit":
          this.renderMessage("""
                                                   \s
                              _____   __  __  ____ _
                             / ___/  / / / / / __ `/
                            / /__   / /_/ / / /_/ /\s
                            \\___/   \\__, /  \\__,_/ \s
                                   /____/          \s
                  """);
          this.quit = true;
          break;
        case "import":
          if (commandArgs.length != 2) {
            this.renderMessage("Invalid command. Type \"help\" for a list of commands.");
          } else {
            this.model.importDataTxt(commandArgs[1]);
          }
          break;
      }
    }
  }

  /**
   * Sends a message to the view.
   *
   * @param message
   * @throws IllegalArgumentException
   */
  private void renderMessage(String message) throws IllegalArgumentException {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalArgumentException("Controller cannot communicate with view.");
    }
  }

  /**
   * Sends a message to the view from the controller.
   */
  @Override
  public void renderModelMessage(String message) throws IllegalArgumentException {
    this.renderMessage(message);
  }
}
