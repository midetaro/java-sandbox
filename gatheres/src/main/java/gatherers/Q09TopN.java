package gatherers;

import java.util.stream.Gatherer;

/**
 * 問題09: parallel() でも正しい上位 n 件
 * 確認: ./gradlew test --tests '*Q09*'
 */
public final class Q09TopN {

    /** 上位 n 件を降順で流す。 */
    public static Gatherer<Integer, ?, Integer> topN(int n) {
        throw new UnsupportedOperationException("TODO: 問題09 topN");
    }
}
