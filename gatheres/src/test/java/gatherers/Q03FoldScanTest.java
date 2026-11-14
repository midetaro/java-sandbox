package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題03 fold / scan")
class Q03FoldScanTest {

    private static final List<Integer> TRANSACTIONS = List.of(500, -300, 100, -700);

    @Test
    @DisplayName("scan: 各取引後の残高推移")
    void balanceHistory() {
        assertEquals(List.of(1500, 1200, 1300, 600), Q03FoldScan.balanceHistory(1000, TRANSACTIONS));
    }

    @Test
    @DisplayName("scan: 取引がなければ何も流さない")
    void balanceHistoryEmpty() {
        assertEquals(List.of(), Q03FoldScan.balanceHistory(1000, List.of()));
    }

    @Test
    @DisplayName("fold: 最終残高だけを要素1つで流す")
    void finalBalance() {
        assertEquals(List.of(600), Q03FoldScan.finalBalance(1000, TRANSACTIONS));
    }

    @Test
    @DisplayName("fold: 取引がなくても初期値を1つ流す")
    void finalBalanceEmpty() {
        assertEquals(List.of(1000), Q03FoldScan.finalBalance(1000, List.of()));
    }
}
