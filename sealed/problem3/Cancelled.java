package problem3;

import java.time.LocalDateTime;

public record Cancelled(LocalDateTime cancelledAt) implements OrderStatus{

}