package models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting{
  private static Object Sighting;
  private int id;
  private String ranger_name;
  private Timestamp timestamp;


  public Sighting(String name, Timestamp timestamp) {
    this.ranger_name = name;
    this.timestamp = timestamp;
  }

  public Sighting() {

  }

  public static List<Sighting> getAll() {
    return (List<models.Sighting>) Sighting;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRanger_name() {
    return ranger_name;
  }

  public void setRanger_name(String ranger_name) {
    this.ranger_name = ranger_name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sighting)) return false;
    Sighting sighting = (Sighting) o;
    return getId() == sighting.getId() &&
            getRanger_name().equals(sighting.getRanger_name());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getRanger_name());
  }

  public void save() {
    try (org.sql2o.Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sighting(name, timestamp) VALUES (:name, now());";
      con.createQuery(sql)
              .addParameter("name", this.ranger_name)
              .executeUpdate();
    } catch (Sql2oException error) {
      System.out.println("error: " + error);
    }
  }
  public static  void clearAll() throws Sql2oException {
    try (Connection connection = DB.sql2o.open()){
      String sql = "DELETE FROM sighting *";
      connection.createQuery(sql).executeUpdate();
    }
  }
}
