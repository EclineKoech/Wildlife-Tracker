import models.Sighting;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SightingTest {

  @Rule
  public DatabaseRule databaseRule = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true(){
    Sighting sighting = new Sighting();
    assertEquals(true, true);
  }
  @Test
  public void instanceIsOfClass(){
    Sighting sighting = new Sighting();
    assertEquals(true, sighting instanceof Sighting);
  }
}
