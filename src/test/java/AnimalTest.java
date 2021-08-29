import models.Animal;
import models.DB;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
  @Rule
  public DatabaseRule databaseRule = new DatabaseRule();

  public Animal setUpAnimal(){
    return new Animal("cecil", "Cat", "young","normal","zone a","ill");
  }
  @After
  public void tearDown() throws Exception {
    try(Connection connection = DB.sql2o.open()) {
      String sqlAnimal = "DELETE FROM animals *;";
      connection.createQuery(sqlAnimal).executeUpdate();
    }
  }



  @Test
  public void animal_instantiatesCorrectly_true() throws Exception {
    Animal animal = setUpAnimal();
    assertEquals(true, animal instanceof Animal);
  }

//
//
  @Test
  public void instanceOfClass() {
    Animal animal = new Animal("cecil", "Cat", "young","normal","zone a","ill");
    assertEquals(true, animal instanceof Animal);
  }

  @Test
  public void save_instanceOfAnimal_true() {
    Animal animal = new Animal("Cecil","Cat","Adult","endangered","amboseli","okay");
    animal.save();
    assertEquals(Animal.all().get(1),animal);
  }
}