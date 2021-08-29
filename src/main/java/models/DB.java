package models;

import org.sql2o.Sql2o;

public class DB {
 public static String connection = "jdbc:postgresql://localhost:5432/wildlife_tracker";
 public static Sql2o sql2o = new Sql2o(connection, "ecline","12345");

}
