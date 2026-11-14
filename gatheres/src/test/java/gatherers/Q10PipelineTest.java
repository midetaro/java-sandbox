package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題10 andThen による合成")
class Q10PipelineTest {

    @Test
    @DisplayName("2個ずつの窓 → 合計 → 累積和")
    void pipeline() {
        assertEquals(List.of(3, 10, 21, 36, 55),
                Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).gather(Q10Pipeline.pipeline()).toList());
    }

    @Test
    @DisplayName("端数の窓も合計に含める")
    void oddLength() {
        assertEquals(List.of(3, 6), Stream.of(1, 2, 3).gather(Q10Pipeline.pipeline()).toList());
    }
}
