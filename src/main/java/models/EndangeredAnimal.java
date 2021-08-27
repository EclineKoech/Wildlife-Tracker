package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EndangeredAnimal extends Animal implements DatabaseManagement {
  private String name;
  private int id;
  private String health;
  private String age;
  private String location;
  public static ArrayList<EndangeredAnimal> endangeredAnimal = new ArrayList<>();
  private String ranger_name;


  public EndangeredAnimal(String name, String health, String age) {
    this.name = name;
    endangeredAnimal.add(this);
    this.id = endangeredAnimal.size();

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EndangeredAnimal)) return false;
    EndangeredAnimal that = (EndangeredAnimal) o;
    return id == that.id &&
            name.equals(that.name) &&
            getHealth().equals(that.getHealth()) &&
            getAge().equals(that.getAge()) &&
            getLocation().equals(that.getLocation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, getHealth(), getAge(), getLocation());
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHealth() {
    return health;
  }

  public void setHealth(String health) {
    this.health = health;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public static ArrayList<EndangeredAnimal> getEndangeredAnimal() {
    return endangeredAnimal;
  }

  public static void setEndangeredAnimal(ArrayList<EndangeredAnimal> endangeredAnimal) {
    EndangeredAnimal.endangeredAnimal = endangeredAnimal;
  }

  public static List<EndangeredAnimal> all() {
    String sql = "SELECT * FROM animals";
    try (Connection con = (Connection) DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
    }
  }

  public static EndangeredAnimal find(int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id";
      EndangeredAnimal endangeredAnimal = con.createQuery(sql)
              .addParameter("id", id)
              .executeAndFetchFirst(EndangeredAnimal.class);
      return endangeredAnimal;
    }
  }

  public String getRanger_name() {
    return ranger_name;
  }

  public void setRanger_name(String ranger_name) {
    this.ranger_name = ranger_name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void save() {
    try (Connection con = (Connection) DB.sql2o.open()) {
      String sql = "INSERT INTO endangeredAnimals (name, health, age, location, ranger_name) VALUES (:name, :health, :age, :location, :ranger_name )";
      this.id = (int) con.createQuery(sql, true)
              .addParameter("name", this.name)
              .addParameter("health", this.health)
              .addParameter("age", this.age)
              .addParameter("location", this.location)
              .addParameter("ranger_name", this.ranger_name)
              .executeUpdate()
              .getKey();
    }
  }

  public void delete() {
    try (Connection connection = DB.sql2o.open()) {
      String sql = "DELETE FROM animals *;";
      connection.createQuery(sql)
              .addParameter("id", this.id)
              .executeUpdate();
      connection.createQuery(sql).executeUpdate();
    } catch (Sql2oException error) {
      System.out.println("error::: " + error);
    }

  }
}
