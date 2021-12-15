package entities;

import enums.Color;

public class Rectangle extends Shape {
    private final Double width;
    private final Double height;

    public Rectangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
