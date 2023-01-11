package task3;

import java.util.ArrayList;
import java.util.List;

public class ValidateSudoku {

    public static boolean validate(final List<List<Integer>> sudokuList) {

        // Data structure dimension: NxN where N > 1 and √N == integer
        final int sudokuListSize = sudokuList.size();

        if (sudokuListSize <= 1) {
            return false;
        }

        int sqrtSize = (int) (Math.sqrt(sudokuListSize));
        if (sqrtSize * sqrtSize != sudokuListSize) {
            return false;
        }

        // ‘Small squares’ (3x3 in example above) should be √Nx√N
        for (List<Integer> el : sudokuList) {
            if (el.size() != sudokuListSize) {
                return false;
            }
        }

        // A number in multi-dimensional array may only appear once in a single row, column or in the Small square
        int element;
        for (int i = 0; i < sudokuListSize; i++) {
            for (int j = 0; j < sudokuListSize; j++) {
                element = sudokuList.get(i).get(j);
                for (int k = 0; k < sudokuListSize; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (element == sudokuList.get(i).get(k)) {
                        return false;
                    }

                }
                for (int k = 0; k < sudokuListSize; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (element == sudokuList.get(k).get(j)) {
                        return false;
                    }
                }
            }
        }

        List<Integer> temp;
        for (int i = 0; i < sudokuListSize; i += sqrtSize) {
            for (int j = 0; j < sudokuListSize; j += sqrtSize) {
                temp = new ArrayList<>();
                for (int k = 0; k < sqrtSize; k++) {
                    for (int l = 0; l < sqrtSize; l++) {
                        temp.add(sudokuList.get(i + k).get(j + l));
                    }
                }
                if (temp.stream().distinct().count() != sudokuListSize) {
                    return false;
                }
            }
        }

        return true;
    }
}
