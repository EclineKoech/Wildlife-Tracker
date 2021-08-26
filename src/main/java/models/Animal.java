package models;

import java.util.Objects;

public class Animal {
  private int id;
  private String name;

  public Animal(String name, int id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Animal)) return false;
    Animal animal = (Animal) o;
    return getId() == animal.getId() &&
            getName().equals(animal.getName());
  }

  @Override
  public int hashCode () {
    return Objects.hash(getId(), getName());
  }

  private void name() {
  }

  private int id() {
    return id;
  }

  private static int getId() {
    return 0;
  }

  public static Object getName() {
    return null;
  }

//  public String all() {
//    String sql = "SELECT * FROM animals";
//    try (Connection con = DB.sql2o.open()) {
//      return con.createQuery(sql).executeAndFetch(Animal.class);
//    }
//
//    public void save () {
//      try (Connection con = DB.sql2o.open()) {
//        String sql = "INSERT INTO animals (name, id) VALUES (:name, :id)";
//        con.createQuery(sql)
//                .addParameter("name", this.name)
//                .addParameter("email", this.id)
//                .executeUpdate();
//        }
//      }

  public Animal(String ranger_name, String animal_name, int age, String location, String health){
      }

      public void setId ( int id){
        this.id = id;
      }

      public void setName (String name){
        this.name = name;
      }

  public Animal() {
      }
      
    }
  