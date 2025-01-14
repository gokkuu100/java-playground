interface FirstInterface {
    public void myMethod();
}
interface SecondInterface {
    public void myOtherMethod();
}

class Demo implements FirstInterface, SecondInterface {
    @Override
    public void myMethod() {
        System.out.println("My method one");
    }

    @Override
    public void myOtherMethod() {
        System.out.println("My other method two");
    }
}
public class Second {
    public static void main(String[] args) {
        Demo myObj = new Demo();
        myObj.myMethod();
        myObj.myOtherMethod();
    }
}




