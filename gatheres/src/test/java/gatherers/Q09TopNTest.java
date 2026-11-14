package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題09 combiner（topN）")
class Q09TopNTest {

    @Test
    @DisplayName("逐次: 上位3件を降順で流す")
    void sequential() {
        assertEquals(List.of(1000, 999, 998), IntStream.rangeClosed(1, 1000).boxed().gather(Q09TopN.topN(3)).toList());
    }

    @Test
    @DisplayName("並列: 逐次と同じ結果になる")
    void parallel() {
        for (int i = 0; i < 20; i++) {
            assertEquals(List.of(1000, 999, 998),
                    IntStream.rangeClosed(1, 1000).boxed().parallel().gather(Q09TopN.topN(3)).toList());
        }
    }

    @Test
    @DisplayName("要素数が n 未満なら全件を降順で流す")
    void fewerThanN() {
        assertEquals(List.of(5, 2), Stream.of(2, 5).gather(Q09TopN.topN(3)).toList());
    }

    @Test
    @DisplayName("combiner を持ち、並列評価に対応している")
    void hasCombiner() {
        assertNotSame(Gatherer.defaultCombiner(), Q09TopN.topN(3).combiner(),
                "Gatherer.of(initializer, integrator, combiner, finisher) で作る");
    }
}
