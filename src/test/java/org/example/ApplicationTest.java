package org.example;

import enrichment.EnrichmentByMsisdn;
import enrichment.EnrichmentService;
import enrichment.EnrichmentType;
import message.Message;
import org.junit.jupiter.api.Test;
import user.User;
import user.UserInformation;

import java.util.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {

    @Test
    public void checkForSuccessfulWorkInConcurrentEnvironment() throws InterruptedException {
        EnrichmentService enrichmentService = new EnrichmentService();
        UserInformation userInformation = new UserInformation();
        enrichmentService.addNewEnrichment(EnrichmentType.MSISDN, new EnrichmentByMsisdn(userInformation));

        String name1 = "Иван";
        String secondName1 = "Иванченко";
        String name2 = "НеИван";
        String secondName2 = "НеИванченко";
        String name3 = "ТожеНеИван";
        String secondName3 = "ТожеНеИванченко";
        String msisdn1 = "89999999999";
        String msisdn2 = "88888888888";
        String msisdn3 = "87777777777";

        User user1 = new User(name1, secondName1);
        User user2 = new User(name2, secondName2);
        User user3 = new User(name3, secondName3);

        userInformation.updateUserByMsisdn(msisdn1, user1);
        userInformation.updateUserByMsisdn(msisdn2, user2);
        userInformation.updateUserByMsisdn(msisdn3, user3);

        List<Message> messages = new ArrayList<>();

        ConcurrentHashMap<String, String> hashMap1 = new ConcurrentHashMap<>();
        hashMap1.put("action", "button_click");
        hashMap1.put("page", "book_card");
        hashMap1.put("msisdn", msisdn1);
        ConcurrentHashMap<String, String> hashMap2 = new ConcurrentHashMap<>();
        hashMap1.put("action", "button_click");
        hashMap1.put("page", "book_card");
        hashMap1.put("msisdn", msisdn2);
        ConcurrentHashMap<String, String> hashMap3 = new ConcurrentHashMap<>();
        hashMap1.put("action", "button_click");
        hashMap1.put("page", "book_card");
        hashMap1.put("msisdn", msisdn3);

        messages.add(new Message(hashMap1, EnrichmentType.MSISDN));
        messages.add(new Message(hashMap2, EnrichmentType.MSISDN));
        messages.add(new Message(hashMap3, EnrichmentType.MSISDN));

        List<Message> enrichmentResults = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(messages.size());

        for (int i = 0; i < messages.size(); i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    enrichmentResults.add(enrichmentService.enrich(messages.get(finalI)));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        boolean completed = latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();

        if (!completed) {
            executorService.shutdownNow();
            throw new IllegalStateException("Test timed out waiting for tasks to complete.");
        }

        List<Message> expectedMessages = new ArrayList<>();

        ConcurrentHashMap<String, String> expectedHashMap1 = new ConcurrentHashMap<>();
        expectedHashMap1.put("action", "button_click");
        expectedHashMap1.put("page", "book_card");
        expectedHashMap1.put("msisdn", msisdn1);
        expectedHashMap1.put("firstName", user1.getFirstName());
        expectedHashMap1.put("lastName", user1.getLastName());
        ConcurrentHashMap<String, String> expectedHashMap2 = new ConcurrentHashMap<>();
        expectedHashMap2.put("action", "button_click");
        expectedHashMap2.put("page", "book_card");
        expectedHashMap2.put("msisdn", msisdn1);
        expectedHashMap2.put("firstName", user2.getFirstName());
        expectedHashMap2.put("lastName", user2.getLastName());
        ConcurrentHashMap<String, String> expectedHashMap3 = new ConcurrentHashMap<>();
        expectedHashMap3.put("action", "button_click");
        expectedHashMap3.put("page", "book_card");
        expectedHashMap3.put("msisdn", msisdn1);
        expectedHashMap3.put("firstName", user3.getFirstName());
        expectedHashMap3.put("lastName", user3.getLastName());
        expectedMessages.add(new Message(expectedHashMap1, EnrichmentType.MSISDN));
        expectedMessages.add(new Message(expectedHashMap2, EnrichmentType.MSISDN));
        expectedMessages.add(new Message(expectedHashMap3, EnrichmentType.MSISDN));

        assertEquals(expectedMessages.size(), enrichmentResults.size(), "Size of results does not match expected.");

        for (Message expected : expectedMessages) {
            assertTrue(enrichmentResults.contains(expected), "Expected message not found: " + expected);
        }
    }
}
//Я не знаю почему не работает