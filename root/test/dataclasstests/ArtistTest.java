package dataclasstests;

import org.junit.Before;
import org.junit.Test;

import dataclasses.Artist;
import dataclasses.Song;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the Artist class.
 */
public class ArtistTest {
  private Artist ledZep;
  private Song stairway;
  private Song kashmir;
  private Song blackDog;
  private Artist rex;
  private Song sunflower;
  private Song lovingIsEasy;
  private Song bestFriend;

  @Before
  public void setUp() {
    this.ledZep = new Artist("Led Zeppelin",
            1, 1030, 1130, 1,
            "Rock Stage", null, 4.0);
    this.stairway = new Song("Stairway to Heaven", 1, this.ledZep, 5.0, 5.0);
    this.kashmir = new Song("Kashmir", 2, this.ledZep, 4.0, 3.0);
    this.blackDog = new Song("Black Dog", 3, this.ledZep, 3.0, 4.0);
    this.ledZep.addSong(this.stairway);
    this.ledZep.addSong(this.kashmir);
    this.ledZep.addSong(this.blackDog);

    this.rex = new Artist("Rex Orange County",
            2, 1100, 1230, 1,
            "Indie Stage", null, 5.0);
    this.sunflower = new Song("Sunflower", 4, this.rex, 5.0, 5.0);
    this.lovingIsEasy = new Song("Loving Is Easy", 5, this.rex, 4.5, 4.0);
    this.bestFriend = new Song("Best Friend", 6, this.rex, 3.5, 3.0);
    this.rex.addSong(this.sunflower);
    this.rex.addSong(this.lovingIsEasy);
    this.rex.addSong(this.bestFriend);
  }

  @Test
  public void testGetID() {
    assertEquals(1, ledZep.getID());
    assertEquals(2, rex.getID());
  }

  @Test
  public void testGetName() {
    assertEquals("Led Zeppelin", ledZep.getName());
    assertEquals("Rex Orange County", rex.getName());
  }

  @Test
  public void testGetStartTime() {
    assertEquals(1030, ledZep.getStartTime());
    assertEquals(1100, rex.getStartTime());
  }

  @Test
  public void testGetEndTime() {
    assertEquals(1130, ledZep.getEndTime());
    assertEquals(1230, rex.getEndTime());
  }

  @Test
  public void testGetDay() {
    assertEquals(1, ledZep.getDay());
    assertEquals(1, rex.getDay());
  }

  @Test
  public void testGetStage() {
    assertEquals("Rock Stage", ledZep.getStage());
    assertEquals("Indie Stage", rex.getStage());
  }

  @Test
  public void testGetSongList() {
    assertEquals(3, ledZep.getSongList().size());
    assertEquals(3, rex.getSongList().size());
  }

  @Test
  public void testGetIRLIndex() {
    assertEquals(4.0, ledZep.getIRLIndex(), 0.01);
    assertEquals(5.0, rex.getIRLIndex(), 0.01);
  }

  @Test
  public void testGetSongByID() {
    assertEquals(stairway, ledZep.getSongByID(1));
    assertEquals(kashmir, ledZep.getSongByID(2));
    assertEquals(blackDog, ledZep.getSongByID(3));
    assertEquals(sunflower, rex.getSongByID(4));
    assertEquals(lovingIsEasy, rex.getSongByID(5));
    assertEquals(bestFriend, rex.getSongByID(6));
  }

  @Test
  public void testGetSongByName() {
    assertEquals(stairway, ledZep.getSongByName("Stairway to Heaven"));
    assertEquals(kashmir, ledZep.getSongByName("Kashmir"));
    assertEquals(blackDog, ledZep.getSongByName("Black Dog"));
    assertEquals(sunflower, rex.getSongByName("Sunflower"));
    assertEquals(lovingIsEasy, rex.getSongByName("Loving Is Easy"));
    assertEquals(bestFriend, rex.getSongByName("Best Friend"));
  }

  @Test
  public void testGetOverride() {
    assertFalse(ledZep.getOverride());
    assertFalse(rex.getOverride());
  }

  @Test
  public void testSetID() {
    ledZep.setID(3);
    assertEquals(3, ledZep.getID());
  }

  @Test
  public void testSetName() {
    ledZep.setName("New Name");
    assertEquals("New Name", ledZep.getName());
  }

  @Test
  public void testSetStartTime() {
    ledZep.setStartTime(1200);
    assertEquals(1200, ledZep.getStartTime());
  }

  @Test
  public void testSetEndTime() {
    ledZep.setEndTime(1300);
    assertEquals(1300, ledZep.getEndTime());
  }

  @Test
  public void testSetDay() {
    ledZep.setDay(2);
    assertEquals(2, ledZep.getDay());
  }

  @Test
  public void testSetStage() {
    ledZep.setStage("New Stage");
    assertEquals("New Stage", ledZep.getStage());
  }

  @Test
  public void testSetSongList() {
    ledZep.setSongList(rex.getSongList());
    assertEquals(3, ledZep.getSongList().size());
    assertEquals(rex.getSongList(), ledZep.getSongList());
  }

  @Test
  public void testAddSong() {
    Song newSong = new Song("New Song", 7, this.ledZep, 5.0, 5.0);
    ledZep.addSong(newSong);
    assertEquals(4, ledZep.getSongList().size());
    assertEquals(newSong, ledZep.getSongList().get(3));
  }

  @Test
  public void testRemoveSong() {
    ledZep.removeSong(1);
    assertEquals(2, ledZep.getSongList().size());
    assertEquals(kashmir, ledZep.getSongList().get(0));
    assertEquals(blackDog, ledZep.getSongList().get(1));
  }

  @Test
  public void testSetSong() {
    Song newSong = new Song("New Song", 7, this.ledZep, 5.0, 5.0);
    ledZep.setSong("Stairway to Heaven", newSong);
    assertEquals(3, ledZep.getSongList().size());
    assertEquals(newSong, ledZep.getSongList().get(0));
  }

  @Test
  public void testSetIRLIndex() {
    ledZep.setIRLIndex(3.0);
    assertEquals(3.0, ledZep.getIRLIndex(), 0.01);
  }

  @Test
  public void testSetOverride() {
    ledZep.setOverride(true);
    assertTrue(ledZep.getOverride());
  }

  @Test
  public void testIsDuring() {
    assertTrue(ledZep.isDuring(1030));
    assertTrue(ledZep.isDuring(1100));
    assertTrue(ledZep.isDuring(1130));
    assertFalse(ledZep.isDuring(1200));
    assertFalse(ledZep.isDuring(900));
  }

  @Test
  public void testCalculateOverallRating() {
    assertEquals(4.0, ledZep.calculateOverallRating(), 0.01);
    assertEquals(4.59, rex.calculateOverallRating(), 0.01);
  }

  @Test
  public void testToString() {
    assertEquals("(1) Led Zeppelin\n" +
            "Stairway to Heaven, Kashmir, Black Dog\n" +
            "Day 1 from 1030 to 1130\n" +
            " at Rock Stage\n" +
            "Overall Rating: 4.0", ledZep.toString());
    assertEquals("(2) Rex Orange County\n" +
            "Sunflower, Loving Is Easy, Best Friend\n" +
            "Day 1 from 1100 to 1230\n" +
            " at Indie Stage\n" +
            "Overall Rating: 4.59", rex.toString());
  }
}
