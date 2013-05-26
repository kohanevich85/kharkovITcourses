
public interface IDependencyTest {
    void printMe();
}

class Test1 implements IDependencyTest
{
    @Override
    public void printMe() {
        System.out.println("Test1");
    }
}


class Test2 implements IDependencyTest
{
    @Override
    public void printMe() {
        System.out.println("Test2");
    }
}

class TestTest {

    private IDependencyTest _test;

    public TestTest(IDependencyTest test) {
         _test = test;
    }

    public void print() {
        _test.printMe();
    }

    public static void main(String[] args) {
        new TestTest(new Test1()).print();
        new TestTest(new Test2()).print();
    }
}
