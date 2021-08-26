package models;

import java.sql.Connection;

public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker");

  private static class Sql2o {
    public Sql2o(String s, Object o, Object o1) {
    }

    public Sql2o(String s) {
    }

    public Connection open() {
      return null;
    }
  }
}
