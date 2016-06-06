package tinyweb;

public interface Filter {
  HttpRequest doFilter(HttpRequest request);
}
