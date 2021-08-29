package models;

import org.sql2o.Sql2o;

public class DB {
 public static String connection = "jdbc:postgresql://ec2-35-153-91-18.compute-1.amazonaws.com:5432/dbmq0ghk9vnj2l";
 public static Sql2o sql2o = new Sql2o(connection,"xiudpyutvqudsw","dd274907e41b0bd7979d823357999b5f46d0fc176ded6b9cb1fa198d1a92c9a2");

}
