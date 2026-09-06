package problem3;


import java.time.LocalDateTime;

public record Shipped(LocalDateTime shippedAt) implements OrderStatus {

}