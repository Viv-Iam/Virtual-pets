import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class CommunityTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
    public void community_instantiatesCorrectly_true() {
      Community testCommunity = new Community("Water Enthusiasts", "Lovers of all things water monsters!");
      assertEquals(true, testCommunity instanceof Community);
    }

    @Test
  public void getName_communityInstantiatesWithName_true() {
    Community testCommunity = new Community("Water Enthusiasts", "Lovers of all things water monsters!");
    assertEquals("Water Enthusiasts", testCommunity.getName());
  }

  @Test
    public void getName_communityInstantiatesWithDescription_String() {
      Community testCommunity = new Community("Water Enthusiasts", "Lovers of all things water monsters!");
      assertEquals("Lovers of all things water monsters!", testCommunity.getDescription());
}

@Test
  public void equals_returnsTrueIfNameAndDescriptionAreSame_true() {
    Community testCommunity = new Community("Fire Enthusiasts", "Flame on!");
    Community anotherCommunity = new Community("Fire Enthusiasts", "Flame on!");
    assertTrue(testCommunity.equals(anotherCommunity));
  }
}
