import models.Animal;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
  private static Object sighting;

  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "layout.hbs");
    }, new HandlebarsTemplateEngine());

    get("/home", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "home.hbs");
    }, new HandlebarsTemplateEngine());

    get("/animal.hbs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return new ModelAndView(model, "animal.hbs");
    }, new HandlebarsTemplateEngine());


    get("/sighting", (request, response) -> {
      return new ModelAndView(new HashMap(), "sighting.hbs");
    }, new HandlebarsTemplateEngine());

    get("/form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      return  new ModelAndView(model,"form.hbs");
    },new HandlebarsTemplateEngine());
    post("/form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String rangerName = request.queryParams("ranger_name");
      String animalName = request.queryParams("animal_name");
      int age = Integer.parseInt(request.queryParams("age"));
      String location = request.queryParams("location");
      String health = request.queryParams("health");
      Animal animal = new Animal(rangerName, animalName, age, location,health);
      model.put("animal", animal);
      return new ModelAndView(model, "sighting.hbs");
    }, new HandlebarsTemplateEngine());

    post("/sighting", (req, res) -> {
      Map<String, Object> model = new HashMap<>();
      String name = req.queryParams("name");
      Timestamp timestamp = null;
      Sighting animal = new Sighting(name, null);
      animal.save();
      List<Sighting> siteObj = Sighting.getAll();
      model.put("sighting", sighting);
      return new ModelAndView(model,"sighting.hbs");
    }, new HandlebarsTemplateEngine());
  }
}


