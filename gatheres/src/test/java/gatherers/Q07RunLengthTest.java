package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題07 finisher（ランレングス圧縮）")
class Q07RunLengthTest {

    @Test
    @DisplayName("最後のまとまりも流す")
    void includesLastRun() {
        assertEquals(List.of("a3", "b1", "c2"),
                Stream.of("a", "a", "a", "b", "c", "c").gather(Q07RunLength.runLength()).toList());
    }

    @Test
    @DisplayName("要素が1つだけでも流す")
    void singleElement() {
        assertEquals(List.of("x1"), Stream.of("x").gather(Q07RunLength.runLength()).toList());
    }

    @Test
    @DisplayName("空の入力では何も流さない")
    void empty() {
        assertEquals(List.of(), Stream.<String>empty().gather(Q07RunLength.runLength()).toList());
    }
}
