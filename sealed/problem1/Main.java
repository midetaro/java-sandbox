package problem1;

public record Main() {
    void main() {
        Shape c = new Circle(10);
        Shape r = new Rectangle(10, 1);
        Shape t = new Triangle(10, 1);
        IO.println(ShapeCalculator.area(c));
        IO.println(ShapeCalculator.area(r));
        IO.println(ShapeCalculator.area(t));
    }
}