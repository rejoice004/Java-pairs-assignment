class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void Divide(int a, int b)
        throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Logical error! Number cannot be divided by zero!");
        } else {
            System.out.println("Result is: " + a/b);
        }
    }

    public static void main(String[] args) {
        try {
            Divide(10, 0);
        } catch (DivisionByZeroException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            Divide(20, 2);
        } catch (DivisionByZeroException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
