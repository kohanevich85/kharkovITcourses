
public class InterruptBuffer {

    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    synchronized void put(int newElem) {
        while (elem != null) {
            try {
                producers = new ThreadNode(Thread.currentThread(), producers);
                this.wait();
            } catch (InterruptedException e) {
                /*NOP*/
            }
        }
        elem = newElem;
        //not fair
        if (consumers != null) {
            consumers.thread.interrupt();
            consumers = consumers.nextNode;
        }
    }

    synchronized int get() {
        while (elem == null) {
            try {
                consumers = new ThreadNode(Thread.currentThread(), consumers);
                this.wait();
            } catch (InterruptedException e) {
                /*NOP*/
            }
        }
        int result = elem;
        elem = null;
        //not fair
        if (producers != null) {
            producers.thread.interrupt();
            producers = producers.nextNode;
        }
        return result;
    }
}

class ThreadNode {
    public final Thread thread;
    public final ThreadNode nextNode;

    public ThreadNode(Thread thread, ThreadNode nextNode) {
        this.thread = thread;
        this.nextNode = nextNode;
    }
}