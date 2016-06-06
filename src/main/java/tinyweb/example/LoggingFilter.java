package tinyweb.example;

import tinyweb.Filter;
import tinyweb.HttpRequest;

public class LoggingFilter implements Filter {
  @Override
  public HttpRequest doFilter(HttpRequest request) {
    System.out.println(String.format("In Logging Filter - request for path: %s", request.getPath()));
    return request;
  }
}
