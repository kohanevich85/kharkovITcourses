import java.util.Arrays;

public class ExceptionChainedExceptions {

    public static void main(String[] args) {
        try {
            f();
        } catch (RuntimeException e) {
            String[] messageArray = extractMessages(e);
            System.out.println(Arrays.toString(messageArray));
        }
    }

    public static void f() {
        RuntimeException tail = new RuntimeException("0");
        for (int k = 1; k < 10; k++) {
            tail = new RuntimeException("" + k, tail);
        }
        throw tail;
    }

    public static String[] extractMessages(Throwable t) {

        String[] messageArray = new String[10];
        int i = 0;
        while (t != null || i < 10) {
            messageArray[i] = t.getMessage();
            i++;
            t.getCause();
        }
        return messageArray;
    }
}
