package dataclasstests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import dataclasses.Artist;
import dataclasses.Day;
import dataclasses.Festival;
import dataclasses.IArtist;
import dataclasses.IDay;
import dataclasses.ISong;
import dataclasses.Song;

import static org.junit.Assert.assertEquals;

/**
 * Tests the Festival class.
 */
public class FestivalTest {
  // artists
  private Artist ledZep;
  private Artist rex;
  private Artist hayve;
  private Artist protostar;
  private Artist elton;
  private Artist beatles;
  private Artist queen;

  // songs
  private Song stairway;
  private Song kashmir;
  private Song blackDog;
  private Song sunflower;
  private Song lovingIsEasy;
  private Song bestFriend;
  private Song change;
  private Song betweenTheLines;
  private Song overdrive;
  private Song whereIBelong;
  private Song rocketMan;
  private Song yellowBrickRoad;
  private Song comeTogether;
  private Song something;
  private Song letItBe;
  private Song weWillRockYou;
  private Song weAreTheChampions;

  // other
  private Day day1;
  private Day day2;
  private Day day3;
  private Festival fest;

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

    this.hayve = new Artist("Hayve",
            3, 1200, 1330, 1,
            "EDM Stage", null, 5.0);
    this.change = new Song("Change", 7, this.hayve, 5.0, 5.0);
    this.betweenTheLines = new Song("Between the Lines", 8,
            this.hayve, 4.5, 4.0);
    this.hayve.addSong(this.change);
    this.hayve.addSong(this.betweenTheLines);

    this.protostar = new Artist("Protostar",
            4, 2230, 2330, 2,
            "EDM Stage", null, 5.0);
    this.overdrive = new Song("Overdrive", 9, this.protostar, 5.0, 5.0);
    this.whereIBelong = new Song("Where I Belong", 10,
            this.protostar, 4.0, 5.0);
    this.protostar.addSong(this.overdrive);
    this.protostar.addSong(this.whereIBelong);

    this.elton = new Artist("Elton John",
            5, 2230, 2400, 2,
            "Psychedelic Stage", null, 3.0);
    this.rocketMan = new Song("Rocketman", 11, this.elton, 5.0, 3.0);
    this.yellowBrickRoad = new Song("Goodbye Yellow Brick Road", 12,
            this.elton, 5.0, 2.0);
    this.elton.addSong(this.rocketMan);
    this.elton.addSong(this.yellowBrickRoad);

    this.beatles = new Artist("The Beatles",
            6, 2230, 2500, 2,
            "Rock Stage", null, 5.0);
    this.comeTogether = new Song("Come Together", 13, this.beatles, 5.0, 5.0);
    this.something = new Song("Something", 14, this.beatles, 5.0, 5.0);
    this.letItBe = new Song("Let It Be", 15, this.beatles, 5.0, 5.0);
    this.beatles.addSong(this.comeTogether);
    this.beatles.addSong(this.something);
    this.beatles.addSong(this.letItBe);

    this.queen = new Artist("Queen",
            7, 2230, 2500, 3,
            "Indie Stage", null, 5.0);
    this.weWillRockYou = new Song("We Will Rock You", 16, this.queen, 5.0, 5.0);
    this.weAreTheChampions = new Song("We Are The Champions", 17,
            this.queen, 5.0, 5.0);
    this.queen.addSong(this.weWillRockYou);
    this.queen.addSong(this.weAreTheChampions);

    this.day1 = new Day(1, 900, 2330);
    this.day2 = new Day(2, 1100, 2500);
    this.day3 = new Day(3, 930, 2330);

    List<IArtist> artists = new ArrayList<>();
    artists.add(this.ledZep);
    artists.add(this.rex);
    artists.add(this.hayve);
    artists.add(this.protostar);
    artists.add(this.elton);
    artists.add(this.beatles);
    artists.add(this.queen);

    List<IDay> days = new ArrayList<>();
    days.add(this.day1);
    days.add(this.day2);
    days.add(this.day3);

