package gatherers;

import java.util.function.Function;
import java.util.stream.Gatherer;

/**
 * 問題04: map を Gatherer で作り直す
 * 確認: ./gradlew test --tests '*Q04*'
 */
public final class Q04Map {

    /**
     * Gatherersの代わりにGatherer型のオブジェクトを書く
     */
    public static <T, R> Gatherer<T, ?, R> map(Function<? super T, ? extends R> mapper) {
        return Gatherer.of(Gatherer.Integrator.ofGreedy(
                (_,element,downstream) -> downstream.push(mapper.apply(element))
        ));
    }
}
