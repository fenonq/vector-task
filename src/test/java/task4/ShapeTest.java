package task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void sortTest() {
        int side = 3;
        int radius = 1;
        int base = 5;
        int height = 2;
        List<Shape> shapes = new ArrayList<>() {
            @Override
            public boolean add(Shape shape) {
                super.add(shape);
                Collections.sort(this);
                return true;
            }
        };
        shapes.add(new Square(side));
        shapes.add(new Circle(radius));
        shapes.add(new Triangle(base, height));

        for (int i = 1; i < shapes.size(); i++) {
            assertTrue(shapes.get(i - 1).area() < shapes.get(i).area());
        }
    }

}