    this.fest = new Festival("OSL", days, artists);
  }

  @Test
  public void testGetName() {
    assertEquals("OSL", this.fest.getName());
  }

  @Test
  public void testGetDayList() {
    assertEquals(3, this.fest.getDayList().size());
    assertEquals(this.day1, this.fest.getDayList().get(0));
    assertEquals(this.day2, this.fest.getDayList().get(1));
    assertEquals(this.day3, this.fest.getDayList().get(2));
  }

  @Test
  public void testGetArtistList() {
    assertEquals(7, this.fest.getArtistList().size());
    assertEquals(this.ledZep, this.fest.getArtistList().get(0));
    assertEquals(this.rex, this.fest.getArtistList().get(1));
    assertEquals(this.hayve, this.fest.getArtistList().get(2));
    assertEquals(this.protostar, this.fest.getArtistList().get(3));
    assertEquals(this.elton, this.fest.getArtistList().get(4));
    assertEquals(this.beatles, this.fest.getArtistList().get(5));
    assertEquals(this.queen, this.fest.getArtistList().get(6));
  }

  @Test
  public void testGetSongList() {
    assertEquals(17, this.fest.getSongList().size());
    assertEquals(this.stairway, this.fest.getSongList().get(0));
    assertEquals(this.weAreTheChampions, this.fest.getSongList().get(16));
  }

  @Test
  public void testGetSongListByArtist() {
    assertEquals(3, this.fest.getSongListByArtist(this.ledZep).size());
    assertEquals(this.stairway, this.fest.getSongListByArtist(this.ledZep).get(0));
    assertEquals(this.kashmir, this.fest.getSongListByArtist(this.ledZep).get(1));
    assertEquals(this.blackDog, this.fest.getSongListByArtist(this.ledZep).get(2));

    assertEquals(3, this.fest.getSongListByArtist(this.rex).size());
    assertEquals(this.sunflower, this.fest.getSongListByArtist(this.rex).get(0));
    assertEquals(this.lovingIsEasy, this.fest.getSongListByArtist(this.rex).get(1));
    assertEquals(this.bestFriend, this.fest.getSongListByArtist(this.rex).get(2));

    assertEquals(2, this.fest.getSongListByArtist(this.hayve).size());
    assertEquals(this.change, this.fest.getSongListByArtist(this.hayve).get(0));
    assertEquals(this.betweenTheLines, this.fest.getSongListByArtist(this.hayve).get(1));

    assertEquals(2, this.fest.getSongListByArtist(this.protostar).size());
    assertEquals(this.overdrive, this.fest.getSongListByArtist(this.protostar).get(0));
    assertEquals(this.whereIBelong, this.fest.getSongListByArtist(this.protostar).get(1));

    assertEquals(2, this.fest.getSongListByArtist(this.elton).size());
    assertEquals(this.rocketMan, this.fest.getSongListByArtist(this.elton).get(0));
    assertEquals(this.yellowBrickRoad, this.fest.getSongListByArtist(this.elton).get(1));

    assertEquals(3, this.fest.getSongListByArtist(this.beatles).size());
    assertEquals(this.comeTogether, this.fest.getSongListByArtist(this.beatles).get(0));
    assertEquals(this.something, this.fest.getSongListByArtist(this.beatles).get(1));
    assertEquals(this.letItBe, this.fest.getSongListByArtist(this.beatles).get(2));

    assertEquals(2, this.fest.getSongListByArtist(this.queen).size());
    assertEquals(this.weWillRockYou, this.fest.getSongListByArtist(this.queen).get(0));
    assertEquals(this.weAreTheChampions, this.fest.getSongListByArtist(this.queen).get(1));
  }

  @Test
  public void testGetSongListByArtistName() {
    assertEquals(3, this.fest.getSongListByArtistName("Led Zeppelin").size());
    assertEquals(this.stairway, this.fest.getSongListByArtistName("Led Zeppelin").get(0));
    assertEquals(this.kashmir, this.fest.getSongListByArtistName("Led Zeppelin").get(1));
    assertEquals(this.blackDog, this.fest.getSongListByArtistName("Led Zeppelin").get(2));

    assertEquals(3, this.fest.getSongListByArtistName("Rex Orange County").size());
    assertEquals(this.sunflower, this.fest.getSongListByArtistName("Rex Orange County").get(0));
    assertEquals(this.lovingIsEasy, this.fest.getSongListByArtistName("Rex Orange County").get(1));
    assertEquals(this.bestFriend, this.fest.getSongListByArtistName("Rex Orange County").get(2));

    assertEquals(2, this.fest.getSongListByArtistName("Hayve").size());
    assertEquals(this.change, this.fest.getSongListByArtistName("Hayve").get(0));
    assertEquals(this.betweenTheLines, this.fest.getSongListByArtistName("Hayve").get(1));

    assertEquals(2, this.fest.getSongListByArtistName("Protostar").size());
    assertEquals(this.overdrive, this.fest.getSongListByArtistName("Protostar").get(0));
    assertEquals(this.whereIBelong, this.fest.getSongListByArtistName("Protostar").get(1));

    assertEquals(2, this.fest.getSongListByArtistName("Elton John").size());
    assertEquals(this.rocketMan, this.fest.getSongListByArtistName("Elton John").get(0));
    assertEquals(this.yellowBrickRoad, this.fest.getSongListByArtistName("Elton John").get(1));

    assertEquals(3, this.fest.getSongListByArtistName("The Beatles").size());
    assertEquals(this.comeTogether, this.fest.getSongListByArtistName("The Beatles").get(0));
    assertEquals(this.something, this.fest.getSongListByArtistName("The Beatles").get(1));
    assertEquals(this.letItBe, this.fest.getSongListByArtistName("The Beatles").get(2));

    assertEquals(2, this.fest.getSongListByArtistName("Queen").size());
    assertEquals(this.weWillRockYou, this.fest.getSongListByArtistName("Queen").get(0));
    assertEquals(this.weAreTheChampions, this.fest.getSongListByArtistName("Queen").get(1));
  }

  @Test
  public void testGetSongListByArtistID() {
    assertEquals(3, this.fest.getSongListByArtistID(this.ledZep.getID()).size());
    assertEquals(this.stairway, this.fest.getSongListByArtistID(this.ledZep.getID()).get(0));
    assertEquals(this.kashmir, this.fest.getSongListByArtistID(this.ledZep.getID()).get(1));
    assertEquals(this.blackDog, this.fest.getSongListByArtistID(this.ledZep.getID()).get(2));

    assertEquals(3, this.fest.getSongListByArtistID(this.rex.getID()).size());
    assertEquals(this.sunflower, this.fest.getSongListByArtistID(this.rex.getID()).get(0));
    assertEquals(this.lovingIsEasy, this.fest.getSongListByArtistID(this.rex.getID()).get(1));
    assertEquals(this.bestFriend, this.fest.getSongListByArtistID(this.rex.getID()).get(2));

    assertEquals(2, this.fest.getSongListByArtistID(this.hayve.getID()).size());
    assertEquals(this.change, this.fest.getSongListByArtistID(this.hayve.getID()).get(0));
    assertEquals(this.betweenTheLines, this.fest.getSongListByArtistID(this.hayve.getID()).get(1));

    assertEquals(2, this.fest.getSongListByArtistID(this.protostar.getID()).size());
    assertEquals(this.overdrive, this.fest.getSongListByArtistID(this.protostar.getID()).get(0));
    assertEquals(this.whereIBelong, this.fest.getSongListByArtistID(this.protostar.getID()).get(1));

    assertEquals(2, this.fest.getSongListByArtistID(this.elton.getID()).size());
    assertEquals(this.rocketMan, this.fest.getSongListByArtistID(this.elton.getID()).get(0));
    assertEquals(this.yellowBrickRoad, this.fest.getSongListByArtistID(this.elton.getID()).get(1));

    assertEquals(3, this.fest.getSongListByArtistID(this.beatles.getID()).size());
    assertEquals(this.comeTogether, this.fest.getSongListByArtistID(this.beatles.getID()).get(0));
  }

  @Test
  public void testSetName() {
    this.fest.setName("New Name");
    assertEquals("New Name", this.fest.getName());
  }

 @Test
 public void testSetDayList() {
    List<IDay> dayList = new ArrayList<>();
    dayList.add(this.day1);
    dayList.add(this.day2);
    dayList.add(this.day3);
    this.fest.setDayList(dayList);
    assertEquals(dayList, this.fest.getDayList());
 }

  @Test
  public void testSetArtistList() {
    List<IArtist> artistList = new ArrayList<>();
    artistList.add(this.ledZep);
    artistList.add(this.rex);
    artistList.add(this.hayve);
    artistList.add(this.protostar);
    artistList.add(this.elton);
    artistList.add(this.beatles);
    artistList.add(this.queen);
    this.fest.setArtistList(artistList);
    assertEquals(artistList, this.fest.getArtistList());
  }

  @Test
  public void testAddDay() {
    IDay day4 = new Day(4, 900, 1200);
    this.fest.addDay(day4);
    assertEquals(4, this.fest.getDayList().size());
    assertEquals(day4, this.fest.getDayList().get(3));
  }

  @Test
  public void testAddArtist() {
    IArtist artist8 = new Artist("Bingus",
            542, 1030, 1130, 1,
            "Rock Stage", null, 4.0);
    this.fest.addArtist(artist8);
    assertEquals(8, this.fest.getArtistList().size());
    assertEquals(artist8, this.fest.getArtistList().get(7));
  }

  @Test
  public void testRemoveArtist() {
    this.fest.removeArtist("Queen");
    assertEquals(6, this.fest.getArtistList().size());
    assertEquals(this.ledZep, this.fest.getArtistList().get(0));
    assertEquals(this.rex, this.fest.getArtistList().get(1));
    assertEquals(this.hayve, this.fest.getArtistList().get(2));
    assertEquals(this.protostar, this.fest.getArtistList().get(3));
    assertEquals(this.elton, this.fest.getArtistList().get(4));
    assertEquals(this.beatles, this.fest.getArtistList().get(5));
  }

  @Test
  public void testRemoveDay() {
    this.fest.removeDay(3);
    assertEquals(2, this.fest.getDayList().size());
    assertEquals(this.day1, this.fest.getDayList().get(0));
    assertEquals(this.day2, this.fest.getDayList().get(1));
  }

  @Test
  public void testGenerateSchedule() {
    // TODO: Implement this test
  }
}
