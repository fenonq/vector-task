package task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidateSudokuTest {

    final List<List<Integer>> validSudoku9 = new ArrayList<>(List.of(
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

    final List<List<Integer>> validSudoku4 = new ArrayList<>(List.of(
            List.of(7, 8,  4, 1),
            List.of(5, 3,  9, 6),

            List.of(6, 1,  2, 4),
            List.of(9, 2,  8, 7)
    ));

    final List<List<Integer>> notValidSudokuRow = new ArrayList<>(List.of(
            List.of(7, 8,  4, 8),
            List.of(5, 3,  9, 6),

            List.of(6, 1,  2, 4),
            List.of(9, 2,  8, 7)
    ));

    final List<List<Integer>> notValidSudokuColumn = new ArrayList<>(List.of(
            List.of(7, 8,  4, 1),
            List.of(5, 3,  9, 6),

            List.of(7, 1,  2, 4),
            List.of(9, 2,  8, 7)
    ));

    final List<List<Integer>> notValidSudoku5X5 = new ArrayList<>(List.of(
            List.of(7, 8, 4, 1, 2),
            List.of(5, 3, 9, 6, 4),
            List.of(3, 1, 2, 4, 6),
            List.of(9, 2, 8, 7, 5)
    ));

    final List<List<Integer>> notValidSudoku5X4 = new ArrayList<>(List.of(
            List.of(7, 8,  4, 1),
            List.of(5, 3,  9, 6),

            List.of(6, 1,  2, 4),
            List.of(9, 2,  8, 7),

            List.of(1, 4,  6, 8)
    ));

    final List<List<Integer>> notValidSudokuSmallSquare = new ArrayList<>(List.of(
            List.of(7, 8,  4, 1),
            List.of(5, 7,  9, 6),

            List.of(6, 1,  2, 4),
            List.of(9, 2,  8, 7)
    ));

    @Test
    void validSudoku9X9Test() {
        assertTrue(ValidateSudoku.validate(validSudoku9));
    }

    @Test
    void validSudoku4X4Test() {
        assertTrue(ValidateSudoku.validate(validSudoku4));
    }

    @Test
    void notValidSudokuRowTest() {
        assertFalse(ValidateSudoku.validate(notValidSudokuRow));
    }

    @Test
    void notValidSudokuColumnTest() {
        assertFalse(ValidateSudoku.validate(notValidSudokuColumn));
    }

    @Test
    void notValidSudokuEmptyTest() {
        assertFalse(ValidateSudoku.validate(new ArrayList<>()));
    }

    @Test
    void notValidSudoku5X5Test() {
        assertFalse(ValidateSudoku.validate(notValidSudoku5X5));
    }

    @Test
    void notValidSudoku5X4Test() {
        assertFalse(ValidateSudoku.validate(notValidSudoku5X4));
    }

    @Test
    void notValidSudokuSmallSquareTest() {
        assertFalse(ValidateSudoku.validate(notValidSudokuSmallSquare));
    }

}
