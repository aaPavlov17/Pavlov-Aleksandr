package enrichment;

import message.Message;
import user.User;
import user.UserInformation;

public class EnrichmentByMsisdn implements Enrichable {
  UserInformation userInformation;

  public EnrichmentByMsisdn(UserInformation userInformation) {
    this.userInformation = userInformation;
  }

  @Override
  public void enrich(Message message) {
    if (message == null) {
      return;
    }
    EnrichmentType enrichmentType = message.getEnrichmentType();
    if (enrichmentType.equals(EnrichmentType.MSISDN)) {
      String msisdn = message.getByKey("msisdn");
      User user = userInformation.findByMsisdn(msisdn);
      if (user != null) {
        message.set("firstName", user.firstName);
        message.set("secondName", user.lastName);
      }
    }
  }
}
