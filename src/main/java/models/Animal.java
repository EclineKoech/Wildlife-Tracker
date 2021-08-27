package models;

import java.util.ArrayList;
import java.util.Objects;

public class Animal {
  private static ArrayList<Animal> animals = new ArrayList<>();
  private static Object ArrayList;
  private int id;
  private String name;

  public Animal(String name, int id) {
    this.name = name;
    animals.add(this);
    this.id = animals.size();
  }

  public Animal() {

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Animal)) return false;
    Animal animal = (Animal) o;
    return getId() == getId() &&
            getName().equals(getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }


  private int id() {
    return id;
  }

  private int getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public Object animal_name;

  public Animal(String ranger_name, String animal_name, int age, String location, String health) {
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static ArrayList<Animal> getAnimals() {
    return animals;
  }

  public static void setAnimals(ArrayList<Animal> animals) {
    Animal.animals = animals;
  }

//  public void save() throws SQLException {
//    try (Connection con = DB.sql2o.open()) {
//      String sql = "INSERT INTO animals ( name, id) VALUES(:name, :email)";
//      this.id = (int) con.createQuery(sql, true);
//      con.createQuery(sql)
//              .addParameter("name", this.name)
//              .addParameter("id", this.id)
//              .executeUpdate()
//              .getKey();
//    }
//  }
//
//  public static List<Animal> all() {
//    String sql = "SELECT * FROM animals";
//    try (Connection con = DB.sql2o.open()) {
//      return con.createQuery(sql).executeAndFetch(Animal.class);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }
}