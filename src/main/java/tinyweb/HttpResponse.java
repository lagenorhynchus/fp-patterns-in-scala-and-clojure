package tinyweb;

public class HttpResponse {
  private final String body;
  private final int responseCode;

  private HttpResponse (Builder builder) {
    this.body = builder.body;
    this.responseCode = builder.responseCode;
  }

  public String getBody() {
    return this.body;
  }

  public int getResponseCode() {
    return this.responseCode;
  }

  public static class Builder {
    private String body;
    private int responseCode;

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public Builder responseCode(int responseCode) {
      this.responseCode = responseCode;
      return this;
    }

    public HttpResponse build() {
      return new HttpResponse(this);
    }

    public static Builder newBuilder() {
      return new Builder();
    }
  }
}
