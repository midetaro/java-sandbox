package gatherers;

import java.util.stream.Gatherer;
import java.util.stream.Stream;

/**
 * 問題10: andThen で合成し、1回の gather で実行する
 * 確認: ./gradlew test --tests '*Q10*'
 * 実行: このクラスの main を IDE から実行する
 */
public final class Q10Pipeline {

    /** 2個ずつの窓に分ける → 各窓の合計を取る → 累積和を出す */
    public static Gatherer<Integer, ?, Integer> pipeline() {
        // TODO: Gatherers.windowFixed、Q04Map.map、Gatherers.scan を andThen で合成する
        throw new UnsupportedOperationException("TODO: 問題10 pipeline");
    }

    static void main() {
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).gather(pipeline()).toList());
        System.out.println(Stream.of(1, 2, 3).gather(pipeline()).toList());
    }
}
