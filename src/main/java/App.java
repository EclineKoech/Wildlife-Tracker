import models.Animal;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
  static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
      return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
  }

  public static void main(String[] args) {
    port(getHerokuAssignedPort());

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
//      model.put("animal", EndangeredAnimal.all());
      return new ModelAndView(model, "sighting.hbs");
    }, new HandlebarsTemplateEngine());
    post("/sighting", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String rangerName = request.queryParams("ranger");
      String animalName = request.queryParams("animal_name");
      String age = request.queryParams("age");
      String type = request.queryParams("type");
      String health = request.queryParams("health");
      String location = request.queryParams("location");
     Animal animal = new Animal(rangerName, animalName, age, type, health, location);
     animal.save();
     model.put("animal", Animal.all());
//      model.put("animal", EndangeredAnimal.all());
      return new ModelAndView(model, "sighting.hbs");
    }, new HandlebarsTemplateEngine());
  }
}


