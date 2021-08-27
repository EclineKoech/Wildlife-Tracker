import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static models.DB.sql2o;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animals_test","ecline", "Ecline");
  }
  @Override
  protected void after() {
    try (Connection con = DB.sql2o.open()){
      String deleteAnimalsQuery = "DELETE FROM animals *;";
      String deleteEndangeredAnimalsQuery ="DELETE FROM endangered_animals *;";
      con.createQuery(deleteAnimalsQuery).executeUpdate();
      con.createQuery(deleteEndangeredAnimalsQuery).executeUpdate();
    }
  }
}
