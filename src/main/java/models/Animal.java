package models;

public class Animal {
  private int id;
  private  String name;

  public Animal(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public Animal(String name, int age, String location, String health) {
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Animal() {
  }

  public String getName() {
    return name;
  }

  public Integer getId() {
    return id;
  }
}
