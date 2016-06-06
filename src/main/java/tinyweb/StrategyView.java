package tinyweb;

import java.util.List;
import java.util.Map;

public class StrategyView implements View {
  private RenderingStrategy viewRenderer;

  public StrategyView (RenderingStrategy viewRenderer) {
    this.viewRenderer = viewRenderer;
  }

  @Override
  public String render(Map<String, List<String>> model) {
    try {
      return this.viewRenderer.renderView(model);
    } catch (Exception e) {
      throw new RenderingException(e);
    }
  }
}
