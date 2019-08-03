package pl.programator.models;

import org.junit.jupiter.api.Test;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

class CustomWebsiteTest {
    private Reporter reporter1 = new Reporter("Patryk");
    private Reporter reporter2 = new Reporter("Maciej");
    private Reporter reporter3 = new Reporter("Michał");


    private CustomWebsite customWebsite1 = new CustomWebsite();
    private CustomWebsite customWebsite2 = new CustomWebsite();
    private CustomWebsite customWebsite3 = new CustomWebsite();

    @Test
    void countPoints() {

        reporter1.broadcastMessage("Patryk Igras");
        reporter2.broadcastMessage("a b c k");
        reporter3.broadcastMessage("");

        assertAll(
                () -> assertEquals(5, customWebsite1.countPoints(reporter1)),
                () -> assertEquals(4, customWebsite2.countPoints(reporter2)),
                () -> assertEquals(0, customWebsite3.countPoints(reporter3))
        );
    }

        @Test
        void capitalMsg() {
            Reporter reporter1 = new Reporter("Adam1");
            Reporter reporter2 = new Reporter("Adam2");
            Reporter reporter3 = new Reporter("Adam3");
            Reporter reporter4 = new Reporter("Adam4");
            reporter1.broadcastMessage("");
            reporter2.broadcastMessage(null);
            reporter3.broadcastMessage("AaB 99 ; - ą bCc");
            reporter4.broadcastMessage("lllla");
            CustomWebsite customWebsite1 = new CustomWebsite();
            CustomWebsite customWebsite2 = new CustomWebsite();
            CustomWebsite customWebsite3 = new CustomWebsite();
            CustomWebsite customWebsite4 = new CustomWebsite();
            assertAll(
                    () ->  assertEquals(valueOf(customWebsite1.capitalMsg(reporter1)), ""),
                    () ->  assertNull(customWebsite2.capitalMsg(reporter2)),
                    () ->  assertEquals(valueOf(customWebsite3.capitalMsg(reporter3)), "AAB 99 ; - ą BCC"),
                    () ->  assertEquals(valueOf(customWebsite4.capitalMsg(reporter4)), "llllA")

            );
    }
}