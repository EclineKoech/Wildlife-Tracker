import models.Animal;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal animal = new Animal();
    assertEquals(true, animal instanceof Animal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Tiger() {
    Animal animal = new Animal("Tiger", 001);
    assertEquals("Tiger", animal.getName());
  }

//  @Test
//  public void save_insertsObjectIntoDatabase_Animal() {
//    Animal animal = new Animal("Tiger", 001);
//    animal.save();
//    assertTrue(Animal.all().get(0).equals(animal));
//  }

//  @Test
//  public void all_returnsAllInstancesOfAnimal_true() {
//    Animal firstAnimal = new Animal("Cat", 003);
//    firstAnimal.save();
//    Animal secondAnimal = new Animal("Cow",004);
//    secondAnimal.save();
//    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
//    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
//  }

//  @Test
//  public void save_assignsIdToObject() {
//    Animal testAnimal = new Animal("Donkey", 002);
//    Animal.save();
//    Animal savedAnimal = Animal.all().get(0);
//    assertEquals(animal.getId(), savedAnimal.getId());
//  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

}