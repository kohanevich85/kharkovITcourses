/**
 * Created with IntelliJ IDEA.
 * User: eugene
 * Date: 5/23/13
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursionParser {

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == '(') {
            if (expr.charAt(to - 1) == ')') {
                return eval(expr, from + 1, to - 1);
            } else {
                int findPos = from + 1;
                while (findPos < to) {
                    if (expr.charAt(findPos - 1) != ')') {
                        findPos++;
                    } else {
                        break;
                    }
                }
                return calculate(expr.charAt(findPos), eval(expr, from + 1, findPos - 1), eval(expr, findPos + 1, to));
            }
        } else {
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {

                    return calculate(expr.charAt(pos), Integer.valueOf(expr.substring(from, pos)), eval(expr, pos + 1, to));
                }
            }
            return Integer.valueOf(expr.substring(from, to));
        }
    }

    private static int calculate(char operation, int leftOperand, int rightOperand) {
        int result = 0;
        switch (operation) {
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
        }
        return result;
    }
}
