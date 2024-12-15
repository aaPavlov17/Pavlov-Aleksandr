package enrichment;

import message.Message;
import java.util.concurrent.ConcurrentHashMap;

public class EnrichmentService {
  private final ConcurrentHashMap<EnrichmentType, Enrichable> hashMap = new ConcurrentHashMap<>();

  public void addNewEnrichment(EnrichmentType type, Enrichable enrichment) {
    hashMap.put(type, enrichment);
  }

  public Message enrich(Message message) {
    enrich(message, message.getEnrichmentType());
    return message;
  }

  private void enrich(Message message, EnrichmentType type) {
    Enrichable enrichment = hashMap.get(type);
    enrichment.enrich(message);
  }
}
