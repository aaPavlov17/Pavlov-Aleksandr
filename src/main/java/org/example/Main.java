package org.example;

import enrichment.EnrichmentByMsisdn;
import enrichment.EnrichmentService;
import enrichment.EnrichmentType;
import message.Message;
import user.User;
import user.UserInformation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  public static void main(String[] args) {
    UserInformation userInformation = new UserInformation();
    User user = new User("Aleksandr", "Pavlov");
    userInformation.updateUserByMsisdn("86666666666", user);
    userInformation.getInformation();
    Map<String, String> DTO = new ConcurrentHashMap<>();
    DTO.put("action", "button_click");
    DTO.put("page", "book_card");
    DTO.put("msisdn", "86666666666");
    Message message = new Message(DTO, EnrichmentType.MSISDN);
    EnrichmentService enrichmentService = new EnrichmentService();
    enrichmentService.addNewEnrichment(EnrichmentType.MSISDN, new EnrichmentByMsisdn(userInformation));
    enrichmentService.enrich(message);
    System.out.println(message.getContent());
  }
}
