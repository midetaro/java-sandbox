package problem1;

public record ShapeCalculator() {
    public static double area(Shape shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
            case Triangle t -> t.base() * t.height() / 2;
        };
    }
}
