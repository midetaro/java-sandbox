package gatherers;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

/**
 * 問題02: windowFixed / windowSliding
 * 確認: ./gradlew test --tests '*Q02*'
 */
public final class Q02Windows {

    /** input を size 個ずつの窓に分ける。端数は最後の短い窓にする。 */
    public static List<List<Integer>> chunk(List<Integer> input, int size) {
        return input
                .stream()
                .gather(Gatherers.windowFixed(size))
                .toList();
    }

    /** days 日間の移動平均を求める。 */
    public static List<Double> movingAverage(List<Integer> temperatures, int days) {
        return temperatures
                .stream()
                .gather(Gatherers.windowSliding(days))
                .map(w -> w.stream().mapToInt(Integer::intValue).average().orElseThrow())
                .toList();
    }
}
