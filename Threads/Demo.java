class A extends Thread {
    public void run() {
        for(int i=1;i<=10; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
        }
    }
}

class B extends Thread {
    public void run() {
        for(int i=1;i<=10; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        A obj1 = new A();
        B obj2 = new B();
        obj1.start();
        obj2.start();
    }
}