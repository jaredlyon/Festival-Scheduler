package model;

import java.util.Objects;

import dataclasses.IFestival;

public class ScheduleGenerator {
  IFestival festival;

  public ScheduleGenerator(IFestival festival) {
    Objects.requireNonNull(festival, "Festival cannot be null.");
    this.festival = festival;
  }

  public String generateSchedule() {
    StringBuilder output = new StringBuilder();

    // TODO: Implement this method.

    return output.toString();
  }
}
