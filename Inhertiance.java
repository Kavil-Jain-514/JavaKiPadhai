class A {
    public void show1() {
        System.out.println("In A");
    }
}

class B extends A {
    public void show2() {
        System.out.println("In B");
    }
}

public class Inhertiance {
    public static void main(String[] args) {
        A obj = new B();
        B obj1 = (B) obj;
        obj1.show2();
        obj1.show1();
    }

}