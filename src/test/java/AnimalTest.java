import models.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal animal = new Animal();
    assertEquals(true, animal instanceof Animal);
  }


  @Test
  public void instanceOfClass() {
    Animal animal = new Animal();
    assertEquals(true, animal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Tiger() {
    Animal animal = new Animal("Tiger", 1);
    assertEquals("Tiger", animal.getName());
  }
}