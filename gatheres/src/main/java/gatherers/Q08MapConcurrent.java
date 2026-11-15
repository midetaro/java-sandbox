package gatherers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Gatherers;

/**
 * 問題08: 遅い呼び出しを、順序を保って並行に実行する
 * 確認: ./gradlew test --tests '*Q08*'
 */
public final class Q08MapConcurrent {

    /**
     * ids を fetcher で変換する。同時実行数は最大3、結果は入力の順序で返す。
     */
    public static List<String> fetchAll(List<Integer> ids, Function<Integer, String> fetcher) {
        return
                ids.stream().gather(Gatherers.mapConcurrent(3, fetcher)).toList();
    }
}
