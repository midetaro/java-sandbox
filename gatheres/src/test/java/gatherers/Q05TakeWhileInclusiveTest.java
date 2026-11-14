package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題05 takeWhileInclusive")
class Q05TakeWhileInclusiveTest {

    @Test
    @DisplayName("条件を外れた最初の要素まで含めて止まる")
    void includesFirstFailingElement() {
        assertEquals(List.of(3, 5, 4),
                Stream.of(3, 5, 4, 2, 1).gather(Q05TakeWhileInclusive.takeWhileInclusive(x -> x != 4)).toList());
    }

    @Test
    @DisplayName("条件を外れる要素がなければすべて流す")
    void allMatch() {
        assertEquals(List.of(1, 2, 3),
                Stream.of(1, 2, 3).gather(Q05TakeWhileInclusive.takeWhileInclusive(x -> true)).toList());
    }

    @Test
    @DisplayName("無限ストリームでも止まる")
    void infiniteStream() {
        // 止まらない実装でもテストが終わるよう、limit(100) で上限を付けている
        List<Integer> result = Stream.iterate(1, i -> i + 1)
                .gather(Q05TakeWhileInclusive.takeWhileInclusive(x -> x < 5))
                .limit(100)
                .toList();
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }
}
