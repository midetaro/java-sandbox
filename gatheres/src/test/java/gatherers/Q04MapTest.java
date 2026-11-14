package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題04 map の自作")
class Q04MapTest {

    @Test
    @DisplayName("各要素を変換して流す")
    void map() {
        assertEquals(List.of(2, 4, 6), Stream.of(1, 2, 3).gather(Q04Map.map(x -> x * 2)).toList());
    }

    @Test
    @DisplayName("型を変える変換もできる")
    void mapToOtherType() {
        assertEquals(List.of("1", "2"), Stream.of(1, 2).gather(Q04Map.<Integer, String>map(String::valueOf)).toList());
    }

    @Test
    @DisplayName("無限ストリームと limit を組み合わせても、必要な分だけ変換する")
    void worksWithLimit() {
        AtomicInteger calls = new AtomicInteger();
        List<Integer> result = Stream.iterate(1, i -> i + 1)
                .gather(Q04Map.map(x -> {
                    calls.incrementAndGet();
                    return x;
                }))
                .limit(3)
                .toList();
        assertEquals(List.of(1, 2, 3), result);
        assertEquals(3, calls.get());
    }
}
