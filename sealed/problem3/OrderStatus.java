package problem3;


public sealed interface OrderStatus permits Paid, Pending, Cancelled, Shipped{

}
