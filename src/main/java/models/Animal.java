package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Animal {
  private int id;
  private String name;
  private String ranger;
  private String location;
  private String health;
  private String type;
  private String age;


  public Animal(String ranger_name, String name, String age,String type, String location, String health) {
    this.ranger = ranger_name;
    this.name = name;
    this.age = age;
    this.type = type;
    this.health = health;
    this.location = location;

  }

  public Animal() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Animal)) return false;
    Animal animal = (Animal) o;
    return getId() == animal.getId() &&
            Objects.equals(getName(), animal.getName()) &&
            Objects.equals(getRanger(), animal.getRanger()) &&
            Objects.equals(getLocation(), animal.getLocation()) &&
            Objects.equals(getHealth(), animal.getHealth()) &&
            Objects.equals(getType(), animal.getType()) &&
            Objects.equals(getAge(), animal.getAge());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getRanger(), getLocation(), getHealth(), getType(), getAge());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRanger() {
    return ranger;
  }

  public void setRanger(String ranger) {
    this.ranger = ranger;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getHealth() {
    return health;
  }

  public void setHealth(String health) {
    this.health = health;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public void save()  {
    try (Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals ( name, health,  location, ranger , age, type) VALUES(:name, :health, :location, :ranger, :age, :type)";
      this.id = (int) con.createQuery(sql, true)     
              .addParameter("name", this.name)
              .addParameter("ranger", this.ranger)
              .addParameter("location", this.location)
              .addParameter("health", this.health)
              .addParameter("age", this.age)
              .addParameter("type", this.type)
              .executeUpdate()
              .getKey();
    } catch (Sql2oException er) {
      System.out.println( "This is an error :" + er  );
    }
  }
  public static List<Animal> all() {
    String sql = "SELECT * FROM animals";
    try (Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Animal.class);
    }
 }
}