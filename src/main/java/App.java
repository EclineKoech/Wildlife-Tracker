import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "home.hbs");
    }, new HandlebarsTemplateEngine());

    get("/home", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "home.hbs");
    }, new HandlebarsTemplateEngine());

    get("/form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "form.hbs");
    }, new HandlebarsTemplateEngine());

    get("/sighting", (request, response) -> {
      Map<String,Object> model = new HashMap<>();
      model.put("sighting", Sighting.getAll());
      model.put("animal", EndangeredAnimal.all());
      return new ModelAndView(model, "sighting.hbs");
    }, new HandlebarsTemplateEngine());
    post("/sighting", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String rangerName = request.queryParams("ranger_name");
      String animalName = request.queryParams("animal_name");
      int age = Integer.parseInt(request.queryParams("age"));
      String location = request.queryParams("location");
      String health = request.queryParams("health");
      Animal animal = new Animal(rangerName, animalName, age, location, health);
      model.put("animal", animal);
      return new ModelAndView(model, "sighting.hbs");
    }, new HandlebarsTemplateEngine());
  }
}


