package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題06 distinctBy")
class Q06DistinctByTest {

    @Test
    @DisplayName("キーが最初に現れた要素だけを残す")
    void firstOccurrence() {
        assertEquals(List.of("apple", "banana", "cherry"),
                Stream.of("apple", "avocado", "banana", "blueberry", "cherry")
                        .gather(Q06DistinctBy.distinctBy(s -> s.charAt(0)))
                        .toList());
    }

    @Test
    @DisplayName("同じ Gatherer を別の Stream で使っても状態を共有しない")
    void stateIsNotShared() {
        Gatherer<String, ?, String> byLength = Q06DistinctBy.distinctBy(String::length);
        assertEquals(List.of("a", "bb"), Stream.of("a", "b", "bb").gather(byLength).toList());
        assertEquals(List.of("c", "dd"), Stream.of("c", "dd").gather(byLength).toList());
    }

    @Test
    @DisplayName("キーが null でも扱える")
    void nullKey() {
        Function<String, String> nullable = s -> s.isEmpty() ? null : s;
        assertEquals(List.of("", "x"), Stream.of("", "", "x").gather(Q06DistinctBy.distinctBy(nullable)).toList());
    }
}
