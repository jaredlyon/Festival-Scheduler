package dataclasstests;

import org.junit.Before;
import org.junit.Test;

import dataclasses.Day;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Day class.
 */
public class DayTest {
  Day day1 = new Day(1, 900, 2330);
  Day day2 = new Day(2, 1100, 2400);

  @Before
  public void setUp() {
    this.day1 = new Day(1, 900, 2330);
    this.day2 = new Day(2, 1100, 2400);
  }

  @Test
  public void testGetID() {
    assertEquals(1, this.day1.getID());
    assertEquals(2, this.day2.getID());
  }

  @Test
  public void testGetStartTime() {
    assertEquals(900, this.day1.getStartTime());
    assertEquals(1100, this.day2.getStartTime());
  }

  @Test
  public void testGetEndTime() {
    assertEquals(2330, this.day1.getEndTime());
    assertEquals(2400, this.day2.getEndTime());
  }

  @Test
  public void testSetID() {
    this.day1.setID(3);
    this.day2.setID(4);
    assertEquals(3, this.day1.getID());
    assertEquals(4, this.day2.getID());
  }

  @Test
  public void testSetStartTime() {
    this.day1.setStartTime(1000);
    this.day2.setStartTime(1200);
    assertEquals(1000, this.day1.getStartTime());
    assertEquals(1200, this.day2.getStartTime());
  }

  @Test
  public void testSetEndTime() {
    this.day1.setEndTime(2400);
    this.day2.setEndTime(2359);
    assertEquals(2400, this.day1.getEndTime());
    assertEquals(2359, this.day2.getEndTime());
  }

  @Test
  public void testToString() {
    assertEquals("Day 1: 900 - 2330", this.day1.toString());
    assertEquals("Day 2: 1100 - 2400", this.day2.toString());
  }
}
