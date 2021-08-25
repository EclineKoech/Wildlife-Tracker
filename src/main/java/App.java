import models.Animal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.route.HttpMethod.post;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "layout.hbs");
    }, new HandlebarsTemplateEngine());

    get("/home.hbs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "home.hbs");
    }, new HandlebarsTemplateEngine());

    get("/animal.hbs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "animal.hbs");
    }, new HandlebarsTemplateEngine());


    get("/sightings.hbs", (request, response) -> {
      return new ModelAndView(new HashMap(), "sightings.hbs");
    }, new HandlebarsTemplateEngine());
    post("/sightings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      int age = Integer.parseInt(request.queryParams("age"));
      String location = request.queryParams("health");
      String health = request.queryParams("health");
      Animal animal = new Animal(name, age, location,health);
      model.put("animal", animal);
      return new ModelAndView(model, "sightings.hbs");
    }, new HandlebarsTemplateEngine());
  }
}

