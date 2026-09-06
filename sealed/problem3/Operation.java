package problem3;

import java.time.LocalDateTime;

/**
 * case {型名} 変数名 -> (式);という形式。使用しないインスタンスにはアンスコが使える
 */
public record Operation(){

    void main(){
        OrderStatus status = new Pending(LocalDateTime.now());

        status = pay(status);
        status = ship(status);

        System.out.println(status); // Shipped
    }

    public OrderStatus pay(OrderStatus input){
        return switch(input){
            case Pending _ -> new Paid(LocalDateTime.now());
            case Shipped _, Cancelled _, Paid _ -> throw new IllegalStateException();
        };
    }

    public OrderStatus cancel(OrderStatus input){
        return switch(input){
            case Pending _, Paid _ -> new Cancelled(LocalDateTime.now());
            case Shipped _, Cancelled _ -> throw new IllegalStateException();
        };
    }
    public OrderStatus ship(OrderStatus input){
        return switch(input){
            case Paid p -> new Shipped(LocalDateTime.now());
            case Shipped _, Pending _, Cancelled _ -> throw new IllegalStateException();
        };
    }
}
