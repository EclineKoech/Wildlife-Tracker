import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {


  @Override
  protected void before() {
    Sql2o sql2o = new Sql2o("jdbc4:postgresql://localhost:5432/wildlife_tracker","ecline", "12345");
  }
  @Override
  protected void after() {
    try (Connection con = DB.sql2o.open()){
      String deleteAnimalsQuery = "DELETE FROM animals *;";
      con.createQuery(deleteAnimalsQuery)
              .executeUpdate();
    }
  }
}
