import models.Animal;
import models.EndangeredAnimal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalTest {
  @Rule
  public DatabaseRule databaseRule = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true(){
    EndangeredAnimal endangeredAnimal = new EndangeredAnimal("dog","park");
    assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void EndangeredAnimal_instantiatesWithName_String(){
    EndangeredAnimal endangeredAnimal = new EndangeredAnimal("dog","park");
    assertEquals("dog", endangeredAnimal.getName());
  }

  @Test
  public void EndangeredAnimal_instantiatesWithId_int(){
    EndangeredAnimal endangeredAnimal =  new EndangeredAnimal("dog","park");
    assertEquals(0,endangeredAnimal.getId());
  }

  @Test
  public void save_returnsTrueIfDescriptionsAreTheSame() {
    EndangeredAnimal endangeredAnimal =  new EndangeredAnimal("dog","near the river");
    endangeredAnimal.save();
    assertTrue(EndangeredAnimal.all().get(0).equals(endangeredAnimal));
  }

  @Test
  public void save_assignsIdToEndangeredAnimal() {
    EndangeredAnimal endangeredAnimal = new EndangeredAnimal("dog","zone a");
    endangeredAnimal.save();
    Animal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
    assertEquals(savedEndangeredAnimal.getId(),endangeredAnimal.getId());
  }
  @Test
  public void all_returnsAllInstancesOfEndangeredAnimal_true() {
    EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("dog","park");
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("cat","park");
    secondEndangeredAnimal.save();
    assertEquals(true,EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
    assertEquals(true,EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
  }
  @Test
  public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("cheetah","park");
    assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()),secondEndangeredAnimal);
  }
}
