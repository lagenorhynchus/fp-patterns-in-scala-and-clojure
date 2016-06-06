package tinyweb;

public class ControllerException extends RuntimeException {
  private int statusCode;

  public ControllerException (int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return this.statusCode;
  }
}
