import task1.RailFenceCipher;
import task2.TransformDigit;
import task3.ValidateSudoku;
import task4.Circle;
import task4.Shape;
import task4.Square;
import task4.Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // task1 ===============================================================
        System.out.println("\n\ttask1");
        final String text = "WEAREDISCOVEREDFLEEATONCE";
        final int number = 3;
        final String encodedText = RailFenceCipher.encode(text, number);
        System.out.printf(
                "Text to encode: %s\n" +
                        "Number of rails: %d\n" +
                        "Encoded text: %s\n",
                text, number, encodedText);
        final String decodedText = RailFenceCipher.decode(encodedText, number);
        System.out.printf("Decoded text: %s\n", decodedText);
        // task1 ===============================================================

        // task2 ===============================================================
        System.out.println("\n\ttask2");
        System.out.println(TransformDigit.transform(998));
        // task2 ===============================================================

        // task3 ===============================================================
        System.out.println("\n\ttask3");
        final List<List<Integer>> sudokuList = new ArrayList<>(List.of(
                List.of(7, 8, 4,  1, 5, 9,  3, 2, 6),
                List.of(5, 3, 9,  6, 7, 2,  8, 4, 1),
                List.of(6, 1, 2,  4, 3, 8,  7, 5, 9),

                List.of(9, 2, 8,  7, 1, 5,  4, 6, 3),
                List.of(3, 5, 7,  8, 4, 6,  1, 9, 2),
                List.of(4, 6, 1,  9, 2, 3,  5, 8, 7),

                List.of(8, 7, 6,  3, 9, 4,  2, 1, 5),
                List.of(2, 4, 3,  5, 6, 1,  9, 7, 8),
                List.of(1, 9, 5,  2, 8, 7,  6, 3, 4)
        ));
        System.out.println(ValidateSudoku.validate(sudokuList));
        // task3 ===============================================================

        // task4 ===============================================================
        System.out.println("\n\ttask4");
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
//        Collections.sort(shapes);
        System.out.println(shapes);
        // task4 ===============================================================

    }
}
