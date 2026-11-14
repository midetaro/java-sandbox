package gatherers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("問題08 mapConcurrent")
class Q08MapConcurrentTest {

    private final AtomicInteger running = new AtomicInteger();
    private final AtomicInteger peak = new AtomicInteger();
    private final AtomicInteger virtualCalls = new AtomicInteger();

    /** 実行中の数を記録しながら、id が小さいほど遅く終わる呼び出し */
    private String slowFetch(int id) {
        int now = running.incrementAndGet();
        peak.accumulateAndGet(now, Math::max);
        if (Thread.currentThread().isVirtual()) {
            virtualCalls.incrementAndGet();
        }
        try {
            Thread.sleep(300 - id * 30L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            running.decrementAndGet();
        }
        return "user-" + id;
    }

    @Test
    @DisplayName("完了順にかかわらず、入力の順序で結果を返す")
    void keepsOrder() {
        assertEquals(List.of("user-1", "user-2", "user-3", "user-4", "user-5", "user-6"),
                Q08MapConcurrent.fetchAll(List.of(1, 2, 3, 4, 5, 6), this::slowFetch));
    }

    @Test
    @DisplayName("並行に実行し、同時実行数は3以下")
    void limitsConcurrency() {
        Q08MapConcurrent.fetchAll(List.of(1, 2, 3, 4, 5, 6), this::slowFetch);
        assertTrue(peak.get() > 1, "並行に実行されていない: 最大同時実行数 " + peak.get());
        assertTrue(peak.get() <= 3, "同時実行数が3を超えた: " + peak.get());
    }

    @Test
    @DisplayName("仮想スレッドで実行する")
    void usesVirtualThreads() {
        Q08MapConcurrent.fetchAll(List.of(1, 2, 3), this::slowFetch);
        assertEquals(3, virtualCalls.get());
    }
}
