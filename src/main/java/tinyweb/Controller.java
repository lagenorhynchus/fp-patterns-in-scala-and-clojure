package tinyweb;

public interface Controller {
  HttpResponse handleRequest(HttpRequest request);
}
