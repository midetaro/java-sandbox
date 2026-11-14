package gatherers;

import java.util.function.Function;
import java.util.stream.Gatherer;

/**
 * 問題04: map を Gatherer で作り直す
 * 確認: ./gradlew test --tests '*Q04*'
 */
public final class Q04Map {

    public static <T, R> Gatherer<T, ?, R> map(Function<? super T, ? extends R> mapper) {
        // TODO: Gatherer.of と Gatherer.Integrator.ofGreedy を使う
        throw new UnsupportedOperationException("TODO: 問題04 map");
    }
}
