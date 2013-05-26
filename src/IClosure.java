

public interface IClosure {
     int count();
}

class ClosureTest {

    private static IClosure getClosure(){
        final Integer a = 10;

        return new IClosure() {
            @Override
            public int count() {
                return a;
            }
        };
    }

    public static void main(String[] args) {
         IClosure c = getClosure();
         System.out.println(c.count());
    }
}