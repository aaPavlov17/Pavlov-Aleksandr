package enrichment;

import message.Message;
import org.junit.jupiter.api.Test;
import user.User;
import user.UserInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EnrichmentServiceTest {

    @Test
    public void addNewEnrichment() {
        UserInformation repository = new UserInformation();
        User user = new User("Иван", "Иванченко");
        String msisdn = "8800535535";
        repository.updateUserByMsisdn(msisdn, user);

        EnrichmentByMsisdn msisdnEnrichment = new EnrichmentByMsisdn(repository);
        EnrichmentService service = new EnrichmentService();
        service.addNewEnrichment(EnrichmentType.MSISDN, msisdnEnrichment);
        ArrayList<EnrichmentType> currentResult = new ArrayList<>();
        currentResult.add(EnrichmentType.MSISDN);
        ArrayList<EnrichmentType> expectedResult =
                new ArrayList<>() {
                    {
                        add(EnrichmentType.MSISDN);
                    }
                };
        assertEquals(currentResult, expectedResult);
    }

    @Test
    public void enrichWithoutUser() {
        UserInformation repository = new UserInformation();
        EnrichmentByMsisdn msisdnEnrichment = new EnrichmentByMsisdn(repository);
        EnrichmentService service = new EnrichmentService();
        service.addNewEnrichment(EnrichmentType.MSISDN, msisdnEnrichment);

        Map<String, String> content =
                new HashMap<>(
                        Map.of(
                                "action", "button_click",
                                "page", "book_card",
                                "time", "10",
                                "msisdn", "8800535535"));
        Message message = new Message(content, EnrichmentType.MSISDN);
        Map<String, String> currentRes = service.enrich(message).getContent();
        Map<String, String> expectedResult = content;
        assertEquals(currentRes, expectedResult);
    }

}