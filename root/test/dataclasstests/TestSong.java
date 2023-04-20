package dataclasstests;

import org.junit.Before;
import org.junit.Test;

import dataclasses.Artist;
import dataclasses.Song;

import static org.junit.Assert.assertEquals;

public class TestSong {
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
    this.lovingIsEasy = new Song("Loving Is Easy", 5, this.rex, 4.0, 4.0);
    this.bestFriend = new Song("Best Friend", 6, this.rex, 3.0, 3.0);
    this.rex.addSong(this.sunflower);
    this.rex.addSong(this.lovingIsEasy);
    this.rex.addSong(this.bestFriend);
  }

  @Test
  public void testGetID() {
    assertEquals(1, stairway.getID());
    assertEquals(2, kashmir.getID());
    assertEquals(3, blackDog.getID());
    assertEquals(4, sunflower.getID());
    assertEquals(5, lovingIsEasy.getID());
    assertEquals(6, bestFriend.getID());
  }

  @Test
  public void testGetSongName() {
    assertEquals("Stairway to Heaven", stairway.getName());
    assertEquals("Kashmir", kashmir.getName());
    assertEquals("Black Dog", blackDog.getName());
    assertEquals("Sunflower", sunflower.getName());
    assertEquals("Loving Is Easy", lovingIsEasy.getName());
    assertEquals("Best Friend", bestFriend.getName());
  }

  @Test
  public void testGetArtist() {
    assertEquals(ledZep, stairway.getArtist());
    assertEquals(ledZep, kashmir.getArtist());
    assertEquals(ledZep, blackDog.getArtist());
    assertEquals(rex, sunflower.getArtist());
    assertEquals(rex, lovingIsEasy.getArtist());
    assertEquals(rex, bestFriend.getArtist());
  }

  @Test
  public void testGetArtistName() {
    assertEquals("Led Zeppelin", stairway.getArtistName());
    assertEquals("Led Zeppelin", kashmir.getArtistName());
    assertEquals("Led Zeppelin", blackDog.getArtistName());
    assertEquals("Rex Orange County", sunflower.getArtistName());
    assertEquals("Rex Orange County", lovingIsEasy.getArtistName());
    assertEquals("Rex Orange County", bestFriend.getArtistName());
  }

  @Test
  public void testGetRating() {
    assertEquals(5.0, stairway.getRating(), 0.01);
    assertEquals(4.0, kashmir.getRating(), 0.01);
    assertEquals(3.0, blackDog.getRating(), 0.01);
    assertEquals(5.0, sunflower.getRating(), 0.01);
    assertEquals(4.0, lovingIsEasy.getRating(), 0.01);
    assertEquals(3.0, bestFriend.getRating(), 0.01);
  }

  @Test
  public void testGetIRLIndex() {
    assertEquals(5.0, stairway.getIRLIndex(), 0.01);
    assertEquals(3.0, kashmir.getIRLIndex(), 0.01);
    assertEquals(4.0, blackDog.getIRLIndex(), 0.01);
    assertEquals(5.0, sunflower.getIRLIndex(), 0.01);
    assertEquals(4.0, lovingIsEasy.getIRLIndex(), 0.01);
    assertEquals(3.0, bestFriend.getIRLIndex(), 0.01);
  }

  @Test
  public void testSetID() {
    stairway.setID(7);
    kashmir.setID(8);
    blackDog.setID(9);
    sunflower.setID(10);
    lovingIsEasy.setID(11);
    bestFriend.setID(12);
    assertEquals(7, stairway.getID());
    assertEquals(8, kashmir.getID());
    assertEquals(9, blackDog.getID());
    assertEquals(10, sunflower.getID());
    assertEquals(11, lovingIsEasy.getID());
    assertEquals(12, bestFriend.getID());
  }

  @Test
  public void testSetSongName() {
    stairway.setSongName("Stairway to Heaven");
    kashmir.setSongName("Kashmir (Live)");
    blackDog.setSongName("Black Dog (Live)");
    sunflower.setSongName("Sunflower (Live)");
    lovingIsEasy.setSongName("Loving Is Easy (Live)");
    bestFriend.setSongName("Best Friend (Live)");
    assertEquals("Stairway to Heaven", stairway.getName());
    assertEquals("Kashmir (Live)", kashmir.getName());
    assertEquals("Black Dog (Live)", blackDog.getName());
    assertEquals("Sunflower (Live)", sunflower.getName());
    assertEquals("Loving Is Easy (Live)", lovingIsEasy.getName());
    assertEquals("Best Friend (Live)", bestFriend.getName());
  }

  @Test
  public void testSetArtist() {
    stairway.setArtist(rex);
    kashmir.setArtist(rex);
    blackDog.setArtist(rex);
    sunflower.setArtist(ledZep);
    lovingIsEasy.setArtist(ledZep);
    bestFriend.setArtist(ledZep);
    assertEquals(rex, stairway.getArtist());
    assertEquals(rex, kashmir.getArtist());
    assertEquals(rex, blackDog.getArtist());
    assertEquals(ledZep, sunflower.getArtist());
    assertEquals(ledZep, lovingIsEasy.getArtist());
    assertEquals(ledZep, bestFriend.getArtist());
  }

  @Test
  public void testSetRating() {
    stairway.setRating(4.0);
    kashmir.setRating(3.0);
    blackDog.setRating(2.0);
    sunflower.setRating(4.0);
    lovingIsEasy.setRating(3.0);
    bestFriend.setRating(2.0);
    assertEquals(4.0, stairway.getRating(), 0.01);
    assertEquals(3.0, kashmir.getRating(), 0.01);
    assertEquals(2.0, blackDog.getRating(), 0.01);
    assertEquals(4.0, sunflower.getRating(), 0.01);
    assertEquals(3.0, lovingIsEasy.getRating(), 0.01);
    assertEquals(2.0, bestFriend.getRating(), 0.01);
  }

  @Test
  public void testSetIRLIndex() {
    stairway.setIRLIndex(4.0);
    kashmir.setIRLIndex(2.0);
    blackDog.setIRLIndex(3.0);
    sunflower.setIRLIndex(4.0);
    lovingIsEasy.setIRLIndex(3.0);
    bestFriend.setIRLIndex(2.0);
    assertEquals(4.0, stairway.getIRLIndex(), 0.01);
    assertEquals(2.0, kashmir.getIRLIndex(), 0.01);
    assertEquals(3.0, blackDog.getIRLIndex(), 0.01);
    assertEquals(4.0, sunflower.getIRLIndex(), 0.01);
    assertEquals(3.0, lovingIsEasy.getIRLIndex(), 0.01);
    assertEquals(2.0, bestFriend.getIRLIndex(), 0.01);
  }

  @Test
  public void testCalculateOverallRating() {
    assertEquals(5.0, stairway.calculateOverallRating(), 0.01);
    assertEquals(3.5, kashmir.calculateOverallRating(), 0.01);
    assertEquals(3.5, blackDog.calculateOverallRating(), 0.01);
    assertEquals(5.0, sunflower.calculateOverallRating(), 0.01);
    assertEquals(4.0, lovingIsEasy.calculateOverallRating(), 0.01);
    assertEquals(3.0, bestFriend.calculateOverallRating(), 0.01);
  }

  @Test
  public void testToString() {
    assertEquals("Stairway to Heaven by Led Zeppelin", stairway.toString());
    assertEquals("Kashmir by Led Zeppelin", kashmir.toString());
    assertEquals("Black Dog by Led Zeppelin", blackDog.toString());
    assertEquals("Sunflower by Rex Orange County", sunflower.toString());
    assertEquals("Loving Is Easy by Rex Orange County", lovingIsEasy.toString());
    assertEquals("Best Friend by Rex Orange County", bestFriend.toString());
  }
}
