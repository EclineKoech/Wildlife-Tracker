import models.Animal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
  @Rule
  public DatabaseRule databaseRule = new DatabaseRule();

//  @Test
//  public void animal_instantiatesCorrectly_true() {
//    Animal animal = new Animal();
//    assertEquals(true, animal instanceof Animal);
//  }
//
//
//  @Test
//  public void instanceOfClass() {
//    Animal animal = new Animal("Cecil","Cat","Adult","amboseli","okay");
//    assertEquals(true, animal instanceof Animal);
//  }

//  @Test
//  public void getName_animalInstantiatesWithName_Tiger() {
//    Animal animal = new Animal("Cecil","Cat","Adult","amboseli","okay");
//    assertEquals(Animal.all().getName(),animal);
//  }
  @Test
  public void save_instanceOfAnimal_true() {
    Animal animal = new Animal("Cecil","Cat","Adult","endangered","amboseli","okay");
    animal.save();
    assertEquals(Animal.all().get(0),animal);
  }
}