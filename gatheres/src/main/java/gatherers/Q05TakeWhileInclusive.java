package gatherers;

import java.util.function.Predicate;
import java.util.stream.Gatherer;

/**
 * 問題05: 条件を外れた最初の要素まで含めて止める
 * 確認: ./gradlew test --tests '*Q05*'
 */
public final class Q05TakeWhileInclusive {

    public static <T> Gatherer<T, ?, T> takeWhileInclusive(Predicate<? super T> predicate) {
        return Gatherer.of((
                (_,element,downstream) ->
                    downstream.push(element) && predicate.test(element)
        ));
    }
}
