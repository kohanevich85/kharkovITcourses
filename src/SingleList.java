
public class SingleList {

    static int lengtht(Node tail) {

        int length = 0;
        Node ref = tail;
        while (ref != null) {
            length++;
            ref = ref.next;
        }
        return length;
    }

    static int max(Node tail) {

        Node ref = tail;
        int max = ref.value;
        while (ref != null) {
            if (max < ref.value) {
                max = ref.value;
            }
            ref = ref.next;
        }
        return max;
    }

    static int sum(Node tail) {

        Node ref = tail;
        int sum = ref.value;
        while (ref.next != null) {
            ref = ref.next;
            sum += ref.value;
        }
        return sum;
    }
}

class Node {
    public int value;
    public Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
