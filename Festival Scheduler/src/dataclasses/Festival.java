package dataclasses;

import java.util.List;

/**
 * Represents the general festival data class.
 */
public class Festival implements IFestival {
  private String name;
  private List<Day> dayList;
  private List<Artist> artistList;
}
