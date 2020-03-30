package ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UnsuccessfulPostRequestCounterTest {

    @Test
    void testCountingUnsuccessfulPostRequest() {
        UnsuccessfulPostRequestCounter counter = new UnsuccessfulPostRequestCounter();
        counter.countUnsuccessfulPostRequestFromFileBetween10and11oclock("access.log");
        assertEquals(2, counter.countUnsuccessfulPostRequestFromFileBetween10and11oclock("access.log"));
    }
}