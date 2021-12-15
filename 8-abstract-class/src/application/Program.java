package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> list = new ArrayList<>();

        System.out.println("Enter the number of shapes: ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Shape #" + (i + 1));
            System.out.println("Rectangle or Circle (r/c)? ");
            char shapeType = sc.next().charAt(0);
            if (shapeType == 'r') {
                System.out.println("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next().toUpperCase());
                System.out.println("Width: ");
                double width = sc.nextDouble();
                System.out.println("Height: ");
                double height = sc.nextDouble();

                list.add(new Rectangle(color, width, height));
            } else {
                System.out.println("Radius: ");
                double radius = sc.nextDouble();
                System.out.println("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next().toUpperCase());

                list.add(new Circle(color, radius));
            }
        }

        System.out.println("\nShapes: ");
        for (Shape shape : list) {
            System.out.printf("Color: " + shape.getColor() + " | Area: " + "%.2f%n", shape.area());
        }

        sc.close();
    }
}
