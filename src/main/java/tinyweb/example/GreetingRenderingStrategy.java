package tinyweb.example;

import java.util.Map;
import java.util.List;

import tinyweb.RenderingStrategy;

public class GreetingRenderingStrategy implements RenderingStrategy {
  @Override
  public String renderView(Map<String, List<String>> model) {
    StringBuilder responseBody = new StringBuilder();
    responseBody.append("<h1>Friendly Greetings:</h1>\n");
    for (String greeting : model.get("greetings")) {
      responseBody.append("<h2>");
      responseBody.append(greeting);
      responseBody.append("</h2>\n");
    }
    return responseBody.toString();
  }
}
