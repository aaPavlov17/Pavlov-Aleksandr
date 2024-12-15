package enrichment;

import message.Message;
import org.junit.jupiter.api.Test;
import user.User;
import user.UserInformation;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EnrichmentByMsisdnTest {

    @Test
    public void enrich() {
        UserInformation repository = new UserInformation();
        User user = new User("Иван", "Иванченко");
        String msisdn = "8800535535";
        repository.updateUserByMsisdn(msisdn, user);
        EnrichmentByMsisdn msisdnEnrichment = new EnrichmentByMsisdn(repository);
        Map<String, String> content =
                new HashMap<>(
                        Map.of(
                                "action", "button_click",
                                "page", "book_card",
                                "msisdn", msisdn));
        Message message = new Message(content, EnrichmentType.MSISDN);
        msisdnEnrichment.enrich(message);
        Map<String, String> currentResult = message.getContent();
        content.put("firstName", "Иван");
        content.put("lastName", "Иванченко");
        Map<String, String> expectedResult = content;
        assertEquals(currentResult, expectedResult);
    }
}