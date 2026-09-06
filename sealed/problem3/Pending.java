package problem3;

import problem3.OrderStatus;

import java.time.LocalDateTime;

public record Pending(LocalDateTime pendingStartAt) implements OrderStatus {

}