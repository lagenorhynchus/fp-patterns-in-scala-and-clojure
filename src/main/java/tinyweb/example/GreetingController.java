package tinyweb.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

import tinyweb.HttpRequest;
import tinyweb.TemplateController;
import tinyweb.View;

public class GreetingController extends TemplateController {
  private static final String[] GREETINGS = { "Hello", "Greetings", "Salutations", "Hola" };
  private Random random = new Random();

  public GreetingController (View view) {
    super(view);
  }

  @Override
  public Map<String, List<String>> doRequest(HttpRequest request) {
    Map<String, List<String>> helloModel = new HashMap<>();
    helloModel.put("greetings", generateGreetings(request.getBody()));
    return helloModel;
  }

  private List<String> generateGreetings(String namesCommaSeparated) {
    List<String> greetings = new ArrayList<>();
    for (String name : namesCommaSeparated.split(",")) {
      greetings.add(makeGreeting(name));
    }
    return greetings;
  }

  private String makeGreeting(String name) {
    return String.format("%s, %s", GREETINGS[this.random.nextInt(4)], name);
  }
}
