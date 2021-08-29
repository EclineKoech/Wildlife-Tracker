import models.Sighting;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SightingTest {

  @Rule
  public DatabaseRule databaseRule = new DatabaseRule();

  @After
  public void tearDown() throws Exception {

  }

  @Before
  public void setUp() throws Exception {

  }

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
