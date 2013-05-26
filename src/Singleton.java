
public class Singleton {

    public static final Singleton instance = new Singleton();

    private Singleton(){
    }

    public void print(){
        System.out.println("Singleton");
    }
}

class Test{

    public static void main(String[] args) {

        Singleton.instance.print();
    }
}