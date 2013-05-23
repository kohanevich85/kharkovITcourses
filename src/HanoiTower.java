import java.util.Stack;

public class HanoiTower {

    public static void exchange(Stack<Integer> from, Stack<Integer> help, Stack<Integer> to, int count) {
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggest = from.pop();
            to.push(biggest);
            exchange(help, from, to, count - 1);
        }
    }
}
