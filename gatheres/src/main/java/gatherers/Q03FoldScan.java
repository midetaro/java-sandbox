package gatherers;

import java.util.List;
import java.util.stream.Gatherers;

/**
 * 問題03: fold / scan
 * 確認: ./gradlew test --tests '*Q03*'
 */
public final class Q03FoldScan {

    /** 各取引後の残高推移を返す。 */
    public static List<Integer> balanceHistory(int initial, List<Integer> transactions) {
        // TODO: Gatherers.scan を使う
        throw new UnsupportedOperationException("TODO: 問題03 balanceHistory");
    }

    /** 最終残高だけを要素1つのリストで返す。 */
    public static List<Integer> finalBalance(int initial, List<Integer> transactions) {
        // TODO: Gatherers.fold を使う
        throw new UnsupportedOperationException("TODO: 問題03 finalBalance");
    }
}
