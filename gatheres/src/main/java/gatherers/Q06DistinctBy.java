package gatherers;

import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Gatherer;

/**
 * 問題06: キーで重複を判定し、最初に現れた要素だけを残す
 * 確認: ./gradlew test --tests '*Q06*'
 */
public final class Q06DistinctBy {

    public static <T, K> Gatherer<T, ?, T> distinctBy(Function<? super T, ? extends K> keyExtractor) {
        return Gatherer.ofSequential(
                HashSet<K>::new,
                Gatherer.Integrator.ofGreedy((seen,element,downstream) ->{
                        if(seen.add(keyExtractor.apply(element))){
                            return downstream.push(element);
                        }
                        return true;}
        ));
    }
}
