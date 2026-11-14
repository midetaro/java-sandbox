package gatherers;

import java.util.function.Function;
import java.util.stream.Gatherer;

/**
 * 問題06: キーで重複を判定し、最初に現れた要素だけを残す
 * 確認: ./gradlew test --tests '*Q06*'
 */
public final class Q06DistinctBy {

    public static <T, K> Gatherer<T, ?, T> distinctBy(Function<? super T, ? extends K> keyExtractor) {
        // TODO: Gatherer.ofSequential(initializer, integrator) で状態を持たせる
        throw new UnsupportedOperationException("TODO: 問題06 distinctBy");
    }
}
