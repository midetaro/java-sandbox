package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題02 windowFixed / windowSliding")
class Q02WindowsTest {

    @Test
    @DisplayName("3個ずつに分割し、端数は最後の短い窓になる")
    void chunk() {
        assertEquals(List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7)),
                Q02Windows.chunk(List.of(1, 2, 3, 4, 5, 6, 7), 3));
    }

    @Test
    @DisplayName("3日間の移動平均")
    void movingAverage() {
        assertEquals(List.of(21.0, 22.0, 23.0),
                Q02Windows.movingAverage(List.of(20, 21, 22, 23, 24), 3));
    }

    @Test
    @DisplayName("日数に満たない入力では、全要素の平均が1つだけになる")
    void movingAverageShortInput() {
        assertEquals(List.of(20.5), Q02Windows.movingAverage(List.of(20, 21), 3));
    }
}
