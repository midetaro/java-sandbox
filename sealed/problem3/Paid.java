package problem3;

import problem3.OrderStatus;

import java.time.LocalDateTime;

public record Paid(LocalDateTime paidAt) implements OrderStatus {

}