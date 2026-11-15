package gatherers;

import java.util.stream.Gatherer;

/**
 * 問題07: 最後のまとまりが消えるバグを直す
 * 確認: ./gradlew test --tests '*Q07*'
 *
 */
public final class Q07RunLength {

    static final class RunState {
        String value;
        int count;
    }

    public static Gatherer<String, ?, String> runLength() {
        return Gatherer.<String, RunState, String>ofSequential(
                RunState::new,
                (state, element, downstream) -> {
                    if (state.count > 0 && state.value.equals(element)) {
                        state.count++;
                        return true;
                    }
                    boolean accepted = state.count == 0
                            || downstream.push(state.value + state.count);
                    state.value = element;
                    state.count = 1;
                    return accepted;
                },
                (state,downstream) -> {
                    if(state.count > 0){
                        downstream.push(state.value + state.count);
                    }
                });
    }
}
