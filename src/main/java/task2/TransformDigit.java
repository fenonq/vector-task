package task2;

public class TransformDigit {

    public static int transform(final int n) {
        if (n == 0) {
            return 1;
        }

        int digit, result = 0, tens = 1;
        int number = n;
        while (number > 0) {
            digit = number % 10;
            result += tens * (digit + 1);

            if (digit == 9)
                tens *= 10;

            tens *= 10;
            number /= 10;
        }
        return result;
    }

}
