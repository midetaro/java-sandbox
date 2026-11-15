package gatherers;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

/**
 * 問題03: fold / scan
 * 確認: ./gradlew test --tests '*Q03*'
 */
public final class Q03FoldScan {

    /** 各取引後の残高推移を返す。 */
    public static List<Integer> balanceHistory(int initial, List<Integer> transactions) {
        return transactions
                .stream()
                .gather(Gatherers.scan(() -> initial,Integer::sum))
                .toList();
    }

    /** 最終残高だけを要素1つのリストで返す。 */
    public static List<Integer> finalBalance(int initial, List<Integer> transactions) {
        return transactions.stream()
                .gather(Gatherers.fold(()-> initial,Integer::sum))
                .toList();
    }
}
