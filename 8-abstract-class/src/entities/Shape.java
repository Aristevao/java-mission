package entities;

import enums.Color;

public abstract class Shape {
    private final Color color;

    public Color getColor() {
        return color;
    }

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract double area();
}
