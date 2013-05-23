
public class DoubleListUtils {

    static DoubleNode add(DoubleNode tail, int elem) {


        if (tail == null) {
            return tail = new DoubleNode(elem, null, null);
        }
        DoubleNode ref = tail;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = new DoubleNode(elem, ref, null);

        return tail;
    }

    static DoubleNode add(DoubleNode tail, int elem, int index) {

        if (index < 0) {
            System.out.println("Sorry, I can't. Invalid of index. Please, try again :-)" + "\n" + "Index of: " + index);
            return tail;
        }
        if (index == 0) {
            if (tail == null) {
                return tail = new DoubleNode(elem, null, null);
            }else{

                tail.prev = new DoubleNode(elem, null, tail);
                return tail = tail.prev;
            }
        }
        DoubleNode ref = tail;
        int counter = 0;
        boolean invalid = true;
        while (ref != null) {
            if (counter == index - 1) {
                ref.next = new DoubleNode(elem, ref, ref.next);

                if(ref.next.next != null){

                    ref.next.next.prev = ref.next;
                }
                invalid = false;
                break;
            }
            counter++;
            ref = ref.next;
        }
        if (invalid) {
            System.out.println("Sorry, I can't. Invalid of index. Please, try again :-)" + "\n" + "Index of: " + index);
        }
        return tail;
    }

    static DoubleNode remove(DoubleNode tail) {

        if (tail == null) {
            System.out.println("Sorry, I can't. List is empty. Please, try again :-)");
            return tail;
        }
        if (tail.next == null) {
            return tail = null;
        }
        DoubleNode ref = tail;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;

        return tail;
    }

    static DoubleNode remove(DoubleNode tail, int index) {

        if (index < 0) {
            System.out.println("Sorry, I can't. Invalid of index. Please, try again :-)" + "\n" + "Index of: " + index);
            return tail;
        }
        if (tail == null) {
            System.out.println("Sorry, I can't. List is empty. Please, try again :-)");
            return tail;
        }

        if (index == 0) {
            tail.next.prev = null;
            return tail = tail.next;
        }

        DoubleNode ref = tail;
        int counter = 0;
        boolean invalid = true;
        while (ref.next != null) {

            if (counter == index - 1) {
                ref.next = ref.next.next;
                if (ref.next != null) {


                    ref.next.prev = ref;
                }
                invalid = false;
                break;
            }
            counter++;
            ref = ref.next;
        }
        if (invalid) {
            System.out.println("Sorry, I can't. Invalid of index. Please, try again :-)" + "\n" + "Index of: " + index);
        }
        return tail;
    }
}
class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode(int value, DoubleNode prev, DoubleNode next){
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}