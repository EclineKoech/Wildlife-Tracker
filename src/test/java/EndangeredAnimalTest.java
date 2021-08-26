import models.EndangeredAnimal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true(){
    EndangeredAnimal endangeredAnimal = new EndangeredAnimal("dog",1,"ill",2);
    assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void EndangeredAnimal_instantiatesWithName_String(){
    EndangeredAnimal endangeredAnimal = new EndangeredAnimal("dog",1,"ill",2);
    assertEquals("dog", endangeredAnimal.getName());
  }

  @Test
  public void EndangeredAnimal_instantiatesWithId_int(){
    EndangeredAnimal endangeredAnimal =  new EndangeredAnimal("dog",0,"ill",2);
    assertEquals(0,endangeredAnimal.getId());
  }
}
