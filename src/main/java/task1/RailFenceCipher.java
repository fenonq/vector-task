package task1;


public class RailFenceCipher {

    public static String encode(final String text, final int number) {
        if (number < 2) {
            return text;
        }

        final StringBuilder result = new StringBuilder();
        boolean check = false;
        int j = 0;
        final int column = text.length();
        final char[][] a = new char[number][column];

        for (int i = 0; i < column; i++) {
            if (j == 0 || j == number - 1) {
                check = !check;
            }
            a[j][i] = text.charAt(i);

            if (check)
                ++j;
            else
                --j;
        }

        for (int i = 0; i < number; i++) {
            for (int k = 0; k < column; k++) {
                if (a[i][k] != 0)
                    result.append(a[i][k]);
            }
        }
        return result.toString();
    }

    public static String decode(final String text, final int number) {
        if (number < 2) {
            return text;
        }

        final StringBuilder result = new StringBuilder();
        boolean check = false;
        int j = 0;
        final int column = text.length();
        final char[][] a = new char[number][column];

        for (int i = 0; i < column; i++) {
            if (j == 0 || j == number - 1) {
                check = !check;
            }
            a[j][i] = '*';

            if (check)
                ++j;
            else
                --j;
        }

        int index = 0;
        check = false;
        for (int i = 0; i < number; i++) {
            for (int k = 0; k < column; k++) {
                if (a[i][k] == '*' && index < column) {
                    a[i][k] = text.charAt(index++);
                }
            }
        }

        j = 0;
        for (int i = 0; i < column; i++) {
            if (j == 0 || j == number - 1) {
                check = !check;
            }
            result.append(a[j][i]);

            if (check)
                ++j;
            else
                --j;
        }
        return result.toString();
    }

}
