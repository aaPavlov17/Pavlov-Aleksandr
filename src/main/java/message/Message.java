package message;

import enrichment.EnrichmentType;


import java.util.Map;

public class Message {
  private final Map<String, String> content;
  private final EnrichmentType type;

  public Message(Map<String, String> content, EnrichmentType type) {
    this.content = content;
    this.type = type;
  }

  public String getByKey(String key) {
    return this.content.get(key);
  }

  public void set(String key, String value) {
    content.put(key, value);
  }

  public Map<String, String> getContent() {
    return content;
  }

  public EnrichmentType getEnrichmentType() {
    return type;
  }
}
