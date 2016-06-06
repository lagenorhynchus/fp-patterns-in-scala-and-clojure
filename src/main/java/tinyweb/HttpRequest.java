package tinyweb;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
  private final Map<String, String> headers;
  private final String body;
  private final String path;

  private HttpRequest (Builder builder) {
    this.headers = Collections.unmodifiableMap(builder.headers);
    this.body = builder.body;
    this.path = builder.path;
  }

  public Map<String, String> getHeaders() {
    return this.headers;
  }

  public String getBody() {
    return this.body;
  }

  public String getPath() {
    return this.path;
  }

  public static class Builder {
    private Map<String, String> headers;
    private String body;
    private String path;

    private Builder() {
      this.headers = new HashMap<>();
    }

    public Builder addHeader(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public Builder path(String path) {
      this.path = path;
      return this;
    }

    public HttpRequest build() {
      return new HttpRequest(this);
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    public static Builder builderFrom(HttpRequest request) {
      Builder builder = new Builder()
        .path(request.getPath())
        .body(request.getBody());
      for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
        builder.addHeader(entry.getKey(), entry.getValue());
      }
      return builder;
    }
  }
}
