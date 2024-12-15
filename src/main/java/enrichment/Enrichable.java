package enrichment;

import message.Message;

public interface Enrichable {
  void enrich(Message message);
}
