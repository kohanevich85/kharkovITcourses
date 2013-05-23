
public class SingleListUtils {

    static Node add(Node tail, int elem) {

        if (tail == null) {

            tail = new Node(elem, tail);
            return tail;
        }
        Node ref = tail;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = new Node(elem, null);
        return tail;

    }

    static Node add(Node tail, int elem, int index) {
        if (index == 0) {
            return tail = new Node(elem, tail);

        }

        Node ref = tail;
        int counter = 0;
        boolean invalid = true;


        while (ref != null) {
            if (counter == index - 1) {
                ref.next = new Node(elem, ref.next);
                invalid = false;

                break;
            }
            counter++;
            ref = ref.next;
        }
        if (invalid || index < 0) {
            System.out.println("Sorry, I can't. Invalid of index. Please, try again :-)");
        }
        return tail;
    }

    static Node remove(Node tail) {

        if (tail == null) {
            System.out.println("Sorry, I can't. List is empty. Please, try again :-)");
            return tail;
        }
        if (tail.next == null) {
            return tail = tail.next;
        }

        Node ref = tail;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = ref.next.next;
        return tail;

    }

    static Node remove(Node tail, int index) {

        if (tail == null) {
            System.out.println("Sorry, I can't. List is empty. Please, try again :-)");

            return tail;
        }

        if (index == 0) {
            return tail = tail.next;

        }

        Node ref = tail;
        int counter = 0;
        boolean invalid = true;

        while (ref.next != null) {

            if (counter == index - 1) {
                ref.next = ref.next.next;
                invalid = false;

                break;
            }
            counter++;
            ref = ref.next;
        }

        if (invalid || index < 0) {
            System.out.println("Sorry, I can't. Invalid of index. Please, try again :-)");
        }
        return tail;
    }
}
