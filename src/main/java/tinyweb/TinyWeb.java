package tinyweb;

import java.util.List;
import java.util.Map;

public class TinyWeb {
  private Map<String, Controller> controllers;
  private List<Filter> filters;

  public TinyWeb (Map<String, Controller> controllers, List<Filter> filters) {
    this.controllers = controllers;
    this.filters = filters;
  }

  public HttpResponse handleRequest(HttpRequest request) {
    HttpRequest currentRequest = request;
    for (Filter filter : filters) {
      currentRequest = filter.doFilter(currentRequest);
    }
    Controller controller = controllers.get(currentRequest.getPath());
    if (controller == null) {
      return null;
    }
    return controller.handleRequest(currentRequest);
  }
}
