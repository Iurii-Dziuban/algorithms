package iurii.job.interview.google;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class KeysAndRoomsTest {

    private KeysAndRooms keysAndRooms = new KeysAndRooms();

    @Test
    public void shouldFindShortestPathFromBeginningToEnd() {
        int minPath = keysAndRooms.findShortestPathFromBeginningToEnd(
            new String[]{"1 ", "0 ", "0 ", "7 ", "1 ", "2 ", "2 ", "2 ", "3 ", "7 "}
        );
        assertThat(minPath).isEqualTo(3);
    }
}