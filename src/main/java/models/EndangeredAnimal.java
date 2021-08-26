package models;

public class EndangeredAnimal {
  private String name;
  private int id;

  public EndangeredAnimal(String name, int id, String health, int age){
    this.name=name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
