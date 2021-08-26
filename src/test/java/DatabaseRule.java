import org.junit.rules.ExternalResource;

public class DatabaseRule extends ExternalResource {
  @Override
  protected void before() throws Throwable {
    super.before();
  }

  @Override
  protected void after() {
    super.after();
  }
}
